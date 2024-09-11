package com.example.cis183_example02_objectsarraylists;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    EditText et_j_uName;
    EditText et_j_fName;
    EditText et_j_lName;
    EditText et_j_email;

    Spinner sp_j_departments;

    Button btn_j_register;

    ListView lv_j_employeeList;

    ArrayList<Employee> listOfEmployees;

    TextView tv_j_errorMsg;
    TextView tv_j_usernameError;

    boolean validUsername = false;

    EmployeeListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //setup GUI and Java connection
        et_j_uName         = findViewById(R.id.et_v_username);
        et_j_fName         = findViewById(R.id.et_v_firstname);
        et_j_lName         = findViewById(R.id.et_v_lastname);
        et_j_email         = findViewById(R.id.et_v_email);
        btn_j_register     = findViewById(R.id.btn_v_register);
        lv_j_employeeList  = findViewById(R.id.lv_v_listOfUsers);
        sp_j_departments   = findViewById(R.id.sp_v_departments);
        tv_j_errorMsg      = findViewById(R.id.tv_v_errorMsg);
        tv_j_usernameError = findViewById(R.id.tv_v_usernameError);

        //set the error message to invisible
        tv_j_errorMsg.setVisibility(View.INVISIBLE);

        registerButtonClickEvent();
        userNameKeyEventListener();
        //how to resize array:
        //1. copy components (element by element) to new temp array.  temp array will be the size of old array
        //2. resize old array
        //3. copy temp array (element by element) to resized old array

        //setup and initialize arrayList
        listOfEmployees = new ArrayList<Employee>();
        fillListView();
    }

    private void registerButtonClickEvent()
    {
        btn_j_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //this is where we will go in the code when we click the register button
                //this is just for testing
//                et_j_uName.setText("zmoore");
//                et_j_fName.setText("zack");
//                et_j_lName.setText("Moore");
//                et_j_email.setText("zmoore@gmail.com");
                addEmployeeToList();

            }
        });
    }

    private void userNameKeyEventListener()
    {
        et_j_uName.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                //Log.d("Text changing: " , "User is typing into textbox");
                validUsername = validUsername(et_j_uName.getText().toString());

                if(validUsername)
                {
                    //no error message
                    tv_j_usernameError.setText("Username");
                    tv_j_usernameError.setTextColor(Color.BLACK);
                    btn_j_register.setEnabled(true);
                }
                else
                {
                    //error message
                    tv_j_usernameError.setText("Error: username already exists");
                    tv_j_usernameError.setTextColor(Color.RED);
                    btn_j_register.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void addEmployeeToList()
    {

        if(!et_j_uName.getText().toString().isEmpty() && !et_j_fName.getText().toString().isEmpty() && !et_j_lName.getText().toString().isEmpty() && !et_j_email.getText().toString().isEmpty())
        {
            //create a new employee object
            Employee employeeToAdd = new Employee();

            //fill data into the new employee object
            //get the information for the textboxes
            employeeToAdd.setUsername(et_j_uName.getText().toString());
            employeeToAdd.setFname(et_j_fName.getText().toString());
            employeeToAdd.setLname(et_j_lName.getText().toString());
            employeeToAdd.setEmail(et_j_email.getText().toString());

            //add the new employee to our list of employees
            listOfEmployees.add(employeeToAdd);

            //testing purposes only
            //listAllEmployeeData();

            Log.d("User added: ", "The user was added to the list");
            tv_j_errorMsg.setVisibility(View.INVISIBLE);
            //needed to make sure listview shows employees that were recently added to our list
            adapter.notifyDataSetChanged();
            clearTextboxes();
        }
        else
        {
            Log.d("Error: ", "Error you did not fill out the entire form");
            //make the error message visible
            tv_j_errorMsg.setVisibility(View.VISIBLE);
        }

    }

    private void clearTextboxes()
    {
        et_j_uName.setText("");
        et_j_fName.setText("");
        et_j_lName.setText("");
        et_j_email.setText("");
    }
    //testing purposes only
    private void listAllEmployeeData()
    {
        for(int i = 0; i < listOfEmployees.size(); i++)
        {
            Log.d("fname: ", listOfEmployees.get(i).getFname());
        }
    }

    private boolean validUsername(String u)
    {
        for(Employee emp : listOfEmployees)
        {
            if(emp.getUsername().equals(u))
            {
                return false;
            }
        }

        return true;
    }

    private void fillListView()
    {
        adapter = new EmployeeListAdapter(this, listOfEmployees);
        //set the listview adapter
        lv_j_employeeList.setAdapter(adapter);
    }
}