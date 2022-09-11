package com.priyanshu.infoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText name,password,address,age,dob;
    Spinner state;
    RadioGroup gender;
    Calendar calendar;
    TextView name2,password2,address2,age2,dob2,state2,gender2;
    private DatePicker datePicker;
    int d,y,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.username);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        dob = findViewById(R.id.date);
        state = findViewById(R.id.spinner);
        gender = findViewById(R.id.gendergroup);
        name2 = findViewById(R.id.username2);
        password2 = findViewById(R.id.password2);
        age2 = findViewById(R.id.age2);
        address2 = findViewById(R.id.addres2);
        dob2 = findViewById(R.id.birth2);
        state2 = findViewById(R.id.state);
        gender2 = findViewById(R.id.gender2);
        calendar = Calendar.getInstance();
        y=calendar.get(calendar.YEAR);
        d=calendar.get(calendar.DAY_OF_MONTH);
        m=calendar.get(calendar.MONTH);
        showDate(y,m,d);
        dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                showDialog(999);
            }
        });



        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton rb = findViewById((int)gender.getCheckedRadioButtonId());
                name2.setText(name.getText().toString());
                age2.setText(age.getText().toString());
                password2.setText(password.getText().toString());
                address2.setText(address.getText().toString());
                dob2.setText(dob.getText().toString());
                state2.setText(state.getSelectedItem().toString());
                gender2.setText(rb.getText().toString());
            }
        });


    }
    private void showDate(int y,int m ,int d){
        dob.setText(y+"/"+(m+1)+"/"+d);
    }
    protected Dialog onCreateDialog(int id) {
        calendar=Calendar.getInstance();
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, y, m, d);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    showDate(arg1, arg2, arg3);
                }
            };



}