package ua.r4mstein.myworkouts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SELECTED_DRAWER_ITEM_ID = "selected_drawer_item_id";
    private static final String FIRST_TIME = "first_time";
    final int REQUEST_CODE = 1;

    private SharedPreferences mPreferences;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Button mDoButton;
    private Button mPlusSecondButton;
    private Button mSkipPauseButton;
    private TextView mProgramNameTextView;
    private TextView mProgramDayTextView;
    private TextView mProgramRepsTextView;
    private TextView mProgramTotalTextView;
    private TextView mChangeProgramTextView;
    private TextView mMainLabelTextView;
    private TextView mProgramTimer;
    private CountDownTimer mTimer;

    private int mSelectedId;
    private String mProgramName;
    private int mProgramDay;
    private boolean isProgramSelected;
    private int mReps[] = null;
    private int mCountDaysOfProgram;
    private int mSetNumber = 0;
    private long mCurrentTime = 0;
    private String mExerciseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        initViews();

        mNavigationView.setNavigationItemSelectedListener(this);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mSelectedId = savedInstanceState == null ? R.id.nav_item_pushups :
                savedInstanceState.getInt(SELECTED_DRAWER_ITEM_ID);
        navigate(mSelectedId);


    }

    private void navigate(int selectedId) {
        switch (selectedId) {
            case R.id.nav_item_pushups:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                getSupportActionBar().setSubtitle("Pushups");
                Log.i("drawer_item", "pushups");
                mPreferences = getSharedPreferences(MyUtils.PUSHUPS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                mExerciseName = MyUtils.EXERCISE_PUSHUPS;
                initInfo();
                break;
            case R.id.nav_item_pullups:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                getSupportActionBar().setSubtitle("Pullups");
                Log.i("drawer_item", "pullups");
                mPreferences = getSharedPreferences(MyUtils.PULLUPS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                mExerciseName = MyUtils.EXERCISE_PULLUPS;
                initInfo();
                break;
            case R.id.nav_item_squats:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                getSupportActionBar().setSubtitle("Squats");
                Log.i("drawer_item", "squats");
                mPreferences = getSharedPreferences(MyUtils.SQUATS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                mExerciseName = MyUtils.EXERCISE_SQUATS;
                initInfo();
                break;
            case R.id.nav_item_dips:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                getSupportActionBar().setSubtitle("Dips");
                Log.i("drawer_item", "dips");
                mPreferences = getSharedPreferences(MyUtils.DIPS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                mExerciseName = MyUtils.EXERCISE_DIPS;
                initInfo();
                break;
        }
    }

    private void initInfo() {
        Log.i("mPreferences", mPreferences.toString() + "exercise name: - " + mExerciseName);
        isProgramSelected = mPreferences.getBoolean(MyUtils.IS_PROGRAM_SELECTED, false);
        if (mPreferences.contains(MyUtils.PROGRAM_NAME) && mPreferences.contains(MyUtils.PROGRAM_DAY)) {
            mProgramName = mPreferences.getString(MyUtils.PROGRAM_NAME, null);
            mProgramDay = mPreferences.getInt(MyUtils.PROGRAM_DAY, 0);

            if (mProgramName.equals(MyUtils.PROGRAM_END)) {
                initLabelsWithoutProgram();
            } else {
                switch (mExerciseName){
                    case MyUtils.EXERCISE_PUSHUPS:
                        mMainLabelTextView.setText(R.string.do_pushups);
                        currentPushupsProgram(mProgramName);
                        break;
                    case MyUtils.EXERCISE_PULLUPS:
                        mMainLabelTextView.setText(R.string.do_pullups);
                        currentPullupsProgram(mProgramName);
                        break;
                    case MyUtils.EXERCISE_SQUATS:
                        mMainLabelTextView.setText(R.string.do_squats);
                        currentSquatsProgram(mProgramName);
                        break;
                    case MyUtils.EXERCISE_DIPS:
                        mMainLabelTextView.setText(R.string.do_dips);
                        currentDipsProgram(mProgramName);
                        break;
                }
            }
        } else {
            initLabelsWithoutProgram();
        }
    }

    public void onClickDoButton(View view) {
        if (isProgramSelected) {
            if (mSetNumber < mReps.length - 1){
                mSetNumber += 1;

                mPlusSecondButton.setEnabled(true);
                mSkipPauseButton.setEnabled(true);
                mDoButton.setEnabled(false);

                startTimer(60000 + 100, 1000);
            } else {
                if (mProgramDay < (mCountDaysOfProgram - 1)) {
                    SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putInt(MyUtils.PROGRAM_DAY, (mProgramDay + 1));
                    editor.apply();

                    new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                            .setTitle(R.string.dialog_training_complete)
                            .setMessage(R.string.dialog_next_training)
                            .setCancelable(false)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    mSetNumber = 0;
                                    initInfo();
                                }
                            })
                            .show();
                } else {
                    final SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putString(MyUtils.PROGRAM_NAME, MyUtils.PROGRAM_END);
                    editor.apply();

                    new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                            .setTitle(R.string.dialog_program_completed)
                            .setMessage(R.string.dialog_next_program)
                            .setCancelable(false)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    mSetNumber = 0;
                                    mPlusSecondButton.setEnabled(false);
                                    mSkipPauseButton.setEnabled(false);
                                    editor.putBoolean(MyUtils.IS_PROGRAM_SELECTED, false);
                                    editor.apply();
                                    initInfo();
                                }
                            })
                            .show();
                }
            }
        } else {
            Intent intent = new Intent(this, ProgramsListActivity.class);
            intent.putExtra("exercise", mExerciseName);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    public void onClickPlusSecButton(View view) {
        mTimer.cancel();

        startTimer(mCurrentTime + 30000 + 100, 1000);
    }

    public void onClickSkipButton(View view) {
        mTimer.cancel();
        resetTimer();
        updateDoButtonLabel();
        MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.timer_sound);
        player.start();
    }

    public void onClickChangeProgramTextView(View view) {
        if (mTimer != null) {
            mTimer.cancel();
            resetTimer();
        }
        mSetNumber = 0;
        Intent intent = new Intent(this, ProgramsListActivity.class);
        intent.putExtra("exercise", mExerciseName);
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void startTimer(long time, long countDown) {
        mTimer = new CountDownTimer(time, countDown) {
            @Override
            public void onTick(long l) {
                mCurrentTime = l;
                updateTimer((int) l / 1000);
            }

            @Override
            public void onFinish() {
                resetTimer();
                MediaPlayer player = MediaPlayer.create(getApplicationContext(), R.raw.timer_sound);
                player.start();

                updateDoButtonLabel();
            }
        }.start();
    }

    private void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;

        String stringMinutes = Integer.toString(minutes);
        String stringSeconds = Integer.toString(seconds);

        if (minutes <= 9) {
            stringMinutes = "0" + stringMinutes;
        }
        if (seconds <= 9) {
            stringSeconds = "0" + stringSeconds;
        }

        mProgramTimer.setText(stringMinutes + " : " + stringSeconds);
    }

    private void resetTimer() {
        mProgramTimer.setText(R.string.prog_timer);
        mPlusSecondButton.setEnabled(false);
        mSkipPauseButton.setEnabled(false);
        mDoButton.setEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
//            mProgramName = data.getStringExtra("title");
//            mProgramDay = data.getIntExtra("day", 0);
//            isProgramSelected = data.getBooleanExtra("prog_selected", false);

            initInfo();
            Log.i("result_OK", mProgramName + " --- " + mProgramDay + " --- " + isProgramSelected);
        } else {
            Toast.makeText(this, "You don't select program", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        mSelectedId = item.getItemId();

        navigate(item.getItemId());

        return true;
    }

    private void initViews() {
        mNavigationView = (NavigationView) findViewById(R.id.main_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mDoButton = (Button) findViewById(R.id.program_do_button);
        mPlusSecondButton = (Button) findViewById(R.id.program_plus_sec_button);
        mSkipPauseButton = (Button) findViewById(R.id.program_skip_button);
        mProgramNameTextView = (TextView) findViewById(R.id.program_name);
        mProgramDayTextView = (TextView) findViewById(R.id.program_day);
        mProgramRepsTextView = (TextView) findViewById(R.id.program_reps);
        mProgramTotalTextView = (TextView) findViewById(R.id.program_total);
        mChangeProgramTextView = (TextView) findViewById(R.id.program_change_program);
        mMainLabelTextView = (TextView) findViewById(R.id.main_label);
        mProgramTimer = (TextView) findViewById(R.id.program_timer);

        mPlusSecondButton.setEnabled(false);
        mSkipPauseButton.setEnabled(false);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_DRAWER_ITEM_ID, mSelectedId);
    }

    private void initLabels(String program, String programDescription, int day, int reps[]) {
        mProgramNameTextView.setText(program + ": " + programDescription);

        mProgramDayTextView.setText(getString(R.string.prog_day, (day + 1)));

        String label_reps = "";
        int total_reps = 0;
        for (int i : reps) {
            label_reps = label_reps + i + "  ";
            total_reps = total_reps + i;
        }
        mProgramRepsTextView.setText(label_reps);
        mProgramTotalTextView.setText(getString(R.string.prog_total, total_reps));

        updateDoButtonLabel();

        mChangeProgramTextView.setVisibility(View.VISIBLE);
    }

    private void initLabelsWithoutProgram() {
        mDoButton.setText(R.string.select);
        mMainLabelTextView.setText(R.string.press_button);
        mProgramNameTextView.setText(R.string.program);
        mProgramDayTextView.setText(R.string.day);
        mProgramRepsTextView.setText("");
        mProgramTotalTextView.setText(R.string.total);
        mChangeProgramTextView.setVisibility(View.INVISIBLE);
    }

    private void updateDoButtonLabel() {
        mDoButton.setText(getString(R.string.prog_reps_button, (mSetNumber + 1),
                mReps[mSetNumber]));
    }

    private void currentPushupsProgram(String program) {
        switch (program) {
            case "Program 1":
                mReps = MyUtils.pushupsProgram1.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram1.size();
                initLabels(program, MyUtils.pushupsSubtitles[0], mProgramDay, mReps);
                break;
            case "Program 2":
                mReps = MyUtils.pushupsProgram2.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram2.size();
                initLabels(program, MyUtils.pushupsSubtitles[1], mProgramDay, mReps);
                break;
            case "Program 3":
                mReps = MyUtils.pushupsProgram3.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram3.size();
                initLabels(program, MyUtils.pushupsSubtitles[2], mProgramDay, mReps);
                break;
            case "Program 4":
                mReps = MyUtils.pushupsProgram4.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram4.size();
                initLabels(program, MyUtils.pushupsSubtitles[3], mProgramDay, mReps);
                break;
            case "Program 5":
                mReps = MyUtils.pushupsProgram5.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram5.size();
                initLabels(program, MyUtils.pushupsSubtitles[4], mProgramDay, mReps);
                break;
            case "Program 6":
                mReps = MyUtils.pushupsProgram6.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram6.size();
                initLabels(program, MyUtils.pushupsSubtitles[5], mProgramDay, mReps);
                break;
            case "Program 7":
                mReps = MyUtils.pushupsProgram7.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram7.size();
                initLabels(program, MyUtils.pushupsSubtitles[6], mProgramDay, mReps);
                break;
            case "Program 8":
                mReps = MyUtils.pushupsProgram8.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram8.size();
                initLabels(program, MyUtils.pushupsSubtitles[7], mProgramDay, mReps);
                break;
            case "Program 9":
                mReps = MyUtils.pushupsProgram9.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram9.size();
                initLabels(program, MyUtils.pushupsSubtitles[8], mProgramDay, mReps);
                break;
            case "Program 10":
                mReps = MyUtils.pushupsProgram10.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram10.size();
                initLabels(program, MyUtils.pushupsSubtitles[9], mProgramDay, mReps);
                break;
            case "Program 11":
                mReps = MyUtils.pushupsProgram11.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram11.size();
                initLabels(program, MyUtils.pushupsSubtitles[10], mProgramDay, mReps);
                break;
            case "Program 12":
                mReps = MyUtils.pushupsProgram12.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pushupsProgram12.size();
                initLabels(program, MyUtils.pushupsSubtitles[11], mProgramDay, mReps);
                break;
        }
    }

    private void currentPullupsProgram(String program) {
        switch (program) {
            case "Program 1":
                mReps = MyUtils.pullupsProgram1.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram1.size();
                initLabels(program, MyUtils.pullupsSubtitles[0], mProgramDay, mReps);

                new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                        .setTitle("Attention!")
                        .setMessage("This training is for pulldown")
                        .setCancelable(false)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .show();
                break;
            case "Program 2":
                mReps = MyUtils.pullupsProgram2.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram2.size();
                initLabels(program, MyUtils.pullupsSubtitles[1], mProgramDay, mReps);

                new AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                        .setTitle("Attention!")
                        .setMessage("This training is for pulldown")
                        .setCancelable(false)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .show();
                break;
            case "Program 3":
                mReps = MyUtils.pullupsProgram3.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram3.size();
                initLabels(program, MyUtils.pullupsSubtitles[2], mProgramDay, mReps);
                break;
            case "Program 4":
                mReps = MyUtils.pullupsProgram4.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram4.size();
                initLabels(program, MyUtils.pullupsSubtitles[3], mProgramDay, mReps);
                break;
            case "Program 5":
                mReps = MyUtils.pullupsProgram5.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram5.size();
                initLabels(program, MyUtils.pullupsSubtitles[4], mProgramDay, mReps);
                break;
            case "Program 6":
                mReps = MyUtils.pullupsProgram6.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram6.size();
                initLabels(program, MyUtils.pullupsSubtitles[5], mProgramDay, mReps);
                break;
            case "Program 7":
                mReps = MyUtils.pullupsProgram7.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram7.size();
                initLabels(program, MyUtils.pullupsSubtitles[6], mProgramDay, mReps);
                break;
            case "Program 8":
                mReps = MyUtils.pullupsProgram8.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram8.size();
                initLabels(program, MyUtils.pullupsSubtitles[7], mProgramDay, mReps);
                break;
            case "Program 9":
                mReps = MyUtils.pullupsProgram9.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram9.size();
                initLabels(program, MyUtils.pullupsSubtitles[8], mProgramDay, mReps);
                break;
            case "Program 10":
                mReps = MyUtils.pullupsProgram10.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram10.size();
                initLabels(program, MyUtils.pullupsSubtitles[9], mProgramDay, mReps);
                break;
            case "Program 11":
                mReps = MyUtils.pullupsProgram11.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.pullupsProgram11.size();
                initLabels(program, MyUtils.pullupsSubtitles[10], mProgramDay, mReps);
                break;
        }
    }

    private void currentSquatsProgram(String program) {
        switch (program) {
            case "Program 1":
                mReps = MyUtils.squatsProgram1.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram1.size();
                initLabels(program, MyUtils.squatsSubtitles[0], mProgramDay, mReps);
                break;
            case "Program 2":
                mReps = MyUtils.squatsProgram2.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram2.size();
                initLabels(program, MyUtils.squatsSubtitles[1], mProgramDay, mReps);
                break;
            case "Program 3":
                mReps = MyUtils.squatsProgram3.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram3.size();
                initLabels(program, MyUtils.squatsSubtitles[2], mProgramDay, mReps);
                break;
            case "Program 4":
                mReps = MyUtils.squatsProgram4.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram4.size();
                initLabels(program, MyUtils.squatsSubtitles[3], mProgramDay, mReps);
                break;
            case "Program 5":
                mReps = MyUtils.squatsProgram5.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram5.size();
                initLabels(program, MyUtils.squatsSubtitles[4], mProgramDay, mReps);
                break;
            case "Program 6":
                mReps = MyUtils.squatsProgram6.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram6.size();
                initLabels(program, MyUtils.squatsSubtitles[5], mProgramDay, mReps);
                break;
            case "Program 7":
                mReps = MyUtils.squatsProgram7.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram7.size();
                initLabels(program, MyUtils.squatsSubtitles[6], mProgramDay, mReps);
                break;
            case "Program 8":
                mReps = MyUtils.squatsProgram8.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram8.size();
                initLabels(program, MyUtils.squatsSubtitles[7], mProgramDay, mReps);
                break;
            case "Program 9":
                mReps = MyUtils.squatsProgram9.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram9.size();
                initLabels(program, MyUtils.squatsSubtitles[8], mProgramDay, mReps);
                break;
            case "Program 10":
                mReps = MyUtils.squatsProgram10.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram10.size();
                initLabels(program, MyUtils.squatsSubtitles[9], mProgramDay, mReps);
                break;
            case "Program 11":
                mReps = MyUtils.squatsProgram11.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram11.size();
                initLabels(program, MyUtils.squatsSubtitles[10], mProgramDay, mReps);
                break;
            case "Program 12":
                mReps = MyUtils.squatsProgram12.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram12.size();
                initLabels(program, MyUtils.squatsSubtitles[11], mProgramDay, mReps);
                break;
            case "Program 13":
                mReps = MyUtils.squatsProgram13.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram13.size();
                initLabels(program, MyUtils.squatsSubtitles[12], mProgramDay, mReps);
                break;
            case "Program 14":
                mReps = MyUtils.squatsProgram14.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram14.size();
                initLabels(program, MyUtils.squatsSubtitles[13], mProgramDay, mReps);
                break;
            case "Program 15":
                mReps = MyUtils.squatsProgram15.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.squatsProgram15.size();
                initLabels(program, MyUtils.squatsSubtitles[14], mProgramDay, mReps);
                break;
        }
    }

    private void currentDipsProgram(String program) {
        switch (program) {
            case "Program 1":
                mReps = MyUtils.dipsProgram1.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram1.size();
                initLabels(program, MyUtils.dipsSubtitles[0], mProgramDay, mReps);
                break;
            case "Program 2":
                mReps = MyUtils.dipsProgram2.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram2.size();
                initLabels(program, MyUtils.dipsSubtitles[1], mProgramDay, mReps);
                break;
            case "Program 3":
                mReps = MyUtils.dipsProgram3.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram3.size();
                initLabels(program, MyUtils.dipsSubtitles[2], mProgramDay, mReps);
                break;
            case "Program 4":
                mReps = MyUtils.dipsProgram4.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram4.size();
                initLabels(program, MyUtils.dipsSubtitles[3], mProgramDay, mReps);
                break;
            case "Program 5":
                mReps = MyUtils.dipsProgram5.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram5.size();
                initLabels(program, MyUtils.dipsSubtitles[4], mProgramDay, mReps);
                break;
            case "Program 6":
                mReps = MyUtils.dipsProgram6.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram6.size();
                initLabels(program, MyUtils.dipsSubtitles[5], mProgramDay, mReps);
                break;
            case "Program 7":
                mReps = MyUtils.dipsProgram7.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram7.size();
                initLabels(program, MyUtils.dipsSubtitles[6], mProgramDay, mReps);
                break;
            case "Program 8":
                mReps = MyUtils.dipsProgram8.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram8.size();
                initLabels(program, MyUtils.dipsSubtitles[7], mProgramDay, mReps);
                break;
            case "Program 9":
                mReps = MyUtils.dipsProgram9.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram9.size();
                initLabels(program, MyUtils.dipsSubtitles[8], mProgramDay, mReps);
                break;
            case "Program 10":
                mReps = MyUtils.dipsProgram10.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram10.size();
                initLabels(program, MyUtils.dipsSubtitles[9], mProgramDay, mReps);
                break;
            case "Program 11":
                mReps = MyUtils.dipsProgram11.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram11.size();
                initLabels(program, MyUtils.dipsSubtitles[10], mProgramDay, mReps);
                break;
            case "Program 12":
                mReps = MyUtils.dipsProgram12.get(mProgramDay);
                mCountDaysOfProgram = MyUtils.dipsProgram12.size();
                initLabels(program, MyUtils.dipsSubtitles[11], mProgramDay, mReps);
                break;
        }
    }

}
