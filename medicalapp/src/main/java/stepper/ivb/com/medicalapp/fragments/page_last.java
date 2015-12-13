package stepper.ivb.com.medicalapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.medicalapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class page_last extends stepperFragment {


    public page_last() {
        // Required empty public constructor
    }

    @Override
    public boolean onNextButtonHandler() {
        return true;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_last, container, false);
    }

}
