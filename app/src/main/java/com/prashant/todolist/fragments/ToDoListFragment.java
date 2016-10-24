package com.prashant.todolist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.prashant.todolist.R;
import com.prashant.todolist.adaptor.RecyclerViewAdaptor;
import com.prashant.todolist.database.ToDoListTable;
import com.prashant.todolist.interfaces.IClickListener;
import com.prashant.todolist.modelclass.ToDOModel;

import java.util.ArrayList;
import java.util.List;


public class ToDoListFragment extends Fragment{

    public static List<ToDOModel> todolist=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdaptor recycleviewAdaptor;
    public ToDoListFragment() {

    }

    public static ToDoListFragment newInstance() {
        ToDoListFragment fragment = new ToDoListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.recyclerview, container, false);
        View view = inflater.inflate(R.layout.recyclerview, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        TextView textview = (TextView) view.findViewById(R.id.textView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);


        ToDoListTable toDoListTable=new ToDoListTable(getActivity());
        todolist=toDoListTable.getTodoList();
        if(todolist.size()!=0) {
            textview.setVisibility(View.GONE);
            recycleviewAdaptor = new RecyclerViewAdaptor(getActivity(),todolist);
            recyclerView.setAdapter(recycleviewAdaptor);
        }else textview.setVisibility(View.VISIBLE);
        return  view;
    }
}
