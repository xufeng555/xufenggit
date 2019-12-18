package com.example.xiaoshixunlianxi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int count=0;
    private ImageView mImage;
    private TextView mTime;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what==1){
                String[] str={"4","3","2","1"};
                mTime.setText(str[count]);
                count++;
                if (count==3){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }else {
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.image);
        mTime = (TextView) findViewById(R.id.time);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        mImage.startAnimation(animation);
        handler.sendEmptyMessageDelayed(1,1000);
    }
}
