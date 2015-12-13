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
public class page_one extends stepperFragment {

    public static final String SURVEY = "survey";


    public page_one() {
        // Required empty public constructor
    }

    @Override
    public boolean onNextButtonHandler() {
        SharedPreferences sharedpreferences = getActivity().getSharedPreferences(SURVEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        try {
            Spinner ageSpinner = (Spinner) getActivity().findViewById(R.id.agespinner);
            String age = ageSpinner.getSelectedItem().toString();
            if (ageSpinner.getSelectedItemPosition() == 0) {
                return false;
            }

            RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.sexgroup);
            String sex = "";
            if (radioGroup.getCheckedRadioButtonId() != -1) {
                int id = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(id);
                int radioId = radioGroup.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
                sex = (String) btn.getText();
            } else {
                return false;
            }
            Spinner chestpain = (Spinner) getActivity().findViewById(R.id.chestspinner);
            String chestpaintype = chestpain.getSelectedItem().toString();
            if (chestpain.getSelectedItemPosition() == 0) {
                return false;
            }

            editor.putString(constant.AGE, age);
            editor.putString(constant.SEX, sex);
            editor.putString(constant.CHEST_PAIN_TYPE, chestpaintype);
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
        return inflater.inflate(R.layout.fragment_page_one, container, false);
    }

}
