package com.example.login3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login_tab_fragment extends Fragment {

    EditText email,pass;
    Button btnLogin;

    private FirebaseAuth mAuth;
    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login_tab_fragment, container, false);

        mAuth= FirebaseAuth.getInstance();

        email = (EditText) rootView.findViewById(R.id.email);
        pass =(EditText) rootView.findViewById(R.id.pass);
        btnLogin =(Button) rootView.findViewById(R.id.btnLogin);

        email.setTranslationY(800);
        pass.setTranslationY(800);
        btnLogin.setTranslationY(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        btnLogin.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnLogin.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        return rootView;
    }

    public void login(){
        String emailedit,passedit;
        emailedit=email.getText().toString().trim().replaceAll("[^a-zA-Z0-9@._-]", "");
        passedit=pass.getText().toString().trim().replaceAll("[^a-zA-Z0-9@._-]", "");

        if(TextUtils.isEmpty(emailedit)){
            Toast.makeText(getContext(),"Vui lòng nhập email!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passedit)){
            Toast.makeText(getContext(),"Vui lòng nhập password!",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(emailedit,passedit).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getContext(),"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getContext(),"Đăng nhập không thành công!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}