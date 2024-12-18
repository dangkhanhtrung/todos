package com.eaut.todos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.eaut.todos.adapter.ToDoAdapter;
import com.eaut.todos.database.ToDoDBHelper;
import com.eaut.todos.model.ToDo;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnNewToDo;
    private ToDoDBHelper toDoDBHelper;
    private ToDoAdapter toDoAdapter;
    private ListView lvToDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnNewToDo = findViewById(R.id.btn_newtodo);
        lvToDos = findViewById(R.id.lv_todos);
        toDoDBHelper = new ToDoDBHelper(this);
        List<ToDo> lstTodos = toDoDBHelper.getTodos();
        toDoAdapter = new ToDoAdapter(lstTodos);
        lvToDos.setAdapter(toDoAdapter);
        btnNewToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewToDoActivity.class);
                startActivity(intent);
            }
        });
    }
}