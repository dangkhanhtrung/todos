package com.eaut.todos.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eaut.todos.R;
import com.eaut.todos.model.ToDo;

import java.util.List;

public class ToDoAdapter extends BaseAdapter  {
    private List<ToDo> lstToDos;
    public ToDoAdapter(List<ToDo> todos) {
        this.lstToDos = todos;
    }
    @Override
    public int getCount() {
        return lstToDos.size();
    }

    @Override
    public Object getItem(int position) {
        return lstToDos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lstToDos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewToDo;
        if (convertView == null) {
            viewToDo = View.inflate(parent.getContext(), R.layout.item_todo, null);
        } else viewToDo = convertView;

        ToDo toDo = (ToDo) getItem(position);
        ((TextView) viewToDo.findViewById(R.id.txtName)).setText(toDo.getName());

        return viewToDo;
    }
}
