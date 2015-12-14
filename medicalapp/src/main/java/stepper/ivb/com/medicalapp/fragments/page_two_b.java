package stepper.ivb.com.medicalapp.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.medicalapp.R;
import stepper.ivb.com.medicalapp.constants.constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class page_two_b extends stepperFragment {

    public static final String SURVEY = "survey";

    public page_two_b() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public boolean onNextButtonHandler() {

        SharedPreferences sharedpreferences = getActivity().getSharedPreferences(SURVEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        try {
            EditText weight = (EditText) getActivity().findViewById(R.id.weight);
            String weigthText = weight.getText().toString();

            RadioGroup radioGroup1 = (RadioGroup) getActivity().findViewById(R.id.waist);
            String waisttext = "";
            if (radioGroup1.getCheckedRadioButtonId() != -1) {
                int id = radioGroup1.getCheckedRadioButtonId();
                View radioButton = radioGroup1.findViewById(id);
                int radioId = radioGroup1.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) radioGroup1.getChildAt(radioId);
                waisttext = (String) btn.getText();
            } else {
                return false;
            }
            Spinner restecgspinner = (Spinner) getActivity().findViewById(R.id.restecgspinner);
            String restecgspinnertext = restecgspinner.getSelectedItem().toString();
            if (restecgspinner.getSelectedItemPosition() == 0) {
                return false;
            }

            editor.putString(constant.RESTECG, restecgspinnertext);
            editor.putString(constant.WAIST_CIRCUMFERENCE, waisttext);
            editor.putString(constant.WEIGHT, weigthText);

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
        return inflater.inflate(R.layout.fragment_page_two_b, container, false);
    }

}
