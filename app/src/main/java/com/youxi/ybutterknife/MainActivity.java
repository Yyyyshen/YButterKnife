package com.youxi.ybutterknife;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @YBindView(R.id.tv_main)
    TextView tv_main;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        YBind.bind(this);//能否只在base里声明，继承即可用
        tv_main.setText("Hello,My BindView.");
    }

    @YBindClick(R.id.tv_main)
    public void showToast(){
        Toast.makeText(MainActivity.this,"My BindClass.",Toast.LENGTH_SHORT).show();
    }
}
