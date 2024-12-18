package com.eaut.todos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.eaut.todos.database.ToDoDBHelper;

public class NewToDoActivity extends AppCompatActivity {
    private Button btnAddToDo;
    private ToDoDBHelper toDoDBHelper;
    private EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_to_do);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAddToDo = findViewById(R.id.btn_addtodo);
        edtName = findViewById(R.id.edt_todo);
        toDoDBHelper = new ToDoDBHelper(this);
        btnAddToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                toDoDBHelper.addToDo(name);
                Intent intent = new Intent(NewToDoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}