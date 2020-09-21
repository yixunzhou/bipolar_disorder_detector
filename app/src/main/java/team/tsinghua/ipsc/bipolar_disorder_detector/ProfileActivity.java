package team.tsinghua.ipsc.bipolar_disorder_detector;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);



        final TextView info = findViewById(R.id.info);
        final TextView nickname_label = findViewById(R.id.nickname_label);
        final TextView username_label = findViewById(R.id.username_label);
        final Button btnNichnameText = findViewById(R.id.nickname_profile_text);
        final Button btnUsernameText = findViewById(R.id.username_profile_text);
        final Button btnNickname = findViewById(R.id.nickname_profile);
        final Button btnUsername = findViewById(R.id.username_profile);
        final Button btnConfirmNickname = findViewById(R.id.confirmChangeNickname);
        final Button btnConfirmUsername = findViewById(R.id.confirmChangeUsername);
        final EditText changeNickname = findViewById(R.id.changeNickname);
        final EditText changeUsername = findViewById(R.id.changeUsername);

        btnNickname.setText(MainActivity.nickname);
        btnUsername.setText(MainActivity.username);

        btnNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setVisibility(View.INVISIBLE);
                btnNichnameText.setVisibility(View.INVISIBLE);
                btnUsernameText.setVisibility(View.INVISIBLE);
                btnNickname.setVisibility(View.INVISIBLE);
                btnUsername.setVisibility(View.INVISIBLE);

                btnConfirmNickname.setVisibility(View.VISIBLE);
                changeNickname.setVisibility(View.VISIBLE);
                nickname_label.setVisibility(View.VISIBLE);
                changeNickname.setText(MainActivity.nickname);

            }
        });
        btnUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setVisibility(View.INVISIBLE);
                btnNichnameText.setVisibility(View.INVISIBLE);
                btnUsernameText.setVisibility(View.INVISIBLE);
                btnNickname.setVisibility(View.INVISIBLE);
                btnUsername.setVisibility(View.INVISIBLE);

                btnConfirmUsername.setVisibility(View.VISIBLE);
                changeUsername.setVisibility(View.VISIBLE);
                username_label.setVisibility(View.VISIBLE);
                changeUsername.setText(MainActivity.username);

            }
        });
        btnConfirmNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.nickname = changeNickname.getText().toString();
                String[] newSettings = new String[]{"Username:" + MainActivity.username, "Nickname:" + MainActivity.nickname};
                utils.writeToSettings(MainActivity.setting_file, newSettings);

                info.setVisibility(View.VISIBLE);
                btnNichnameText.setVisibility(View.VISIBLE);
                btnUsernameText.setVisibility(View.VISIBLE);
                btnNickname.setVisibility(View.VISIBLE);
                btnUsername.setVisibility(View.VISIBLE);

                btnConfirmNickname.setVisibility(View.INVISIBLE);
                changeNickname.setVisibility(View.INVISIBLE);
                nickname_label.setVisibility(View.INVISIBLE);
                btnNickname.setText(MainActivity.nickname);
            }
        });
        btnConfirmUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.username = changeUsername.getText().toString();
                String[] newSettings = new String[]{"Username:" + MainActivity.username, "Nickname:" + MainActivity.nickname};
                utils.writeToSettings(MainActivity.setting_file, newSettings);
                info.setVisibility(View.VISIBLE);
                btnNichnameText.setVisibility(View.VISIBLE);
                btnUsernameText.setVisibility(View.VISIBLE);
                btnNickname.setVisibility(View.VISIBLE);
                btnUsername.setVisibility(View.VISIBLE);

                btnConfirmUsername.setVisibility(View.INVISIBLE);
                changeUsername.setVisibility(View.INVISIBLE);
                username_label.setVisibility(View.INVISIBLE);
                btnUsername.setText(MainActivity.username);
            }
        });



    }
}
