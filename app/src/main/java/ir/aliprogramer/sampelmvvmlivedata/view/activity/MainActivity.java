package ir.aliprogramer.sampelmvvmlivedata.view.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import ir.aliprogramer.sampelmvvmlivedata.R;
import ir.aliprogramer.sampelmvvmlivedata.mode.User;
import ir.aliprogramer.sampelmvvmlivedata.view.adapter.UserAdapter;
import ir.aliprogramer.sampelmvvmlivedata.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout nameLayout;
    TextInputEditText name;


    TextInputLayout mobileLayout;
    TextInputEditText mobile;

    TextInputLayout cityLayout;
    TextInputEditText city;

    AppCompatButton btnRegister,btnCancel;
    RecyclerView recyclerView;
    List<User>userList=new ArrayList<>();
    UserAdapter userAdapter;
    MainActivityViewModel mainActivityViewModel=null;
    MutableLiveData<String>temp=new MutableLiveData<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameLayout=findViewById(R.id.name_layout);
        name=findViewById(R.id.name);

        mobileLayout=findViewById(R.id.mobile_layout);
        mobile=findViewById(R.id.mobile);

        cityLayout=findViewById(R.id.city_layout);
        city=findViewById(R.id.city);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        userAdapter=new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
        btnRegister=findViewById(R.id.register);
        btnCancel=findViewById(R.id.cancel);

        if(mainActivityViewModel==null)
            mainActivityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init(userList);
        mainActivityViewModel.getAllUserData();
        mainActivityViewModel.getUserLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userList=users;
                userAdapter.notifyDataSetChanged();
                Log.d("listSize",userList.size()+"");
            }
        });
        btnRegister.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        printError();


    }

    private void printError() {
        mainActivityViewModel.getErrorName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                nameLayout.setError(s);
            }
        });

        mainActivityViewModel.getErrorMobile().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mobileLayout.setError(s);
            }
        });
        mainActivityViewModel.getErrorCity().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cityLayout.setError(s);
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:registerUser();break;
            case R.id.cancel:finish();break;
        }
    }

    private void registerUser() {
            temp.setValue(name.getText().toString().trim());
            mainActivityViewModel.setName(temp);
            temp.setValue(mobile.getText().toString().trim());
            mainActivityViewModel.setMobile(temp);
            temp.setValue(city.getText().toString().trim());
            mainActivityViewModel.setCity(temp);
            mainActivityViewModel.registerUser();
    }
}
