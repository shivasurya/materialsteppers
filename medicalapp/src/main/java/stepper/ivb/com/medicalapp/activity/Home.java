package stepper.ivb.com.medicalapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import stepper.ivb.com.medicalapp.R;

public class Home extends AppCompatActivity {

    private String[] list = new String[]{"Start Medical Form", "Send Data - EMail", "Take Database Backup"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_green_light));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(getApplicationContext(), stepper.ivb.com.medicalapp.medicalActivity.class);
                    startActivity(intent);
                } catch (Exception e) {

                }

            }
        });
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        try {
                            Intent intent = new Intent(getApplicationContext(), stepper.ivb.com.medicalapp.medicalActivity.class);
                            startActivity(intent);
                        } catch (Exception e) {

                        }
                        break;
                    case 1:
                        try {
                            Intent intent = new Intent(Home.this, shareData.class);
                            startActivity(intent);
                        } catch (Exception e) {

                        }
                        break;
                    case 2:
                        try {
                            getFile();
                        } catch (Exception e) {

                        }
                        break;
                }
            }
        });
    }

    protected void getFile() {
        File f = new File("/data/data/stepper.ivb.com.medicalapp/databases/medical.db");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(f);
            fos = new FileOutputStream("/mnt/sdcard/db_dump.db");
            while (true) {
                int i = fis.read();
                if (i != -1) {
                    fos.write(i);
                } else {
                    break;
                }
            }
            fos.flush();
            Toast.makeText(this, "DB dump OK", Toast.LENGTH_LONG).show();
            Snackbar.make(getCurrentFocus(), "Successfull backed Up Database to SD CARD", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "DB dump ERROR", Toast.LENGTH_LONG).show();
            Snackbar.make(getCurrentFocus(), "ERROR in Database back up! Make Sure to Have SD CARD", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException ioe) {
            }
        }

    }
}
