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
public class page_four extends stepperFragment {
    public static final String SURVEY = "survey";

    public page_four() {
        // Required empty public constructor
    }

    @Override
    public boolean onNextButtonHandler() {

        SharedPreferences sharedpreferences = getActivity().getSharedPreferences(SURVEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        try {


            RadioGroup priorstroke = (RadioGroup) getActivity().findViewById(R.id.priorstroke);
            String priorstroketext = "";
            if (priorstroke.getCheckedRadioButtonId() != -1) {
                int id = priorstroke.getCheckedRadioButtonId();
                View radioButton = priorstroke.findViewById(id);
                int radioId = priorstroke.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) priorstroke.getChildAt(radioId);
                priorstroketext = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup anterolateralradio = (RadioGroup) getActivity().findViewById(R.id.anterolateralradio);
            String anterolateralradiotext = "";
            if (anterolateralradio.getCheckedRadioButtonId() != -1) {
                int id = anterolateralradio.getCheckedRadioButtonId();
                View radioButton = anterolateralradio.findViewById(id);
                int radioId = anterolateralradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) anterolateralradio.getChildAt(radioId);
                anterolateralradiotext = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup anteroseptalradio = (RadioGroup) getActivity().findViewById(R.id.anteroseptalradio);
            String anteroseptalradiotext = "";
            if (anteroseptalradio.getCheckedRadioButtonId() != -1) {
                int id = anteroseptalradio.getCheckedRadioButtonId();
                View radioButton = anteroseptalradio.findViewById(id);
                int radioId = anteroseptalradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) anteroseptalradio.getChildAt(radioId);
                anteroseptalradiotext = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup inferoradio = (RadioGroup) getActivity().findViewById(R.id.inferoradio);
            String inferoradiotext = "";
            if (inferoradio.getCheckedRadioButtonId() != -1) {
                int id = inferoradio.getCheckedRadioButtonId();
                View radioButton = inferoradio.findViewById(id);
                int radioId = inferoradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) inferoradio.getChildAt(radioId);
                inferoradiotext = (String) btn.getText();
            } else {
                return false;
            }

            RadioGroup inferoseptalradio = (RadioGroup) getActivity().findViewById(R.id.inferoseptalradio);
            String inferoseptalradiotext = "";
            if (inferoseptalradio.getCheckedRadioButtonId() != -1) {
                int id = inferoseptalradio.getCheckedRadioButtonId();
                View radioButton = inferoseptalradio.findViewById(id);
                int radioId = inferoseptalradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) inferoseptalradio.getChildAt(radioId);
                inferoseptalradiotext = (String) btn.getText();
            } else {
                return false;
            }
            RadioGroup septoanterioradio = (RadioGroup) getActivity().findViewById(R.id.septoanterioradio);
            String septoanterioradiotext = "";
            if (septoanterioradio.getCheckedRadioButtonId() != -1) {
                int id = septoanterioradio.getCheckedRadioButtonId();
                View radioButton = septoanterioradio.findViewById(id);
                int radioId = septoanterioradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) septoanterioradio.getChildAt(radioId);
                septoanterioradiotext = (String) btn.getText();
            } else {
                return false;
            }
            RadioGroup diabetesradio = (RadioGroup) getActivity().findViewById(R.id.diabetesradio);
            String diabetesradiotext = "";
            if (diabetesradio.getCheckedRadioButtonId() != -1) {
                int id = diabetesradio.getCheckedRadioButtonId();
                View radioButton = diabetesradio.findViewById(id);
                int radioId = diabetesradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) diabetesradio.getChildAt(radioId);
                diabetesradiotext = (String) btn.getText();
            } else {
                return false;
            }
            RadioGroup obesityradio = (RadioGroup) getActivity().findViewById(R.id.obesityradio);
            String obesityradiotext = "";
            if (obesityradio.getCheckedRadioButtonId() != -1) {
                int id = obesityradio.getCheckedRadioButtonId();
                View radioButton = obesityradio.findViewById(id);
                int radioId = obesityradio.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) obesityradio.getChildAt(radioId);
                obesityradiotext = (String) btn.getText();
            } else {
                return false;
            }


            editor.putString(constant.OBESITY, obesityradiotext);
            editor.putString(constant.DIABETES, diabetesradiotext);
            editor.putString(constant.SEPTO_ANTERIO, septoanterioradiotext);
            editor.putString(constant.INFERO_SEPTAL, inferoseptalradiotext);
            editor.putString(constant.INFERO_LATERAL, inferoradiotext);
            editor.putString(constant.ANTERO_LATERAL, anterolateralradiotext);
            editor.putString(constant.ANTERO_SEPTAL, anteroseptalradiotext);
            editor.putString(constant.PRIOR_STROKE, priorstroketext);

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
        return inflater.inflate(R.layout.fragment_page_four, container, false);
    }

}
