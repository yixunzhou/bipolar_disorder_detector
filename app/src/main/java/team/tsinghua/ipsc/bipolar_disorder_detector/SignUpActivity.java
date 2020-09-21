package team.tsinghua.ipsc.bipolar_disorder_detector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        final Button btnSignUp = findViewById(R.id.signup);
        final Button btnSignUpNotification = findViewById(R.id.signup_notification);
        final TextView username_text = findViewById(R.id.username_signup_text);
        final EditText username = findViewById(R.id.username_signup);
        final TextView password_text = findViewById(R.id.password_signup_text);
        final EditText password = findViewById(R.id.password_signup);
        final TextView password_text2 = findViewById(R.id.password_signup_text2);
        final EditText password2 = findViewById(R.id.password_signup2);
        final TextView nickname_text = findViewById(R.id.nickname_signup_text);
        final EditText nickname = findViewById(R.id.nickname_signup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSignUp.setVisibility(View.INVISIBLE);
                username_text.setVisibility(View.INVISIBLE);
                username.setVisibility(View.INVISIBLE);
                password_text.setVisibility(View.INVISIBLE);
                password.setVisibility(View.INVISIBLE);
                password_text2.setVisibility(View.INVISIBLE);
                password2.setVisibility(View.INVISIBLE);
                nickname_text.setVisibility(View.INVISIBLE);
                nickname.setVisibility(View.INVISIBLE);
                btnSignUpNotification.setVisibility(View.VISIBLE);

            }
        });
    }
}
