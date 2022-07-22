package com.example.healthstreet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class Register extends AppCompatActivity {

    //create obj of DatabaseReference class to access firebase's Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://healthstreetproject-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullname = findViewById(R.id.fullname);
        final EditText email =findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText address = findViewById(R.id.address );
        final EditText password = findViewById(R.id.password);
        final EditText conPassword = findViewById(R.id.conPassword);

        final Button registerBtn = findViewById(R.id.registerBtn);
        final TextView loginNowBtn = findViewById(R.id.loginNowBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get data from EditText into string var
                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String addressTxt = address.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String conPasswordTxt = conPassword.getText().toString();

                // check if user fill all the field before sending
                if(fullnameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty() || addressTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                // check if pass match
                else if (!passwordTxt.equals(conPasswordTxt)){
                    Toast.makeText(Register.this, "Password are not match!", Toast.LENGTH_SHORT).show();
                }

                else {

                    databaseReference.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            // check if phone number is not register before

                            if(snapshot.hasChild(phoneTxt)){
                                Toast.makeText(Register.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                // sending data to firebase Realtime Database
                                // phone num as unique id user
                                databaseReference.child("Users").child(phoneTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("Users").child(phoneTxt).child("email").setValue(emailTxt);
                                databaseReference.child("Users").child(phoneTxt).child("address").setValue(addressTxt);
                                databaseReference.child("Users").child(phoneTxt).child("password").setValue(passwordTxt);

                                Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }
        });

        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}