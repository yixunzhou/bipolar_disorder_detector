package team.tsinghua.ipsc.bipolar_disorder_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Button btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.nickname = null;
                MainActivity.username = null;
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}