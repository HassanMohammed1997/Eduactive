package com.project.semicolon.eduactive.customview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.project.semicolon.eduactive.R;

/**
 * Created by blackmaple on 2017/5/9.
 */

public class CourseBlock extends AppCompatTextView {
    public CourseBlock(Context context) {
        super(context);
        setTextColor(ContextCompat.getColor(context, R.color.darken));
        setGravity(Gravity.CENTER);
        setPadding(2, 0, 2, 0);
        setTextSize(12);
    }

    @Override
    public void setBackgroundColor(int color) {
        StateListDrawable background_drawable = new StateListDrawable();
        background_drawable.addState(
                new int[]{android.R.attr.state_pressed}, new ColorDrawable(
                        getResources().getColor(R.color.overlay_dark_40)));
        background_drawable.addState(
                new int[]{android.R.attr.state_enabled}, new ColorDrawable(
                        color));
        setBackgroundDrawable(background_drawable);
    }

    public void resetBlock() {
        setText(null);
        setTag(null);
        super.setBackgroundColor(Color.TRANSPARENT);
        setOnClickListener(null);
    }
}
