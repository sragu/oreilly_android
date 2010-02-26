package com.oreilly.android.taskmanager.views;

import com.oreilly.android.taskmanager.tasks.Task;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;

public class TaskListItem extends LinearLayout {
	
	private Task task;
	private CheckedTextView checkbox;

	public TaskListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		checkbox = (CheckedTextView)findViewById(android.R.id.text1);
	}

	public void setTask(Task task) {
		this.task = task;
		checkbox.setText(task.getName());
		checkbox.setChecked(task.isComplete());
		

		if (checkbox.isChecked()) {
			checkbox.setTextColor(Color.GRAY);
			checkbox.setPaintFlags(checkbox.getPaintFlags()
					| Paint.STRIKE_THRU_TEXT_FLAG);
			checkbox.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
		} else {
			checkbox.setTextColor(Color.WHITE);
			checkbox.setPaintFlags(checkbox.getPaintFlags()
					& ~Paint.STRIKE_THRU_TEXT_FLAG);
			checkbox.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
		}

	}

	public Task getTask() {
		return task;
	}

}
