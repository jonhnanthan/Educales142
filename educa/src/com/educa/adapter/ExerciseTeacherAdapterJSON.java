
package com.educa.adapter;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.educa.R;
import com.educa.activity.EditColorMatchExerciseActivity;
import com.educa.activity.EditCompleteExerciseStep1Activity;
import com.educa.activity.EditMultipleChoiceExerciseActivity;
import com.educa.database.DataBaseProfessor;

public class ExerciseTeacherAdapterJSON extends BaseAdapter {

    private static ArrayList<String> mListExercise;
    private LayoutInflater mInflater;
    private Context mcontext;
    private Activity parentActivity;

    public ExerciseTeacherAdapterJSON() {

    }

    public ExerciseTeacherAdapterJSON(Context context, ArrayList<String> listExercise, Activity parentActivity) {
        mListExercise = listExercise;
        mInflater = LayoutInflater.from(context);
        mcontext = context;
        this.parentActivity = parentActivity;
    }

    @Override
    public int getCount() {
        return mListExercise.size();
    }

    @Override
    public String getItem(int position) {
        return mListExercise.get(position);
    }

    @Override
    public long getItemId(int index) {
        return index;
    }

    @SuppressLint({ "ViewHolder", "InflateParams" }) @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.exercise_adapter_teacher_item, null);

        TextView tv_exercise_name = (TextView) view.findViewById(R.id.tv_exercise_name);
        TextView tv_exercise_status = (TextView) view.findViewById(R.id.tv_exercise_status);
        TextView tv_exercise_correction = (TextView) view.findViewById(R.id.tv_exercise_correction);
        TextView tv_exercise_date = (TextView) view.findViewById(R.id.tv_exercise_date);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView1);
        
        final String json = mListExercise.get(position);
        JSONObject exercise;
		try {
			exercise = new JSONObject(json);
	        tv_exercise_name.setText(exercise.getString("name"));
	        tv_exercise_status.setText(exercise.getString("status"));
	        tv_exercise_correction.setText(exercise.getString("correction"));
	        tv_exercise_date.setText(exercise.getString("date"));

	        if (exercise.getString("type").equals(DataBaseProfessor.getInstance(mcontext).COLOR_MATCH_EXERCISE_TYPECODE)) {
	            icon.setImageResource(R.drawable.colorthumb);
	        } else if (exercise.getString("type").equals(DataBaseProfessor.getInstance(mcontext).MULTIPLE_CHOICE_EXERCISE_TYPECODE)) {
	            icon.setImageResource(R.drawable.multiplethumb);
	        } else if (exercise.getString("type").equals(DataBaseProfessor.getInstance(mcontext).COMPLETE_EXERCISE_TYPECODE)) {
	            icon.setImageResource(R.drawable.completethumb);
	        }
		} catch (JSONException e) {
			Log.e("CREATE VIEW ERROR", e.getMessage());
		}

        ImageView bt_options = (ImageView)
                view.findViewById(R.id.bt_options);
        bt_options.setOnClickListener(new
                View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPopupMenu(v, json);
                    }
                });

        return view;
    }

    private void showPopupMenu(View v, final String json) {
        PopupMenu popupMenu = new PopupMenu(mcontext, v);
        popupMenu.getMenuInflater().inflate(R.menu.teacher_exercise_options, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.edit:
					JSONObject exercise;
					try {
								exercise = new JSONObject(json);
								if (exercise.getString("type").equals(DataBaseProfessor.getInstance(mcontext).MULTIPLE_CHOICE_EXERCISE_TYPECODE)) {
									Intent intent = new Intent(parentActivity, EditMultipleChoiceExerciseActivity.class);

									ArrayList<CharSequence> listMultipleChoiceExercise = new ArrayList<CharSequence>();

									listMultipleChoiceExercise.add(exercise.getString("name"));
									listMultipleChoiceExercise.add(exercise.getString("question"));
									listMultipleChoiceExercise.add(exercise.getString("alternative1"));
									listMultipleChoiceExercise.add(exercise.getString("alternative2"));
									listMultipleChoiceExercise.add(exercise.getString("alternative3"));
									listMultipleChoiceExercise.add(exercise.getString("alternative4"));
									listMultipleChoiceExercise.add(exercise.getString("answer"));
									listMultipleChoiceExercise.add(exercise.getString("date"));

									intent.putCharSequenceArrayListExtra("EditMultipleChoiseExercise", listMultipleChoiceExercise);
									parentActivity.startActivity(intent);
								}
								if (exercise.getString("type").equals(DataBaseProfessor.getInstance(mcontext).COMPLETE_EXERCISE_TYPECODE)) {
									Intent intent = new Intent(parentActivity, EditCompleteExerciseStep1Activity.class);

									ArrayList<CharSequence> listCmpleteExercise = new ArrayList<CharSequence>();

									listCmpleteExercise.add(exercise.getString("name"));
									listCmpleteExercise.add(exercise.getString("word"));
									listCmpleteExercise.add(exercise.getString("question"));
									listCmpleteExercise.add(exercise.getString("hiddenIndexes"));
									listCmpleteExercise.add(exercise.getString("date"));

									intent.putCharSequenceArrayListExtra("EditCompleteExercise", listCmpleteExercise);
									parentActivity.startActivity(intent);
								}
		                        if (exercise.getString("type").equals(DataBaseProfessor.getInstance(mcontext).COLOR_MATCH_EXERCISE_TYPECODE)) {
	                            Intent intent = new Intent(parentActivity, EditColorMatchExerciseActivity.class);
	
	                            ArrayList<CharSequence> listColorMatchExercise = new ArrayList<CharSequence>();
	
	                            listColorMatchExercise.add(exercise.getString("name"));
	                            listColorMatchExercise.add(exercise.getString("color"));
	                            listColorMatchExercise.add(exercise.getString("question"));
	                            listColorMatchExercise.add(exercise.getString("alternative1"));
	                            listColorMatchExercise.add(exercise.getString("alternative2"));
	                            listColorMatchExercise.add(exercise.getString("alternative3"));
	                            listColorMatchExercise.add(exercise.getString("alternative4"));
	                            listColorMatchExercise.add(exercise.getString("answer"));
	                            listColorMatchExercise.add(exercise.getString("date"));
	
	                            intent.putCharSequenceArrayListExtra("EditColorMatchExercise", listColorMatchExercise);
	                            parentActivity.startActivity(intent);
	                        }

					} catch (JSONException e) {
						Log.e("EDIT ERROR", e.getMessage());
					}
                        return true;
                    case R.id.delete:
                        deleteAlert(json);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public void removeAndNotify(final String json) {
    	JSONObject exercise;
		try {
			exercise = new JSONObject(json);
			DataBaseProfessor.getInstance(mcontext).removeActivity(exercise.getString("name"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
        mListExercise.remove(json);
        notifyDataSetChanged();
        
    }

    public void deleteAlert(final String json) {
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTitle(parentActivity.getResources().getString(R.string.delete_alert_title));
        builder.setMessage(parentActivity.getResources().getString(R.string.delete_alert_message));

        builder.setPositiveButton(parentActivity.getResources().getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        removeAndNotify(json);
                    }
                });

        builder.setNegativeButton(R.string.cancel,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        try {
                            finalize();
                        } catch (Throwable e) {
                            e.printStackTrace();
                        }
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
    
    
}
