package com.example.baiso2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText edtUser, edtPass,edtCPass;
    private Button btnLogIn, btnSignUp, btnBack;
    private FirebaseAuth mAuth;
    private CheckBox show1, show2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        edtUser = findViewById(R.id.edtUser_ofSU);
        edtPass = findViewById(R.id.edtPass_ofSU);
        edtCPass = findViewById(R.id.edtConPass_ofSU);
        btnLogIn = findViewById(R.id.btn_login_ofSU);
        btnSignUp = findViewById(R.id.btn_signup_ofSU);
        btnBack = findViewById(R.id.btnBack_ofSU);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

        show1 = findViewById(R.id.checkBox1_ofSU);
        show1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCHecked) {
                if (isCHecked){
                    //show pass
                    edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        show2 = findViewById(R.id.checkBox2_ofSU);
        show2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCHecked) {
                if (isCHecked){
                    //show pass
                    edtCPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    edtCPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    public void logIn(){
        Intent intent = new Intent(SignUp.this, LogIn.class);
        startActivity(intent);
    }

    private void signUp(){
        String email, pass;
        email = edtUser.getText().toString();
        pass = edtPass.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui lòng nhập Username/Email của bạn", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui lòng nhập Password của bạn", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     Toast.makeText(getApplicationContext(),"Tạo Tài khoản thành công!", Toast.LENGTH_SHORT).show();
                     Intent intent = new Intent(SignUp.this, QuanLyCa.class);
                     startActivity(intent);
                 }else {
                     Toast.makeText(getApplicationContext(),"Tạo Tài khoản không thành công!", Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }

}