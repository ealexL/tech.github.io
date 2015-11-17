package com.testcode.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by yi on 2015/11/17.
 */
public class BlockActivity extends Activity implements View.OnClickListener {
    private Button mBtn;
    private EditText mEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.block_layout);
        mBtn = (Button) findViewById(R.id.button1);
        mBtn.setOnClickListener(this);
        mEdt = (EditText) findViewById(R.id.edittext1);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        String str = mEdt.getText().toString();
        switch (str){
            case "1":
                ExampleClass mExampleClass = new ExampleClass();
                break;
            case "2":
                ExampleClass aExampleClass = new ExampleClass();
                aExampleClass.normalMethod();
                break;
            case "3":
                ExampleClass.staticNormalMethod();
                break;
            case "4":
                ChildExampleClass mChildExampleClass = new ChildExampleClass();
                break;
            case "5":
                ChildExampleClass aChildExampleClass = new ChildExampleClass();
                aChildExampleClass.normalMethod();
                break;
            case "6":
                ChildExampleClass.staticNormalMethod();
                break;
            default:
                break;
        }
    }

    public static class ExampleClass {
        public ExampleClass()

        {
            System.out.println("这是构造函数");
        }

        public void normalMethod()

        {
            //普通的代码块
            {
                System.out.println("这是普通的代码块");
            }
            System.out.println("这在普通的代码块外面一层");
        }

        {
            System.out.println("这是构造代码块");
        }

        static {
            System.out.println("这是静态代码块");
        }

        public static void staticNormalMethod()

        {
            System.out.println("这是静态方法");
        }
    }

    public static class ChildExampleClass extends ExampleClass {
        public ChildExampleClass()

        {
            System.out.println("这是子类构造函数");
        }

        static{
            System.out.println("这是子类静态代码块");
        }
        public void normalMethod()

        {
            //普通的代码块
            {
                System.out.println("这是子类普通的代码块");
            }
            System.out.println("这在子类普通的代码块外面一层");
        }

        {
            System.out.println("这是子类构造代码块");
        }


        public static void staticNormalMethod()

        {
            System.out.println("这是子类静态方法");
        }
    }
}
