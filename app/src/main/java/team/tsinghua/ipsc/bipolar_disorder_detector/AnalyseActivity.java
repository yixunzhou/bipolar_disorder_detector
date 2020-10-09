package team.tsinghua.ipsc.bipolar_disorder_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import team.tsinghua.ipsc.bipolar_disorder_detector.ui.home.HomeFragment;


public class AnalyseActivity extends AppCompatActivity {
    public int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyse);
        HomeFragment h = new HomeFragment();
        String[] func = {"script", "examine"};
        String file = h.des + "20200907131602_4_23_1_4_40-120_PPG2_00.txt";
        String lower_rate = "40";
        String upper_rate = "120";

        String[] args = {
                file,
                lower_rate,
                upper_rate
        };

//        PythonTask examine_file = new PythonTask(func, args);
//        examine_file.execute();
        TextView t = findViewById(R.id.imglabel);
        t.setText("您今日的心情等级评估水平为"+i);
    }
    @SuppressLint("StaticFieldLeak")
    private class PythonTask extends AsyncTask<Void, Void, Integer> {

        private String[] func;
        private String[] args;


        PythonTask(String[] _func, String[] _args) {
            func = _func;
            args = _args;
        }


        @Override
        protected Integer doInBackground(Void... dummy) {
            Python python = Python.getInstance();
            PyObject res = python.getModule(func[0]).callAttr(func[1], (Object[]) args);
            return res.toInt();
        }


        @Override
        protected void onPreExecute() {
        }


        protected void onPostExecute(Integer a) {
            i=a;
        }
    }
}