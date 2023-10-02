package uz.gita.testappmvp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import uz.gita.testappmvp.R;
import uz.gita.testappmvp.model.TestData;
import uz.gita.testappmvp.ui.game.GameActivity;

public class EnterActivity extends AppCompatActivity {

    private AppCompatButton playBtn;
    private AppCompatButton infoBtn;
    private AppCompatButton exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        load();
        clickBtn();
    }

    private void load() {
        playBtn = findViewById(R.id.playBtn);
        infoBtn = findViewById(R.id.infoBtn);
        exitBtn = findViewById(R.id.exitBtn);

    }

    private void clickBtn() {
        playBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });

        infoBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
        });

        exitBtn.setOnClickListener(v -> {
            finish();
        });
    }

}