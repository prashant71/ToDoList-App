package com.prashant.todolist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prashant.todolist.R;
import com.prashant.todolist.adaptor.RecyclerViewAdaptor;
import com.prashant.todolist.modelclass.ToDOModel;

import java.util.ArrayList;
import java.util.List;


public class ToDoListFragment extends Fragment {

    public static List<ToDOModel> todolist=new ArrayList<>();
    static{
        todolist.add(new ToDOModel("Todo1","home work"));
        todolist.add(new ToDOModel("Todo2","Your answer implies that encoding passwords in base64 is a good practice. In fact it is NOT as anyone can simply decode it."));
        todolist.add(new ToDOModel("Todo3","workout"));
        todolist.add(new ToDOModel("Todo4","shopping"));
        todolist.add(new ToDOModel("Todo5","freelance"));
        todolist.add(new ToDOModel("Todo6","Default values for encoder/decoder flags."));
        todolist.add(new ToDOModel("Todo7","Encoder flag bit to indicate lines should be terminated with a CRLF pair instead of just an LF."));
    }
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
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recycleviewAdaptor = new RecyclerViewAdaptor(getActivity(),todolist);
        recyclerView.setAdapter(recycleviewAdaptor);


        return  view;
    }
}
