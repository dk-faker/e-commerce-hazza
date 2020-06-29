package com.example.hazza.utils;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;
import static com.example.hazza.utils.AppConstants.CONNECTION_INTERNET;
import static com.example.hazza.utils.AppConstants.INTERNET;
import static com.example.hazza.utils.AppConstants.viewConstant;


public class NetworkChangeReceiver extends BroadcastReceiver{
    private Snackbar snackbar;
    private  TextView txtSnackbar;
    private View view;


    @Override
    public void onReceive(Context context, Intent intent)
    {
        try
        {
            if (isOnline(context)) {
                dialog(true);
                Log.e("Inat", "Online Connect Intenet ");
            } else {
                dialog(false);
                Log.e("Inat", "Conectivity Failure !!! ");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();

        }
    }

    public  void dialog(boolean value){


        if(value){
getViewDataBindingTrue();
        }
        else {

getViewDataBindingFalse();
        }

    }
    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void Constante(View view){
        viewConstant=view;
    }

    public void getViewDataBindingFalse() {
        CONNECTION_INTERNET=1;
        INTERNET=0;
        snackbar  = Snackbar.make(viewConstant,"Sin conexion",Snackbar.LENGTH_INDEFINITE);
        View views = snackbar.getView();
        txtSnackbar = (TextView)views.findViewById(com.google.android.material.R.id.snackbar_text);
        CoordinatorLayout.LayoutParams params =(CoordinatorLayout.LayoutParams)views.getLayoutParams();
        views.setLayoutParams(params);
        txtSnackbar.setTextSize(14);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            txtSnackbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            txtSnackbar.setGravity(Gravity.CENTER_VERTICAL);
        }
        snackbar.show();

    }

    public void getViewDataBindingTrue() {

        if (CONNECTION_INTERNET == 1 && INTERNET == 0) {
            txtSnackbar.setText("De nuevo en línea");
            snackbar.getView().setBackgroundColor(Color.BLUE);
            txtSnackbar.setTextColor(Color.WHITE);
            Handler handler = new Handler();
            Runnable delayrunnable = new Runnable() {
                @Override
                public void run() {
                    snackbar.dismiss();
                }
            };
            handler.postDelayed(delayrunnable, 3000);
            //CONNECTION_INTERNET = 2;
        }
    }


        }


