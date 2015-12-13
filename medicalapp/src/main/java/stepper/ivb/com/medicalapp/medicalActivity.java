package stepper.ivb.com.medicalapp;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ivb.com.materialstepper.mobileStepperSimple;
import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.medicalapp.fragments.page_last;
import stepper.ivb.com.medicalapp.fragments.page_one;
import stepper.ivb.com.medicalapp.fragments.page_two;

/**
 * Created by S.Shivasurya on 12/12/2015 - androidStudio.
 */
public class medicalActivity extends mobileStepperSimple {

    List<stepperFragment> stepperFragmentList = new ArrayList<>();
    stepperFragment obj = new page_one();
    stepperFragment obj1 = new page_two();
    stepperFragment obj2 = new page_last();


    @Override
    public void initApp(Bundle bundle) {
        stepperFragmentList.add(obj);
        stepperFragmentList.add(obj1);
        stepperFragmentList.add(obj2);
        setFragment(stepperFragmentList);
        init();
    }

    @Override
    public void onStepperCompleted() {

    }
}
