package ivb.com.materialstepper;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public abstract class mobileStepperSimple extends AppCompatActivity {
    private android.support.v4.app.FragmentManager fm;
    private android.support.v4.app.FragmentTransaction ft;
    private int fragmentNumber, CURRENT_FRAGMENT_STATE = -1;
    private List<stepperFragment> fragments;
    private Button nextButton, backButton;
    private TextView step;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobilesteppersimple_main);
        nextButton = (Button) findViewById(R.id.next);
        backButton = (Button) findViewById(R.id.back);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNextButtonClicked();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initApp(savedInstanceState);
    }

    protected void onNextButtonClicked() {
        if (fragments.get(CURRENT_FRAGMENT_STATE).onNextButtonHandler()) {
            nextFragment();
        }
    }

    public abstract void initApp(Bundle bundle);

    public abstract void onStepperCompleted();

    public void setFragment(List<stepperFragment> fragment) {
        this.fragments = fragment;
        fragmentNumber = this.fragments.size();
    }

    public void init() {
        nextFragment();
    }

    private boolean addFragmentLayout(Fragment fragment) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment);
        ft.commit();
        updateSteps();
        return true;
    }

    protected void updateSteps() {
        step = (TextView) findViewById(R.id.steps);
        String message = "Step " + (CURRENT_FRAGMENT_STATE + 1) + " of " + fragmentNumber;
        step.setText(message);
    }

    protected void backFragment() {
        if (CURRENT_FRAGMENT_STATE > 0) {
            CURRENT_FRAGMENT_STATE = CURRENT_FRAGMENT_STATE - 1;
            addFragmentLayout(this.fragments.get(CURRENT_FRAGMENT_STATE));
        } else {
            //      Log.d(getClass().getName(),"reached first fragment");
        }
    }

    public void nextFragment() {
        if (CURRENT_FRAGMENT_STATE < fragments.size() - 1) {
            CURRENT_FRAGMENT_STATE = CURRENT_FRAGMENT_STATE + 1;
            addFragmentLayout(this.fragments.get(CURRENT_FRAGMENT_STATE));
            //    Log.d("added","fragment");
        } else {
            //  Log.d(getClass().getName(),"Completed all Fragments");
            //it means we have completed all fragments
            onStepperCompleted();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("CURRENT_FRAGMENT_STATE", CURRENT_FRAGMENT_STATE);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CURRENT_FRAGMENT_STATE = savedInstanceState.getInt("CURRENT_FRAGMENT_STATE");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public final void onBackPressed() {
        if (CURRENT_FRAGMENT_STATE > 0)
            backFragment();
        else
            super.onBackPressed();
    }
}
