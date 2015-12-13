package stepper.ivb.com.medicalapp.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.medicalapp.R;
import stepper.ivb.com.medicalapp.constants.constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class page_two extends stepperFragment {

    public static final String SURVEY = "survey";

    public page_two() {
        // Required empty public constructor
    }

    @Override
    public boolean onNextButtonHandler() {

        SharedPreferences sharedpreferences = getActivity().getSharedPreferences(SURVEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        try {
            Spinner serumSpinner = (Spinner) getActivity().findViewById(R.id.serumspinner);
            String serum = serumSpinner.getSelectedItem().toString();
            if (serumSpinner.getSelectedItemPosition() == 0) {
                return false;
            }


            RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.sexbpgroup);
            String sexbp = "";
            if (radioGroup.getCheckedRadioButtonId() != -1) {
                int id = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(id);
                int radioId = radioGroup.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
                sexbp = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup radioGroup1 = (RadioGroup) getActivity().findViewById(R.id.systolicradio);
            String systolic = "";
            if (radioGroup1.getCheckedRadioButtonId() != -1) {
                int id = radioGroup1.getCheckedRadioButtonId();
                View radioButton = radioGroup1.findViewById(id);
                int radioId = radioGroup1.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) radioGroup1.getChildAt(radioId);
                systolic = (String) btn.getText();
            } else {
                return false;
            }
            Spinner fastingblood = (Spinner) getActivity().findViewById(R.id.fastingblood);
            String fastingbloogtext = fastingblood.getSelectedItem().toString();
            if (fastingblood.getSelectedItemPosition() == 0) {
                return false;
            }

            editor.putString(constant.SERUM_CHOLESTEROL, serum);
            editor.putString(constant.SYSTOLIC_BLOOD_PRESSURE, systolic);
            editor.putString(constant.FASTING_BLOOD_SUGAR, fastingbloogtext);
            editor.putString(constant.DIASTOLIC_BLOOD_PRESSURE, sexbp);
            editor.apply();

        } catch (Exception e) {

            return false;
        }

        return true;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_two, container, false);
    }

}
