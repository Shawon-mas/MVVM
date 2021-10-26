package com.example.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvm.R;
import com.example.mvvm.adaptar.UserAdaptar;
import com.example.mvvm.model.User;
import com.example.mvvm.viewmodel.MainActivityViewModel;


public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    EditText editText1,editText2;
    TextView textView;
    Button button;
    RecyclerView recyclerViewD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewD=findViewById(R.id.recycleview);
        recyclerViewD.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mainActivityViewModel = new  ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getAllUserdata().observe(this, new Observer<User[]>() {
            @Override

            public void onChanged(User[] users) {
                recyclerViewD.setAdapter(new UserAdaptar(users));

            }
        });


    }
}






/* //viewmodel + live data implementation
editText1=findViewById(R.id.first);
        editText2=findViewById(R.id.two);
        button=findViewById(R.id.buttonid);
        textView=findViewById(R.id.txtview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             mainActivityViewModel.sumResult(editText1.getText().toString(),editText2.getText().toString()).observe(MainActivity.this, new Observer<String>() {
                 @Override
                 public void onChanged(String s) {
                     textView.setText(s);
                 }
             });


            }
        });
  }
 */