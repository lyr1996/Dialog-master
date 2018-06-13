package com.example.dell_.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButton();
    }
    public void getButton(){
        bt1=(Button)findViewById(R.id.button1);
        bt2=(Button)findViewById(R.id.button2);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }
@Override
public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                tishi();
                break;
            case R.id.button2:
                denglu();
                break;
        }
}
public void tishi(){
    new AlertDialog.Builder(this).setTitle("提示")
            .setMessage("Username:abc       Password:123")
            .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).create().show();

}

private void denglu(){
    LayoutInflater inflater=getLayoutInflater();
    final View view=inflater.inflate(R.layout.login,null);

    new AlertDialog.Builder(this)
            .setTitle("登录")
            .setView(view)
            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String username=((EditText)view.findViewById(R.id.user)).getText().toString();
                    String password=((EditText)view.findViewById(R.id.pass)).getText().toString();
                    if(username.equals("abc")&&password.equals("123")){
                        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                }else {
                        Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
                    }
                }
            })
            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })
            .create()
            .show();
}

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
