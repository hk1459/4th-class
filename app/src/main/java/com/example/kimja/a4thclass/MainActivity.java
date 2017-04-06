package com.example.kimja.a4thclass;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8;
    EditText editText, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "일반 메시지 창입니다.", Toast.LENGTH_SHORT).show();

            }
        });

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x = editText.getText().toString();
                String y = editText2.getText().toString();
                Toast toastView = Toast.makeText(getApplicationContext(), "위치 지정 메시지 창입니다.", Toast.LENGTH_SHORT);

                toastView.setGravity(Gravity.LEFT | Gravity.TOP, Integer.parseInt(x), Integer.parseInt(y));
                toastView.show();

            }
        });

        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.mytoast, null);  //인플레이트 시켜서 레이아웃 불러오기
                // 레이아웃 안에있는 텍스트뷰 객체화
                TextView msg = (TextView) view.findViewById(R.id.msg);//findViewByld 앞에 view(중요) 다른 레이아웃의 텍스트뷰를 가져와서 객체화시킴

                Toast toastView = new Toast(getApplicationContext());
                toastView.setDuration(Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.CENTER, 0, 100);
                toastView.setView(view);
                toastView.show();

                //노트북이 만약에 없으면 4공 101 로

            }
        });
        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Message", 1000).setAction("확인", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();


            }
        });

    }
    public void onClick(View v){  //온클릭으로 하는법 알기
        if(v.getId() == R.id.b5){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("제목")  //일반적인 대화상자
                        .setMessage("내용")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기",null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "확인을 눌렀습니다",Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
        }
        else if (v.getId() == R.id.b6){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            String data[] = {"치킨","피자"};
            dlg.setTitle("먹고싶은 메뉴는?")
                    .setSingleChoiceItems(data, 1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),
                                    "확인을 눌렀습니다",Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .show();
        }
        else if (v.getId() == R.id.b7){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            final String data[] = {"치킨","피자", "짜장", "탕슉"};
            final boolean checked[] = {true,false,true,false};

            dlg.setTitle("먹고싶은 메뉴는?")  //일반적인 대화상자

                    .setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            String print = "";
                            for(int i = 0; i< data.length; i++)
                                if(checked[i]);

                        }
                    })
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),
                                    "확인을 눌렀습니다",Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .show();
        }
        else if (v.getId() == R.id.b8){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            View view = View.inflate(getApplicationContext(),R.layout.layout,null);
            final EditText et = (EditText)view.findViewById(R.id.editText3);
            dlg.setTitle("먹고싶은 메뉴는?")
                    .setView(view)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {  // 확인버튼에 이벤트걸기
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),
                                    et.getText().toString()+"입니다.",Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .show();
        }

    }

}
