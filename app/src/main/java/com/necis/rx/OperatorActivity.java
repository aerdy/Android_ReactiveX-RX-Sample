package com.necis.rx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Jarcode on 2016-03-08.
 */
public class OperatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        Observable<Integer> myArrayObservable
                = Observable.from(new Integer[]{1, 2, 3, 4, 5, 6}); // Emits each item of the array, one at a time

        myArrayObservable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer i) {
                Log.d("My Action", String.valueOf(i)); // Prints the number received
            }
        });

        myArrayObservable = myArrayObservable.map(new Func1<Integer, Integer>() { // Input and Output are both Integer
            @Override
            public Integer call(Integer integer) {
                return integer * integer; // Square the number
            }
        });

        myArrayObservable
                .skip(2) // Skip the first two items
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) { // Ignores any item that returns false
                        return integer % 2 == 0;
                    }
                });
    }
}
