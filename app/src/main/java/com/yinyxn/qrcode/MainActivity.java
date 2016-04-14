package com.yinyxn.qrcode;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    Button button2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText);
        editText.setTextColor(Color.TRANSPARENT);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (text.length() != 0) {
                    Bitmap bitmap = null;
                    try {
                        bitmap = EncodingHandler.createQRCode(text, 350);
                        imageView.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showHide(View view) {
        if (editText.getCurrentTextColor()==Color.TRANSPARENT){
            editText.setTextColor(Color.BLACK);
            button2.setText("隐藏");
        }else {
            editText.setTextColor(Color.TRANSPARENT);
            button2.setText("显示");
        }
    }
}
