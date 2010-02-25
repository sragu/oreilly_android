package com.oreilly.android.taskmanager.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.oreilly.android.taskmanager.R;
import com.oreilly.android.taskmanager.tasks.Task;
import com.oreilly.android.taskmanager.views.TaskListItem;

public class TaskListAdapter extends ArrayAdapter<Task> {
	
	private List<Task> tasks;
	private Context context;

	public TaskListAdapter(Context context, int resource,
			int textViewResourceId, List<Task> tasks) {
		super(context, resource, textViewResourceId, tasks);
		this.tasks = tasks;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TaskListItem tli;
		if (null == convertView) {
			tli = (TaskListItem)View.inflate(context, R.layout.task_list_item, null);
		} else {
			tli = (TaskListItem)convertView;
		}
		tli.setTask(tasks.get(position));
		return tli;
	}

	public void forceReload() {
		notifyDataSetChanged();
	}

	public void toggleTaskCompleteAtPosition(int position) {
		Task task = getItem(position);
		task.toggleComplete();
		notifyDataSetChanged();
	}

	public void removeCompletedTasks() {
		ArrayList<Task> completedTasks = new ArrayList<Task>();
		for (Task task : tasks) {
			if (task.isComplete()) {
				completedTasks.add(task);
			}
		}
		tasks.removeAll(completedTasks);
		notifyDataSetChanged();
	}

}
