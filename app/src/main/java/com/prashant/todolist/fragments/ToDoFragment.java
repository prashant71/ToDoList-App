package com.prashant.todolist.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.prashant.todolist.MainActivity;
import com.prashant.todolist.R;
import com.prashant.todolist.database.ToDoListTable;
import com.prashant.todolist.modelclass.ToDOModel;

public class ToDoFragment extends Fragment implements View.OnClickListener {
    TextInputLayout inputtext_title,inputtext_descp;
    EditText title,descp;
    Button save;
    ToDoListTable toDoListTable;
    RadioGroup rgPriority;
    public ToDoFragment() {
        // Required empty public constructor
    }

    public static ToDoFragment newInstance() {
        ToDoFragment fragment = new ToDoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toDoListTable=new ToDoListTable(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todo, container, false);
        intiview(view);
        return view;
    }
    private void intiview(View v) {
        inputtext_title = (TextInputLayout) v.findViewById(R.id.log_inputlayout_title);
        inputtext_descp = (TextInputLayout) v.findViewById(R.id.log_inputlayout_descp);

        title = (EditText) v.findViewById(R.id.edt_title);
        descp = (EditText) v.findViewById(R.id.edt_descp);

        save=(Button)  v.findViewById(R.id.btn_save);
        save.setOnClickListener(this);
        rgPriority = (RadioGroup) v.findViewById(R.id.priorityradioGroup);
    }

    @Override
    public void onClick(View v) {
        inputtext_title.setErrorEnabled(false);
        inputtext_descp.setErrorEnabled(false);
        ToDOModel toDOModel=new ToDOModel();

        int selectedId=rgPriority.getCheckedRadioButtonId();
        RadioButton priorityRadio = (RadioButton) rgPriority.findViewById(selectedId);
        int priority=Integer.parseInt(priorityRadio.getText().toString());
        if(validation()){
            toDOModel.setTodoTitle(title.getText().toString());
            toDOModel.setTodoDescription(descp.getText().toString());
            toDOModel.setTodoPriority(priority);
            toDoListTable.insert(toDOModel);
            (getActivity()).onBackPressed();
            ((MainActivity)getActivity()).alertSnackbar(getString(R.string.success_msg),android.R.color.holo_green_dark);

        }
    }
    private boolean validation() {
        boolean value=false;
            if (title.getText().toString().startsWith(" ") || title.getText().toString().length()<=0) {
                inputtext_title.setError(getString(R.string.todo_error_title));
                value=false;
            }else if (descp.getText().toString().startsWith(" ") || descp.getText().toString().length()<=0) {
                inputtext_descp.setError(getString(R.string.todo_error_descp));
                value=false;
            }else value=true;
        return value;

    }


}
