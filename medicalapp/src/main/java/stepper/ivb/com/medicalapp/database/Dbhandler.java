package stepper.ivb.com.medicalapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import stepper.ivb.com.medicalapp.model.survey;

/**
 * Created by Sriram on 12/11/2015.
 */
public class Dbhandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "medical.db";
    private static final String TABLE_NAME = "med";
    private static final String AGE = "age";
    private static final String SEX = "sex";
    private static final String CHEST_PAIN_TYPE = "chest_pain_type";
    private static final String SYSTOLIC_BLOOD_PRESSURE = "systolic_blood_pressure";
    private static final String DIASTOLIC_BLOOD_PRESSURE = "diastolic_blood_pressure";
    private static final String SERUM_CHOLESTEROL = "serum_cholesterol";
    private static final String FASTING_BLOOD_SUGAR = "fasting_blood_sugar";
    private static final String RESTECG = "restecg";
    private static final String WEIGHT = "weight";
    private static final String WAIST_CIRCUMFERENCE = "waist_circumference";
    private static final String SMOKING = "smoking";
    private static final String HYPERTENSION = "hypertension";
    private static final String HYPERCHOLESTEROLEMIA = "hypercholesterolemia";
    private static final String PREVIOUS_ANGINA = "previous_angina";
    private static final String PRIOR_STROKE = "prior_stroke";
    private static final String ANTERO_LATERAL = "antero_lateral";
    private static final String ANTERO_SEPTAL = "antero_septal";
    private static final String INFERO_LATERAL = "infero_lateral";
    private static final String INFERO_SEPTAL = "infero_septal";
    private static final String SEPTO_ANTERIO = "septo_anterio";
    private static final String DIABETES = "diabetes";
    private static final String OBESITY = "obesity";
    private static final String FAMILY_HISTORY_OF_CHD = "family_history_of_chd";
    private static final String PERICARDIAL_EFFUSION = "pericardial_effusion";
    private static final String LABEL = "label";

    public Dbhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + AGE + " TEXT," + SEX + " TEXT," + CHEST_PAIN_TYPE + " TEXT," + SYSTOLIC_BLOOD_PRESSURE + " TEXT," + DIASTOLIC_BLOOD_PRESSURE + " TEXT," + SERUM_CHOLESTEROL + " TEXT,"
                + FASTING_BLOOD_SUGAR + " TEXT," + RESTECG + " TEXT," + WEIGHT + " INTEGER," + WAIST_CIRCUMFERENCE + " TEXT," + SMOKING + " TEXT," + HYPERTENSION + " TEXT," + HYPERCHOLESTEROLEMIA + " TEXT,"
                + PREVIOUS_ANGINA + " TEXT," + PRIOR_STROKE + " TEXT," + ANTERO_LATERAL + " TEXT," + ANTERO_SEPTAL + " TEXT," + INFERO_LATERAL + " TEXT," + INFERO_SEPTAL + " TEXT,"
                + SEPTO_ANTERIO + " TEXT," + DIABETES + " TEXT," + OBESITY + " TEXT," + FAMILY_HISTORY_OF_CHD + " TEXT," + PERICARDIAL_EFFUSION + " TEXT," + LABEL + " TEXT" + ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean register(survey obj) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put(AGE, obj.age);
            val.put(SEX, obj.sex);
            val.put(CHEST_PAIN_TYPE, obj.chestpain);
            val.put(SYSTOLIC_BLOOD_PRESSURE, obj.systolicbloodpressure);
            val.put(DIASTOLIC_BLOOD_PRESSURE, obj.diastolicbloodpressure);
            val.put(SERUM_CHOLESTEROL, obj.serum_cholesterol);
            val.put(FASTING_BLOOD_SUGAR, obj.fastingbloodsugar);
            val.put(RESTECG, obj.restecg);
            val.put(WEIGHT, obj.weight);
            val.put(WAIST_CIRCUMFERENCE, obj.waist);
            val.put(SMOKING, obj.smoking);
            val.put(HYPERTENSION, obj.hypertension);
            val.put(HYPERCHOLESTEROLEMIA, obj.hypercholestrolemia);
            val.put(PREVIOUS_ANGINA, obj.previousangina);
            val.put(PRIOR_STROKE, obj.priorstroke);
            val.put(ANTERO_LATERAL, obj.anterolateral);
            val.put(ANTERO_SEPTAL, obj.anteroseptal);
            val.put(INFERO_LATERAL, obj.inferolateral);
            val.put(INFERO_SEPTAL, obj.inferoseptal);
            val.put(SEPTO_ANTERIO, obj.septoanterio);
            val.put(DIABETES, obj.diabetes);
            val.put(OBESITY, obj.obesity);
            val.put(FAMILY_HISTORY_OF_CHD, obj.familyhistoryCHD);
            val.put(PERICARDIAL_EFFUSION, obj.pericardial);
            val.put(LABEL, obj.label);

            db.insert(TABLE_NAME, null, val);
            db.close();
        } catch (Exception e) {
            Log.e("DB", e.toString());
            return false;
        }
        return true;
    }

}
