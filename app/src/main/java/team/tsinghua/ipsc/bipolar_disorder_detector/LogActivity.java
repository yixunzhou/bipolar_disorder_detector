package team.tsinghua.ipsc.bipolar_disorder_detector;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import team.tsinghua.ipsc.bipolar_disorder_detector.ui.home.HomeFragment;
import team.tsinghua.ipsc.bipolar_disorder_detector.AnalyseActivity;
public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        final ImageView img = findViewById(R.id.signallog);
        final TextView t = findViewById(R.id.anareslog);
        HomeFragment h = new HomeFragment();
        Bitmap bm = BitmapFactory.decodeFile(h.des+"today.png");
        img.setImageBitmap(bm);
        AnalyseActivity act = new AnalyseActivity();
        t.setText("您的心情等级评估水平为"+act.i);

    }
}