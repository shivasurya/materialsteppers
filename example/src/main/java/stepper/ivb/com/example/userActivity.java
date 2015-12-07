package stepper.ivb.com.example;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ivb.com.materialstepper.mobileStepperSimple;
import ivb.com.materialstepper.stepperFragment;
import stepper.ivb.com.example.fragments.general;
import stepper.ivb.com.example.fragments.introduction;

public class userActivity extends mobileStepperSimple {

    protected List<stepperFragment> fragments = new ArrayList<stepperFragment>();

    @Override
    public void initApp(Bundle bundle) {
        stepperFragment obj = new introduction();
        stepperFragment general = new general();
        stepperFragment objs = new feedback();
        stepperFragment g = new general();

        fragments.add(obj);
        fragments.add(general);
        fragments.add(objs);
        fragments.add(g);

        setFragment(fragments);
        init();

    }

    @Override
    public void onStepperCompleted() {
        //Take steps since all stepper fragments completed successfully
    }
}
