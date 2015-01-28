
package com.educa.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import com.educa.R;
import com.educa.graphics.ColorPickerAdapter;

import java.util.ArrayList;

public class ColorMatchExerciseStep1Activity extends Activity {
    ImageButton bt_next_step;
    Integer colorSelected;
    TextView tv_choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match_exercise_step1);
        bt_next_step = (ImageButton) findViewById(R.id.bt_next_step);
        tv_choose = (TextView) findViewById(R.id.tv_choose);

        final GridView gridViewColors = (GridView) findViewById(R.id.gridViewColors);
        gridViewColors.setAdapter(new ColorPickerAdapter(getApplicationContext()));

        gridViewColors.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                colorSelected = (Integer) gridViewColors.getAdapter().getItem(position);
                tv_choose.setText("Cor Selecionada");
                LinearLayout layout_choose = (LinearLayout) findViewById(R.id.layout_choose);
                layout_choose.setBackgroundColor(colorSelected);
                layout_choose.setAlpha((float) 0.8);
            }
        });

        bt_next_step.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (colorSelected != null) {
                    ArrayList<CharSequence> exerciseData = new ArrayList<CharSequence>();
                    exerciseData.add(colorSelected.toString());

                    Intent intent = new Intent(getApplicationContext(),
                            ColorMatchExerciseStep2Activity.class);
                    intent.putCharSequenceArrayListExtra("ColorData", exerciseData);

                    startActivity(intent);
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            getApplicationContext().getResources().getString(
                                    R.string.choose_a_color),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
