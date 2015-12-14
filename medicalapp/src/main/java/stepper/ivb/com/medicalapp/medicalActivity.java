package stepper.ivb.com.medicalapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ivb.com.materialstepper.mobileStepperSimple;
import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.medicalapp.constants.constant;
import stepper.ivb.com.medicalapp.database.Dbhandler;
import stepper.ivb.com.medicalapp.fragments.page_four;
import stepper.ivb.com.medicalapp.fragments.page_last;
import stepper.ivb.com.medicalapp.fragments.page_one;
import stepper.ivb.com.medicalapp.fragments.page_three;
import stepper.ivb.com.medicalapp.fragments.page_two;
import stepper.ivb.com.medicalapp.fragments.page_two_b;
import stepper.ivb.com.medicalapp.model.survey;

/**
 * Created by S.Shivasurya on 12/12/2015 - androidStudio.
 */
public class medicalActivity extends mobileStepperSimple {
    public static final String SURVEY = "survey";


    List<stepperFragment> stepperFragmentList = new ArrayList<>();
    stepperFragment obj = new page_one();
    stepperFragment obj1 = new page_two();
    stepperFragment obj2 = new page_two_b();
    stepperFragment obj3 = new page_three();
    stepperFragment obj4 = new page_four();
    stepperFragment obj5 = new page_last();


    @Override
    public void initApp(Bundle bundle) {
        stepperFragmentList.add(obj);
        stepperFragmentList.add(obj1);
        stepperFragmentList.add(obj2);
        stepperFragmentList.add(obj3);
        stepperFragmentList.add(obj4);
        stepperFragmentList.add(obj5);
        setFragment(stepperFragmentList);
        init();
    }

    @Override
    public void onStepperCompleted() {
        survey data = new survey();
        SharedPreferences sharedpreferences = getSharedPreferences(SURVEY, Context.MODE_PRIVATE);

        try {
            Log.d("simple", sharedpreferences.getString(constant.ANTERO_LATERAL, null));
            data.age = sharedpreferences.getString(constant.AGE, null);
            data.sex = sharedpreferences.getString(constant.SEX, null);
            data.chestpain = sharedpreferences.getString(constant.CHEST_PAIN_TYPE, null);
            data.systolicbloodpressure = sharedpreferences.getString(constant.SYSTOLIC_BLOOD_PRESSURE, null);
            data.diastolicbloodpressure = sharedpreferences.getString(constant.DIASTOLIC_BLOOD_PRESSURE, null);
            data.serum_cholesterol = sharedpreferences.getString(constant.SERUM_CHOLESTEROL, null);
            data.fastingbloodsugar = sharedpreferences.getString(constant.FASTING_BLOOD_SUGAR, null);
            data.restecg = sharedpreferences.getString(constant.RESTECG, null);
            String weightdata = sharedpreferences.getString(constant.WEIGHT, null);
            data.weight = Integer.parseInt(weightdata);
            data.waist = sharedpreferences.getString(constant.WAIST_CIRCUMFERENCE, null);
            data.smoking = sharedpreferences.getString(constant.SMOKING, null);
            data.hypertension = sharedpreferences.getString(constant.HYPERTENSION, null);
            data.hypercholestrolemia = sharedpreferences.getString(constant.HYPERCHOLESTEROLEMIA, null);
            data.previousangina = sharedpreferences.getString(constant.PREVIOUS_ANGINA, null);
            data.priorstroke = sharedpreferences.getString(constant.PRIOR_STROKE, null);
            data.anterolateral = sharedpreferences.getString(constant.ANTERO_LATERAL, null);
            data.anteroseptal = sharedpreferences.getString(constant.ANTERO_SEPTAL, null);
            data.inferolateral = sharedpreferences.getString(constant.INFERO_LATERAL, null);
            data.inferoseptal = sharedpreferences.getString(constant.INFERO_SEPTAL, null);
            data.septoanterio = sharedpreferences.getString(constant.SEPTO_ANTERIO, null);
            data.diabetes = sharedpreferences.getString(constant.DIABETES, null);
            data.obesity = sharedpreferences.getString(constant.OBESITY, null);
            data.familyhistoryCHD = sharedpreferences.getString(constant.FAMILY_HISTORY_OF_CHD, null);
            data.pericardial = sharedpreferences.getString(constant.PERICARDIAL_EFFUSION, null);
            data.label = sharedpreferences.getString(constant.LABEL, null);

            Dbhandler db = new Dbhandler(this);

            if (db.register(data)) {
                Log.d("success", "success go ahead to db");

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Success in Database! Saving");

                alertDialogBuilder.setPositiveButton("Go HOME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(medicalActivity.this, stepper.ivb.com.medicalapp.activity.Home.class);
                        startActivity(intent);

                    }
                });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            } else {
                Log.d("error", "DB");

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setMessage("Error in Database! Saving");

                alertDialogBuilder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(medicalActivity.this, "RESTART APP! DB ERROR", Toast.LENGTH_LONG).show();
                    }
                });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        } catch (Exception e) {
            Log.e("SHARED PREFERENCE", e.toString());
            e.printStackTrace();

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Error in Database! Saving");

            alertDialogBuilder.setPositiveButton("OKAY", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(medicalActivity.this, "RESTART APP! DB ERROR", Toast.LENGTH_LONG).show();
                }
            });


            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } finally {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();
            obj5 = null;
            obj = null;
            obj2 = null;
            obj1 = null;
            obj3 = null;
            obj4 = null;
            stepperFragmentList = null;
        }

    }
}
