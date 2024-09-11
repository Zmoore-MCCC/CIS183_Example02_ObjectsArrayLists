package com.example.cis183_example02_objectsarraylists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Employee> listOfEmployees;
    public EmployeeListAdapter(Context c, ArrayList<Employee> ls)
    {
        context = c;
        listOfEmployees = ls;
    }
    @Override
    public int getCount()
    {
        return listOfEmployees.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfEmployees.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }

        //find the GUI elements in my custom_cell
        TextView username = view.findViewById(R.id.tv_v_cc_UserName);
        TextView fullname = view.findViewById(R.id.tv_v_cc_fullname);

        //get data this particular user from the employee list
        //I can access different elements based off the i value that is passed to this function
        Employee emp = listOfEmployees.get(i);

        //set the GUI for the custom_cell
        username.setText(emp.getUsername());
        fullname.setText(emp.getLname() + ", " + emp.getFname());

        return view;
    }
}
