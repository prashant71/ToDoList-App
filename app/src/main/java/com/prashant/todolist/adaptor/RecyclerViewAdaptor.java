package com.prashant.todolist.adaptor;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.prashant.todolist.R;
import com.prashant.todolist.interfaces.IClickListener;
import com.prashant.todolist.modelclass.ToDOModel;

import java.util.List;

/**
 * Created by PRASHANT KOLI on 10/17/2016.
 */
public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ItemCardHolder >{

    Context context;
    List<ToDOModel> todoList;

    public RecyclerViewAdaptor(Context context, List<ToDOModel> todoList) {
        this.todoList = todoList;
        this.context = context;
    }
    @Override
    public ItemCardHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_cardview, viewGroup, false);
        return new ItemCardHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemCardHolder holder, int position) {
        final ToDOModel todomodel=todoList.get(position);

        holder.todoTitle.setText(todomodel.getTodoTitle());
        holder.tododescp.setText(todomodel.getTodoDescription());
//        holder.priority.setText(todomodel.getTodoIndex());//need to check or change
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
    public class ItemCardHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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
            done.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            removeItem(getAdapterPosition());
            //delete from DB also call here
        }
    }
}
