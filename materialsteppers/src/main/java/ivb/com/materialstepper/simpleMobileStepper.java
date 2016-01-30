package ivb.com.materialstepper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by S.Shivasurya on 1/19/2016 - androidStudio - androidStudio.
 */
public abstract class simpleMobileStepper extends AppCompatActivity implements View.OnClickListener {

    private Button mPrevious;
    private TextView mStepText;
    List<Class> mStepperFragmentList;
    private baseStepper mBaseStepper;
    private int RECOVERCURRENTSTATE = 0;
    private ScrollView mScroll;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_mobile_stepper);

        Button mNext = (Button) findViewById(R.id.next);
        mPrevious = (Button)findViewById(R.id.back);
        mStepText = (TextView)findViewById(R.id.steps);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mScroll = (ScrollView)findViewById(R.id.mobilescroll);

        mNext.setOnClickListener(this);
        mPrevious.setOnClickListener(this);
        if(savedInstanceState!=null) {
            if(savedInstanceState.getSerializable("HSTEPPERBASE")!=null) {
                try {
                    mStepperFragmentList = (List<Class>) savedInstanceState.getSerializable("HSTEPPERBASE");
                    RECOVERCURRENTSTATE = savedInstanceState.getInt("HCURRENT");
                }catch(Exception e){
                    //it's  okay we will recover from the init method
                    mStepperFragmentList = init();
                }
            }
            else{
                mStepperFragmentList = init();
            }
        }
        else
        {
            mStepperFragmentList = init();
        }
        mBaseStepper = new baseStepper(mViewPager, mStepperFragmentList, getSupportFragmentManager());
        mBaseStepper.CURRENT_PAGE = RECOVERCURRENTSTATE;
        RECOVERCURRENTSTATE = 0;
        BackButtonConfig();
        updateUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("HSTEPPERBASE",(Serializable)mStepperFragmentList);
        outState.putInt("HCURRENT",mBaseStepper.CURRENT_PAGE);
        super.onSaveInstanceState(outState);

    }

    protected void BackButtonConfig(){
        if(mBaseStepper.CURRENT_PAGE==0)
            mPrevious.setVisibility(View.INVISIBLE);
        else
            mPrevious.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.next) {
            if (checkStepper()) {
                mBaseStepper.onNextButtonClicked();
                BackButtonConfig();
                updateUI();
            }

        } else if (i == R.id.back) {
            mBaseStepper.onBackButtonClicked();
            BackButtonConfig();
            updateUI();

        }
    }
    public int getCurrentFragmentId(){
        return mBaseStepper.CURRENT_PAGE;
    }

    public boolean checkStepper(){
        if(mBaseStepper.resolveNavigation()){
            return true;
        }
        onStepperCompleted();
        return  false;

    }
    public void updateUI(){
        mStepText.setText("Step " + (mBaseStepper.CURRENT_PAGE + 1) + " of " + mBaseStepper.TOTAL_PAGE);
        mScroll.pageScroll(View.FOCUS_UP);
    }
    public abstract void onStepperCompleted();
    public abstract List<Class> init();

}
