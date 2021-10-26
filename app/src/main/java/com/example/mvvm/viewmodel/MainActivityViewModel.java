package com.example.mvvm.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.model.User;
import com.example.mvvm.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

UserRepository userRepository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository=new UserRepository(application);
    }

     public LiveData<User[]> getAllUserdata(){
        return userRepository.getUserData();

     }
}

















/* //viewmodel + live data
public String sumResult(String value1,String value2)
  {
     int num1=Integer.parseInt(value1);
     int num2=Integer.parseInt(value2);
     int sum=num1+num2;
     return String.valueOf(sum);
  }
   //viewmodel and live data
  MutableLiveData<String> liveData;

  public  MutableLiveData<String> sumResult(String value1,String value2)
  {
     int num1=Integer.parseInt(value1);
     int num2=Integer.parseInt(value2);
     int sum=num1+num2;
     if(liveData==null)
     {
            liveData=new MutableLiveData<>();
     }

     liveData.setValue(String.valueOf(sum));
     return liveData;
  }
 */