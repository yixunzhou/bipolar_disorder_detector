package team.tsinghua.ipsc.bipolar_disorder_detector;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {


    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private static int REQUEST_PERMISSION_CODE = 1;


    public final static String root_dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

    public final static String setting_file = root_dir + "bipolar_disorder/settings.txt";

    public static String username;
    public static String nickname;
//    public static String username = settings[0].split(":")[1];
//    public static String nickname = settings[1].split(":")[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
        }
        final String[] settings = utils.readSettings(setting_file);
//        username = settings[0].split(":")[1];
//        nickname = settings[1].split(":")[1];
        username = "197348";
        nickname = "yixun";
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as search_activity set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,R.id.navigation_discover, R.id.navigation_statistics, R.id.navigation_me)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        Toast.makeText(this, "请连接手环", Toast.LENGTH_SHORT).show();


    }

}