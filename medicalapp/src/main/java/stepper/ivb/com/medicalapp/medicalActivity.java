package stepper.ivb.com.medicalapp;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ivb.com.materialstepper.mobileStepperSimple;
import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.medicalapp.fragments.page_four;
import stepper.ivb.com.medicalapp.fragments.page_last;
import stepper.ivb.com.medicalapp.fragments.page_one;
import stepper.ivb.com.medicalapp.fragments.page_three;
import stepper.ivb.com.medicalapp.fragments.page_two;
import stepper.ivb.com.medicalapp.fragments.page_two_b;

/**
 * Created by S.Shivasurya on 12/12/2015 - androidStudio.
 */
public class medicalActivity extends mobileStepperSimple {

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

    }
}
