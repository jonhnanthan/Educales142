
package com.educa.graphics;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.educa.R;
import com.educa.activity.EditNumMatchExerciseActivity;;

public class NumPickerDialog extends Dialog {
    OnMyDialogResult callback;

    public NumPickerDialog(Context context) {
        super(context);
        this.setTitle("NumPickerDialog");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.num_picker_dialog);

        final GridView gridViewColors = (GridView) findViewById(R.id.gridViewImages);
        gridViewColors.setAdapter(new NumPickerAdapter(getContext()));

        // close the dialog on item click
        gridViewColors.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EditNumMatchExerciseActivity.image = gridViewColors.getAdapter()
                        .getItem(position).toString();
                EditNumMatchExerciseActivity.setImage((Integer) gridViewColors.getAdapter()
                        .getItem(position));

                /*
                 * colorSelected = (Integer)
                 * gridViewColors.getAdapter().getItem(position);
                 * tv_choose.setText("Color Selected"); LinearLayout
                 * layout_choose = (LinearLayout)
                 * findViewById(R.id.layout_choose);
                 * layout_choose.setBackgroundColor(colorSelected);
                 * layout_choose.setAlpha((float) 0.5);
                 */

                NumPickerDialog.this.dismiss();
            }
        });
    }

    public void setDialogResult(OnMyDialogResult onMyDialogResult) {
        callback = (OnMyDialogResult) onMyDialogResult;
    }

    public interface OnMyDialogResult {
        void finish(String result);
    }
}
