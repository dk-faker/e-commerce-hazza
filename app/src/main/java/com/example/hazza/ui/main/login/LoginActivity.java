package com.example.hazza.ui.main.login;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hazza.BR;
import com.example.hazza.R;
import com.example.hazza.ViewModelProviderFactory;
import com.example.hazza.data.model.api.LoginRequest;
import com.example.hazza.databinding.ActivityLoginBinding;
import com.example.hazza.ui.base.BaseActivity;
import com.example.hazza.ui.main.MainActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {


    @Inject
    ViewModelProviderFactory factory;
    private LoginViewModel mLoginViewModel;
    private ActivityLoginBinding mActivityLoginBinding;
    private EditText txtUser,txtPass;

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this,factory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
        Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login() {
        String email = txtUser.getText().toString();
        String password = txtPass.getText().toString();
        LoginRequest.ServerLoginRequest request = new LoginRequest.ServerLoginRequest();
        request.setUsername("admin");
        request.setPassword("123456");

        //hideKeyboard();
        if(email.isEmpty()){
            Toast.makeText(this, "Debes ingresar tu usuario", Toast.LENGTH_SHORT).show();
        }else if(password.isEmpty()){
            Toast.makeText(this, "Debes ingresar tu contraseña", Toast.LENGTH_SHORT).show();
        }else{
            //mLoginViewModel.login(email,password);
            mLoginViewModel.login(request);
        }

    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
        txtUser=(EditText)findViewById(R.id.etEmail);
        txtPass=(EditText)findViewById(R.id.etPassword);
        //txtUser.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
    }
}
