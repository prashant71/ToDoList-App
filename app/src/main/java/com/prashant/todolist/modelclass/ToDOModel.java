package com.prashant.todolist.modelclass;

/**
 * Created by PRASHANT KOLI on 10/17/2016.
 */

public class ToDOModel {
    String todoTitle;
    String todoDescription;
    String todoDate;
    int todoPriority;
    boolean todoStatus;

    public ToDOModel() {
    }

    public ToDOModel(String todoTitle, String todoDescription) {
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
    }
    public ToDOModel(String todoTitle, String todoDescription, String todoDate, int todoPriority, boolean todoStatus) {
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
        this.todoDate = todoDate;
        this.todoPriority = todoPriority;
        this.todoStatus = todoStatus;
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

    public String getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(String todoDate) {
        this.todoDate = todoDate;
    }

    public int getTodoPriority() {
        return todoPriority;
    }

    public void setTodoPriority(int todoPriority) {
        this.todoPriority = todoPriority;
    }

    public boolean isTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}
