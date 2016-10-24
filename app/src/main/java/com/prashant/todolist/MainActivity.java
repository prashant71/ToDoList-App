package com.prashant.todolist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.prashant.todolist.fragments.ToDoFragment;
import com.prashant.todolist.fragments.ToDoListFragment;

/**
 * Created by PRASHANT KOLI on 10/17/2016.
 */
public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    private void initview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ToDoListFragment toDoListFragment = ToDoListFragment.newInstance();
        fragmenttransaction(toDoListFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addtodo:
                item.setVisible(false);
                setUpdateToolbarView(true,getString(R.string.toolbar_menu_add));
                ToDoFragment toDoFragment = ToDoFragment.newInstance();
                fragmenttransaction(toDoFragment);
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        if(fm.getBackStackEntryCount()<=1){
            finish();
        }else {
            fm.popBackStack();
            setUpdateToolbarView(false,getString(R.string.app_name));
            invalidateOptionsMenu();
        }

    }

    private void fragmenttransaction(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void setUpdateToolbarView(boolean value,String title){
        toolbar.setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(value);
        getSupportActionBar().setDisplayShowHomeEnabled(value);
    }
}
