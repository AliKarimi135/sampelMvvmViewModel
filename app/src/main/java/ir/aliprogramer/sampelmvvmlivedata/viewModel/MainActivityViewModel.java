package ir.aliprogramer.sampelmvvmlivedata.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import ir.aliprogramer.sampelmvvmlivedata.mode.User;

public class MainActivityViewModel extends AndroidViewModel {
    Application application;
    MutableLiveData<String> name=new MutableLiveData<>();
    MutableLiveData<String>errorName=new MutableLiveData<>();
    List<User>list;

    MutableLiveData<String>mobile=new MutableLiveData<>();
    MutableLiveData<String>errorMobile=new MutableLiveData<>();

    MutableLiveData<String>city=new MutableLiveData<>();
    MutableLiveData<String>errorCity=new MutableLiveData<>();
    MutableLiveData<List<User>>userLiveData=new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
    }
public  void init(List<User> userList){
this.list=userList;
}
    public void registerUser() {
        if(!checkInput())
            return;
        list.add(0,new User(getName().getValue(),getMobile().getValue(),getCity().getValue()));
        userLiveData.setValue(list);
    }
    public boolean checkInput(){
        clearError();
        boolean result=true;

        if(getName().getValue().equals("")) {
            errorName.setValue("وارد کردن اسم الزامی است");
            result=false;
        }
        if(getMobile().getValue().equals("")) {
            errorMobile.setValue("وارد کردن موبایل الزامی است");
            result=false;
        }
        if(getCity().getValue().equals("")) {
            errorCity.setValue("وارد کردن شهر الزامی است");
            result=false;
        }

        int len=getMobile().getValue().length();
        if(len!=11) {
            errorMobile.setValue("شماره موبایل 11 رقمی است" );
            result=false;
        }
        return result;
    }
    private void clearError(){
        errorName.setValue("");
        errorMobile.setValue("");
        errorCity.setValue("");
    }
    public void getAllUserData(){
        for(int i=0;i<12;i++)
            list.add(new User("a"+i,"0912"+i,"s"+i));
        userLiveData.setValue(list);
    }
    public MutableLiveData<List<User>> getUserLiveData() {
        return userLiveData;
    }

    public void setUserLiveData(MutableLiveData<List<User>> userLiveData) {
        this.userLiveData = userLiveData;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }

    public MutableLiveData<String> getErrorName() {
        return errorName;
    }

    public void setErrorName(MutableLiveData<String> errorName) {
        this.errorName = errorName;
    }

    public MutableLiveData<String> getMobile() {
        return mobile;
    }

    public void setMobile(MutableLiveData<String> mobile) {
        this.mobile = mobile;
    }

    public MutableLiveData<String> getErrorMobile() {
        return errorMobile;
    }

    public void setErrorMobile(MutableLiveData<String> errorMobile) {
        this.errorMobile = errorMobile;
    }

    public MutableLiveData<String> getCity() {
        return city;
    }

    public void setCity(MutableLiveData<String> city) {
        this.city = city;
    }

    public MutableLiveData<String> getErrorCity() {
        return errorCity;
    }

    public void setErrorCity(MutableLiveData<String> errorCity) {
        this.errorCity = errorCity;
    }


}
