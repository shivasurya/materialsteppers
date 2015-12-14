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
public class page_last extends stepperFragment {
    public static final String SURVEY = "survey";


    public page_last() {
        // Required empty public constructor
    }

    @Override
    public boolean onNextButtonHandler() {
        SharedPreferences sharedpreferences = getActivity().getSharedPreferences(SURVEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        try {

            RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.familyhistorychd);
            String familyhistorychdtext = "";
            if (radioGroup.getCheckedRadioButtonId() != -1) {
                int id = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(id);
                int radioId = radioGroup.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
                familyhistorychdtext = (String) btn.getText();
            } else {
                return false;
            }
            RadioGroup radioGroup1 = (RadioGroup) getActivity().findViewById(R.id.pericardial);
            String pericardialtext = "";
            if (radioGroup1.getCheckedRadioButtonId() != -1) {
                int id = radioGroup1.getCheckedRadioButtonId();
                View radioButton = radioGroup1.findViewById(id);
                int radioId = radioGroup1.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) radioGroup1.getChildAt(radioId);
                pericardialtext = (String) btn.getText();
            } else {
                return false;
            }
            Spinner labelspinner = (Spinner) getActivity().findViewById(R.id.labelspinner);
            String label = labelspinner.getSelectedItem().toString();
            if (labelspinner.getSelectedItemPosition() == 0) {
                return false;
            }

            editor.putString(constant.FAMILY_HISTORY_OF_CHD, familyhistorychdtext);
            editor.putString(constant.PERICARDIAL_EFFUSION, pericardialtext);
            editor.putString(constant.LABEL, label);
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
        return inflater.inflate(R.layout.fragment_page_last, container, false);
    }

}
