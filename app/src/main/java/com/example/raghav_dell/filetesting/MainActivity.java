package com.example.raghav_dell.filetesting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText f,t;
    Button a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
    }
    public void show()
    {
        f=(EditText)findViewById(R.id.editText);
        t=(EditText)findViewById(R.id.editText2);
        a=(Button)findViewById(R.id.button);
        b=(Button)findViewById(R.id.button2);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = f.getText().toString();
                String data=t.getText().toString();
                FileOutputStream fos;
                try
                {
                    fos=openFileOutput(s, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                f.setText("");
                t.setText("");
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename=f.getText().toString();
                StringBuffer ab = new StringBuffer();
                try
                {
                    BufferedReader i=new BufferedReader(new InputStreamReader(openFileInput(filename)));
                    String input;
                    while((input=i.readLine())!=null)
                    {
                      ab.append(input+"\n");
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                t.setText(ab.toString());
            }
        });

    }
}
