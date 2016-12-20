package ua.r4mstein.myworkouts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProgramsListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProgramsAdapter mProgramsAdapter;
    private SharedPreferences mPreferences;

    private int mModelListSize;
    private List<ProgramsModel> mModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.prog_list_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("List of Programs");

        mModelList = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.prog_list_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        String exerciseName = getIntent().getStringExtra("exercise");
        switch (exerciseName) {
            case MyUtils.EXERCISE_PUSHUPS:
                mModelListSize = MyUtils.pushupsSubtitles.length;
                updateModelList(MyUtils.titles, MyUtils.pushupsSubtitles);
                mPreferences = getSharedPreferences(MyUtils.PUSHUPS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                break;
            case MyUtils.EXERCISE_PULLUPS:
                mModelListSize = MyUtils.pullupsSubtitles.length;
                updateModelList(MyUtils.titles, MyUtils.pullupsSubtitles);
                mPreferences = getSharedPreferences(MyUtils.PULLUPS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                break;
            case MyUtils.EXERCISE_SQUATS:
                mModelListSize = MyUtils.squatsSubtitles.length;
                updateModelList(MyUtils.titles, MyUtils.squatsSubtitles);
                mPreferences = getSharedPreferences(MyUtils.SQUATS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                break;
            case MyUtils.EXERCISE_DIPS:
                mModelListSize = MyUtils.dipsSubtitles.length;
                updateModelList(MyUtils.titles, MyUtils.dipsSubtitles);
                mPreferences = getSharedPreferences(MyUtils.DIPS_APP_PREFERENCES,
                        Context.MODE_PRIVATE);
                break;
        }

        mProgramsAdapter = new ProgramsAdapter(mModelList);
        mRecyclerView.setAdapter(mProgramsAdapter);
    }

    private void updateModelList(String[] titles, String[] subtitles) {
        for (int i = 0; i < mModelListSize; i++) {
            mModelList.add(new ProgramsModel(titles[i], subtitles[i]));
        }
    }

    private class ProgramsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ProgramsModel mProgramsModel;
        private TextView mTitleTextView;
        private TextView mSubtitleTextView;

        public ProgramsHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.findViewById(R.id.rv_item_title);
            mSubtitleTextView = (TextView) itemView.findViewById(R.id.rv_item_subtitle);
        }

        @Override
        public void onClick(View view) {
            SharedPreferences.Editor editor = mPreferences.edit();
            editor.putString(MyUtils.PROGRAM_NAME, mProgramsModel.getTitle());
            editor.putInt(MyUtils.PROGRAM_DAY, 0);
            editor.putBoolean(MyUtils.IS_PROGRAM_SELECTED, true);
            editor.apply();

            Intent intent = new Intent();
//            intent.putExtra("title", mProgramsModel.getTitle());
//            intent.putExtra("day", 0);
//            intent.putExtra("prog_selected", true);
            setResult(RESULT_OK, intent);
            finish();
        }

        public void bindModel(ProgramsModel programsModel) {
            mProgramsModel = programsModel;
            mTitleTextView.setText(mProgramsModel.getTitle());
            mSubtitleTextView.setText(mProgramsModel.getSubtitle());
        }

    }

    private class ProgramsAdapter extends RecyclerView.Adapter<ProgramsHolder> {

        private List<ProgramsModel> mProgramsModelList;

        public ProgramsAdapter(List<ProgramsModel> programsModelList) {
            mProgramsModelList = programsModelList;
        }

        @Override
        public ProgramsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
            View view = layoutInflater.inflate(R.layout.recycler_item_prog_list, parent, false);
            return new ProgramsHolder(view);
        }

        @Override
        public void onBindViewHolder(ProgramsHolder holder, int position) {
            ProgramsModel model = mProgramsModelList.get(position);
            holder.bindModel(model);
        }

        @Override
        public int getItemCount() {
            return mProgramsModelList.size();
        }
    }
}
