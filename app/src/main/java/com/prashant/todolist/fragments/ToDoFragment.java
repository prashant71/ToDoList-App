package com.prashant.todolist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prashant.todolist.R;
import com.prashant.todolist.database.ToDoListTable;
import com.prashant.todolist.database.TodoListSQLiteHelper;
import com.prashant.todolist.modelclass.ToDOModel;

public class ToDoFragment extends Fragment {
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

        TodoListSQLiteHelper dbhelper=new TodoListSQLiteHelper(getActivity());
        ToDoListTable toDoListTable=new ToDoListTable(getActivity());
        toDoListTable.insert(new ToDOModel("Home","The constructor will receive an object that implements this interfaces, along with the items to be rendered:",1));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false);
    }
}
