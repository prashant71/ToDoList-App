package com.prashant.todolist.adaptor;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.prashant.todolist.MainActivity;
import com.prashant.todolist.R;
import com.prashant.todolist.database.ToDoListTable;
import com.prashant.todolist.modelclass.ToDOModel;

import java.util.List;

/**
 * Created by PRASHANT KOLI on 10/24/2016.
 */

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ItemCardHolder >{

    Context context;
    List<ToDOModel> todoList;
    ToDoListTable toDoListTable;


    public RecyclerViewAdaptor(Context context, List<ToDOModel> todoList) {
        this.todoList = todoList;
        this.context = context;
        toDoListTable=new ToDoListTable(context);
    }
    @Override
    public ItemCardHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_cardview, viewGroup, false);
        return new ItemCardHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemCardHolder holder,final int position) {
        final ToDOModel todomodel=todoList.get(position);

        holder.todoTitle.setText(todomodel.getTodoTitle());
        holder.tododescp.setText(todomodel.getTodoDescription());
        holder.priority.setText(String.valueOf(todomodel.getTodoPriority()));
        holder.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
                toDoListTable.delete(todomodel.getTodoIndex());
                ((MainActivity)context).alertSnackbar(context.getString(R.string.delete_msg),R.color.colorPrimaryDark);

            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != todoList ? todoList.size() : 0);
    }

    public void removeItem(int position){
        todoList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,todoList.size());
    }
    public class ItemCardHolder extends RecyclerView.ViewHolder{
        final CardView cv;
        TextView todoTitle;
        TextView tododescp;
        TextView priority;
        ImageButton done;
        public ItemCardHolder(View itemView) {
            super(itemView);
            cv=(CardView) itemView.findViewById(R.id.cv);
            todoTitle=(TextView) itemView.findViewById(R.id.todo_title);
            tododescp=(TextView) itemView.findViewById(R.id.todo_discp);
            priority=(TextView) itemView.findViewById(R.id.priority);
            done=(ImageButton) itemView.findViewById(R.id.imageButton);
        }
    }
}
