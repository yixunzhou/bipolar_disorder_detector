package team.tsinghua.ipsc.bipolar_disorder_detector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class utils {

    public static String[] readSettings(String settingFileName){
        String line;
        String[] args = new String[20];
        BufferedReader in = null;
        int i;
        try{
            in=new BufferedReader(new FileReader(settingFileName));
            line=in.readLine();
            for (i=0;i<args.length;i++){
                if (line != null){
                    args[i] = line;
                    line = in.readLine();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (in!=null){
                try{
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();

                }
            }
        }

        return args;
    }


    public static void writeToSettings(String filePath, String[] settings){
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath), false), StandardCharsets.UTF_8));
            for (int i=0;i<settings.length;i++){
                bufferedWriter.write(settings[i] + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }



    }
}
