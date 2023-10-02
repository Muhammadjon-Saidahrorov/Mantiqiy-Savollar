package uz.gita.testappmvp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;

import uz.gita.testappmvp.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        AppCompatImageView buttonBack = findViewById(R.id.backBtn);
        buttonBack.setOnClickListener(v -> finish());
    }
}