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

import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.medicalapp.R;
import stepper.ivb.com.medicalapp.constants.constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class page_three extends stepperFragment {
    public static final String SURVEY = "survey";


    public page_three() {
        // Required empty public constructor
    }

    @Override
    public boolean onNextButtonHandler() {

        SharedPreferences sharedpreferences = getActivity().getSharedPreferences(SURVEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        try {


            RadioGroup radioGroup = (RadioGroup) getActivity().findViewById(R.id.smokingradio);
            String smokingText = "";
            if (radioGroup.getCheckedRadioButtonId() != -1) {
                int id = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(id);
                int radioId = radioGroup.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
                smokingText = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup hypertensionradio = (RadioGroup) getActivity().findViewById(R.id.hypertensionradio);
            String hypertensionradiotext = "";
            if (hypertensionradio.getCheckedRadioButtonId() != -1) {
                int id = hypertensionradio.getCheckedRadioButtonId();
                View radioButton = hypertensionradio.findViewById(id);
                int radioId = hypertensionradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) hypertensionradio.getChildAt(radioId);
                hypertensionradiotext = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup hypercholestrolradio = (RadioGroup) getActivity().findViewById(R.id.hypercholestrolradio);
            String hypercholestrolradiotext = "";
            if (hypercholestrolradio.getCheckedRadioButtonId() != -1) {
                int id = hypercholestrolradio.getCheckedRadioButtonId();
                View radioButton = hypercholestrolradio.findViewById(id);
                int radioId = hypercholestrolradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) hypercholestrolradio.getChildAt(radioId);
                hypercholestrolradiotext = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup anginaradio = (RadioGroup) getActivity().findViewById(R.id.anginaradio);
            String anginaradiotext = "";
            if (anginaradio.getCheckedRadioButtonId() != -1) {
                int id = anginaradio.getCheckedRadioButtonId();
                View radioButton = anginaradio.findViewById(id);
                int radioId = anginaradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) anginaradio.getChildAt(radioId);
                anginaradiotext = (String) btn.getText();
            } else {
                return false;
            }


            editor.putString(constant.SMOKING, smokingText);
            editor.putString(constant.HYPERTENSION, hypertensionradiotext);
            editor.putString(constant.HYPERCHOLESTEROLEMIA, hypercholestrolradiotext);
            editor.putString(constant.PREVIOUS_ANGINA, anginaradiotext);
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
        return inflater.inflate(R.layout.fragment_page_three, container, false);
    }

}
