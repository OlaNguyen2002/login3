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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Signup_tab_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Signup_tab_fragment extends Fragment {

    private EditText email,pass;
    private Button btnSignup;

    private FirebaseAuth mAuth;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters


    public Signup_tab_fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Signup_tab_fragment newInstance() {
        Signup_tab_fragment fragment = new Signup_tab_fragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_signup_tab_fragment, container, false);

        mAuth= FirebaseAuth.getInstance();

        email = (EditText) rootView.findViewById(R.id.email);
        pass =(EditText) rootView.findViewById(R.id.pass);
        btnSignup =(Button) rootView.findViewById(R.id.btnSignUp);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });


        return rootView;
    }
    public void SignUp(){
        String emailedit,passedit;
        emailedit=email.getText().toString();
        passedit=pass.getText().toString();

        if(TextUtils.isEmpty(emailedit)){
            Toast.makeText(getContext(),"Vui lòng nhập email!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passedit)){
            Toast.makeText(getContext(),"Vui lòng nhập password!",Toast.LENGTH_SHORT).show();
            return;
        }

        if(passedit.length() < 6 || !passedit.matches(".*[A-Z].*") || !passedit.matches(".*[!@#$%^&*()].*")){
            Toast.makeText(getContext(), "Mật khẩu phải có ít nhất 6 ký tự, bao gồm ít nhất 1 chữ cái viết hoa và 1 ký tự đặc biệt !@#$%^&*()", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailedit).matches()){
            Toast.makeText(getContext(), "Vui lòng nhập địa chỉ email hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }
        passedit = passedit.replaceAll(".", "*");
        mAuth.createUserWithEmailAndPassword(emailedit,passedit).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getContext(),"Tạo tài khoản thành công!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(),"Tạo tài khoản không thành công!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}