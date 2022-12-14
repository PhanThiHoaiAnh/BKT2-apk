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

public class LogIn extends AppCompatActivity {

    private EditText edtMail, edtPass;
    private Button btnLogIn, btnSignUp, btnBack;
    private FirebaseAuth mAuth;
    private CheckBox show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();

        edtMail = findViewById(R.id.edtName_ofLIn);
        edtPass = findViewById(R.id.edtPass_ofLIn);
        btnLogIn = findViewById(R.id.btn_login_ofLIn);
        btnSignUp = findViewById(R.id.signup_OfLIn);
        btnBack = findViewById(R.id.btnBack_ofLIn);

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

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

        show = findViewById(R.id.checkBox);
        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
    }
    private void logIn() {
        String email, pass;
        email = edtMail.getText().toString();
        pass = edtPass.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Vui l??ng nh???p Username/Email c???a b???n", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Vui l??ng nh???p Password c???a b???n", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "????ng nh???p th??nh c??ng!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogIn.this, QuanLyCa.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "????ng nh???p th???t b???i!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void signUp(){
        Intent intent = new Intent(LogIn.this, SignUp.class);
        startActivity(intent);
    }
}
