package com.example.cis183_example02_objectsarraylists;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //setup GUI and Java connection
        et_j_uName        = findViewById(R.id.et_v_username);
        et_j_fName        = findViewById(R.id.et_v_firstname);
        et_j_lName        = findViewById(R.id.et_v_lastname);
        et_j_email        = findViewById(R.id.et_v_email);
        btn_j_register    = findViewById(R.id.btn_v_register);
        lv_j_employeeList = findViewById(R.id.lv_v_listOfUsers);
        sp_j_departments  = findViewById(R.id.sp_v_departments);

        registerButtonClickEvent();
        //how to resize array:
        //1. copy components (element by element) to new temp array.  temp array will be the size of old array
        //2. resize old array
        //3. copy temp array (element by element) to resized old array

        //setup and initialize arrayList
        listOfEmployees = new ArrayList<Employee>();
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

    private void addEmployeeToList()
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
        listAllEmployeeData();
    }
    //testing purposes only
    private void listAllEmployeeData()
    {
        for(int i = 0; i < listOfEmployees.size(); i++)
        {
            Log.d("fname: ", listOfEmployees.get(i).getFname());
        }
    }
}