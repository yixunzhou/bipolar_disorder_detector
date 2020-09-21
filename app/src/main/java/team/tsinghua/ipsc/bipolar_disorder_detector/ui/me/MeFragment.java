package team.tsinghua.ipsc.bipolar_disorder_detector.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import team.tsinghua.ipsc.bipolar_disorder_detector.MainActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.ProfileActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.R;
import team.tsinghua.ipsc.bipolar_disorder_detector.SettingsActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.SignInActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.SignUpActivity;

public class MeFragment extends Fragment {

    private MeViewModel meViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meViewModel =
                ViewModelProviders.of(this).get(MeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_me, container, false);

        final Button btnUser = root.findViewById(R.id.user);
        final Button btnSettings = root.findViewById(R.id.settings);

        if (MainActivity.username!=null && MainActivity.nickname!=null) {
            btnUser.setText(MainActivity.nickname + "\n用户编号：" + MainActivity.username);
        } else if (MainActivity.username==null && MainActivity.nickname==null) {
            btnUser.setText("登录/注册");
        }

        meViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                btnUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (MainActivity.username!=null && MainActivity.nickname!=null) {
                            Intent intent = new Intent(root.getContext(), ProfileActivity.class);
                            startActivity(intent);
                        } else if (MainActivity.username==null && MainActivity.nickname==null) {
                            Intent intent = new Intent(root.getContext(), SignUpActivity.class);
                            startActivity(intent);
                        }

                    }
                });

                btnSettings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(root.getContext(), SettingsActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        return root;
    }
}