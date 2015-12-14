package stepper.ivb.com.medicalapp.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import stepper.ivb.com.medicalapp.R;

public class shareData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data);
        final EditText email = (EditText) findViewById(R.id.email);
        Button send = (Button) findViewById(R.id.share);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = email.getText().toString();
                sendEmail(emailtext);
            }
        });
    }

    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }


    private String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    protected boolean sendEmail(String email) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String message = dateFormat.format(cal.getTime()) + "Database DUMP from " + getDeviceName();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, "TCE MEDICAL APP - DATABASE DUMP");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email, "aa.sheikabdullah@gmail.com"});
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File("/mnt/sdcard/db_dump.db")));
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Send E-Mail"));
        return true;
    }
}
