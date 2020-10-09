package team.tsinghua.ipsc.bipolar_disorder_detector.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import java.io.File;
import java.io.IOException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import team.tsinghua.ipsc.bipolar_disorder_detector.AnalyseActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.LogActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.R;
import team.tsinghua.ipsc.bipolar_disorder_detector.MainActivity;
import team.tsinghua.ipsc.bipolar_disorder_detector.SettingsActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public final String des = MainActivity.root_dir + "bipolar/";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final Button btnVisualise = root.findViewById(R.id.visualise);
        final Button btnAnalyse = root.findViewById(R.id.analyse);
        final Button btnLog = root.findViewById(R.id.log);
        final ImageView img = root.findViewById(R.id.signal);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                btnVisualise.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Connection connection = new Connection("166.111.134.39", 6668);
                                Session ssh = null;
                                try{
                                    connection.connect();
                                    boolean isConnected = connection.authenticateWithPassword("ipsc","ipsc");
                                    SCPClient scpClient = connection.createSCPClient();

                                    ssh = connection.openSession();
                                    ssh.execCommand("~/anaconda3/bin/python /home/ipsc/yixun/script.py");
                                    ssh.close();

                                    File fdes = new File(des);
                                    if (!fdes.exists()){
                                        fdes.mkdir();
                                    }
                                    scpClient.get("/home/ipsc/yixun/chart.png", des);
                                    scpClient.get("/home/ipsc/yixun/20200907131602_4_23_1_4_40-120_PPG2_00.txt", des);
                                }catch (IOException e){
                                    e.printStackTrace();
                                }finally {
                                    if (connection!=null){
                                        connection.close();
                                    }
                                }
                            }
                        }).start();
                        Bitmap bm = BitmapFactory.decodeFile(des+"today.png");
                        img.setImageBitmap(bm);

                    }
                });

                btnAnalyse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView t = root.findViewById(R.id.imglabel);
                        t.setText("您的心情等级评估水平为 1");


                    }
                });

                btnLog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(root.getContext(), LogActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        return root;
    }


}