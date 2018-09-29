package com.vakuor.mapsforfest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class FileRead {
//
//
//    public class MainActivity extends Activity {
//
//        final String LOG_TAG = "myLogs";
//
//        final String FILENAME = "file";
//
//        final String DIR_SD = "MyFiles";
//        final String FILENAME_SD = "fileSD";
//
//        /** Called when the activity is first created. */
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.main);
//            readFile();
//        }
//
//        public void onclick(View v) {
//            switch (v.getId()) {
//                case R.id.btnWrite:
//                    writeFile();
//                    break;
//                case R.id.btnRead:
//                    readFile();
//                    break;
//                case R.id.btnWriteSD:
//                    writeFileSD();
//                    break;
//                case R.id.btnReadSD:
//                    readFileSD();
//                    break;
//            }
//        }
//
//        void readFile() {
//            try {
//                // открываем поток для чтения
//                BufferedReader br = new BufferedReader(new InputStreamReader(
//                        openFileInput(FILENAME)));
//                String str = "";
//                // читаем содержимое
//                while ((str = br.readLine()) != null) {
//                    Log.d(LOG_TAG, str);
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        void readFileSD() {
//            // проверяем доступность SD
//            if (!Environment.getExternalStorageState().equals(
//                    Environment.MEDIA_MOUNTED)) {
//                Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
//                return;
//            }
//            // получаем путь к SD
//            File sdPath = Environment.getExternalStorageDirectory();
//            // добавляем свой каталог к пути
//            sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
//            // формируем объект File, который содержит путь к файлу
//            File sdFile = new File(sdPath, FILENAME_SD);
//            try {
//                // открываем поток для чтения
//                BufferedReader br = new BufferedReader(new FileReader(sdFile));
//                String str = "";
//                // читаем содержимое
//                while ((str = br.readLine()) != null) {
//                    Log.d(LOG_TAG, str);
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
