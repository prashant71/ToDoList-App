package com.prashant.todolist.modelclass;

/**
 * Created by PRASHANT KOLI on 10/17/2016.
 */

public class ToDOModel {
    String todoTitle;
    String todoDescription;
    int todoPriority;
    int todoIndex;

    public ToDOModel() {
    }

    public ToDOModel(String todoTitle, String todoDescription, int todoPriority) {
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
        this.todoPriority = todoPriority;
    }

    public ToDOModel(String todoTitle, String todoDescription, int todoPriority, int todoIndex) {
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
        this.todoPriority = todoPriority;
        this.todoIndex = todoIndex;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public int getTodoPriority() {
        return todoPriority;
    }

    public void setTodoPriority(int todoPriority) {
        this.todoPriority = todoPriority;
    }

    public int getTodoIndex() {
        return todoIndex;
    }

    public void setTodoIndex(int todoIndex) {
        this.todoIndex = todoIndex;
    }
}
