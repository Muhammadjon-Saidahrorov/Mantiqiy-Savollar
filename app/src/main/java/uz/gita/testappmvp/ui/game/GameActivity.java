package uz.gita.testappmvp.ui.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uz.gita.testappmvp.R;
import uz.gita.testappmvp.model.TestData;

public class GameActivity extends AppCompatActivity implements GameContract.View {
    private GameContract.Presenter presenter;
    private List<RadioButton> radios;
    private List<AppCompatTextView> variants;
    private AppCompatTextView questionText;
    private AppCompatTextView currentPosText;
    private AppCompatButton skipButton;
    private AppCompatButton nextButton;
    private AppCompatImageView backButton;
    private ProgressBar progressBar;
    private MediaPlayer mediaCorrect;
    private MediaPlayer mediaWrong;
    private MediaPlayer mediaWin;
    private AppCompatImageView musicButton;
    private boolean musicLog;
    private int count;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        loadViews();
        clickButtons();

        presenter = new GamePresenter(this);

    }

    private void loadViews() {
        radios = new ArrayList<>(4);
        radios.add(findViewById(R.id.radio1));
        radios.add(findViewById(R.id.radio2));
        radios.add(findViewById(R.id.radio3));
        radios.add(findViewById(R.id.radio4));

        variants = new ArrayList<>(4);
        variants.add(findViewById(R.id.text1));
        variants.add(findViewById(R.id.text2));
        variants.add(findViewById(R.id.text3));
        variants.add(findViewById(R.id.text4));

        questionText = findViewById(R.id.textQuestion);
        currentPosText = findViewById(R.id.textCurrentPos);
        skipButton = findViewById(R.id.buttonSkip);
        nextButton = findViewById(R.id.buttonNext);
        backButton = findViewById(R.id.buttonBack);

        progressBar = findViewById(R.id.progressBar);
        count = 1;

        mediaCorrect = MediaPlayer.create(this, R.raw.positive);
        mediaWrong = MediaPlayer.create(this, R.raw.negative);
        mediaWin = MediaPlayer.create(this,R.raw.bg_won);

        musicButton = findViewById(R.id.buttonMusic);
        preferences = this.getSharedPreferences("TESTAPP", GameActivity.MODE_PRIVATE);

    }

    private void clickButtons() {
        skipButton.setOnClickListener(v -> {
            progressBar.setProgress(count++);
            progressBar.setMax(10);
            presenter.clickSkipButton();
        });

        nextButton.setOnClickListener(v -> {
            progressBar.setProgress(count++);
            progressBar.setMax(10);
            presenter.clickNextButton();
        });

        backButton.setOnClickListener(v -> finish());

        musicButton.setOnClickListener(v -> {
            if (musicLog) {
                musicLog = false;
                musicButton.setImageResource(R.drawable.music_off);
            } else {
                musicLog = true;
                musicButton.setImageResource(R.drawable.music_on);
            }
        });

        for (int i = 0; i < radios.size(); i++) {
            int finalI = i;

            variants.get(i).setOnClickListener(v -> {
                clearOldAnswer();
                radios.get(finalI).setChecked(true);
                if (presenter.testAnswer(String.valueOf(variants.get(finalI).getText()))) {
                    if (musicLog)
                        mediaCorrect.start();
                } else {
                    if (musicLog)
                        mediaWrong.start();
                }
                setColor();
                presenter.selectUserAnswer(variants.get(finalI).getText().toString());
            });

            radios.get(i).setOnClickListener(v -> {
                clearOldAnswer();
                radios.get(finalI).setChecked(true);
                if (presenter.testAnswer(String.valueOf(variants.get(finalI).getText()))) {
                    if (musicLog)
                        mediaCorrect.start();
                } else {
                    if (musicLog)
                        mediaWrong.start();
                }
                setColor();
                presenter.selectUserAnswer(variants.get(finalI).getText().toString());
            });
        }
    }

    private void setColor() {

        for (int i = 0; i < 4; i++) {
            if (presenter.testAnswer(String.valueOf(variants.get(i).getText()))) {
                variants.get(i).setBackgroundColor(Color.parseColor("#56D114"));
                radios.get(i).setBackgroundColor(Color.parseColor("#56D114"));
            } else {
                variants.get(i).setBackgroundColor(Color.parseColor("#FFDA1111"));
                radios.get(i).setBackgroundColor(Color.parseColor("#FFDA1111"));
            }
            radios.get(i).setEnabled(false);
            variants.get(i).setEnabled(false);
        }
        skipButton.setEnabled(false);
    }


    @Override
    public void clearOldAnswer() {
        for (int i = 0; i < radios.size(); i++) {
            if (radios.get(i).isChecked()) radios.get(i).setChecked(false);
        }
    }

    @Override
    public void describeTest(TestData testData, int currentPos, int totalCount) {
        questionText.setText(testData.getQuestion());

        currentPosText.setText(currentPos + "/" + totalCount);

        variants.get(0).setText(testData.getVariant1());
        variants.get(1).setText(testData.getVariant2());
        variants.get(2).setText(testData.getVariant3());
        variants.get(3).setText(testData.getVariant4());

        for (int i = 0; i < 4; i++) {
            variants.get(i).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            radios.get(i).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
            radios.get(i).setEnabled(true);
            variants.get(i).setEnabled(true);
        }
        skipButton.setEnabled(true);
    }

    @Override
    public void stateNextButton(Boolean bool) {
        nextButton.setEnabled(bool);
    }

    @Override
    public void openResultDialog() {

        View view = LayoutInflater.from(this).inflate(R.layout.result_dialog, null);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .setCancelable(false)
                .create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(null);

        if (musicLog)
            mediaWin.start();

        view.findViewById(R.id.menuButton).setOnClickListener(v -> {
            dialog.cancel();
            finish();
        });

        TextView textWrong = view.findViewById(R.id.wrongText);
        TextView textSkip = view.findViewById(R.id.skipText);
        TextView textCorrect = view.findViewById(R.id.correctText);
        textWrong.setText("Noto'g'ri javoblar " + presenter.getWrongAnswer());
        textSkip.setText("O'tkazilganlar " + presenter.getSkipAnswer());
        textCorrect.setText("To'g'ri javoblar " + presenter.getCorrectAnswer());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        musicLog = savedInstanceState.getBoolean("MUSIC");
    }

    @Override
    protected void onResume() {
        super.onResume();
        musicLog = preferences.getBoolean("MUSIC", true);

        if (musicLog) {
            musicButton.setImageResource(R.drawable.music_on);
        } else {
            musicButton.setImageResource(R.drawable.music_off);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        preferences.edit().putBoolean("MUSIC", musicLog).apply();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}