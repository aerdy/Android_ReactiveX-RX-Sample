package com.necis.rx;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.schedulers.HandlerScheduler;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func0;

import static android.os.Process.THREAD_PRIORITY_BACKGROUND;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBasic = (Button) findViewById(R.id.btnBasic);
        Button btnOperator = (Button) findViewById(R.id.btnOperator);
        Button btnhandlerevent = (Button) findViewById(R.id.btnHandlerAndEvent);
        Button btnAsyntasc = (Button) findViewById(R.id.btnAsynta);
        btnBasic.setOnClickListener(this);
        btnhandlerevent.setOnClickListener(this);
        btnOperator.setOnClickListener(this);
        btnAsyntasc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int idhan = v.getId();
        Intent intent = null;
        switch (idhan) {
            case R.id.btnBasic:
                intent = new Intent(getApplicationContext(), BasicActivity.class);
                startActivity(intent);
                break;
            case R.id.btnOperator:
                intent = new Intent(getApplicationContext(), OperatorActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHandlerAndEvent:
                intent = new Intent(getApplicationContext(), HandlerAndEventActivity.class);
                startActivity(intent);
                break;
            case R.id.btnAsynta:
                intent = new Intent(getApplicationContext(), AsynchronusActivity.class);
                startActivity(intent);
                break;
        }
    }
}
