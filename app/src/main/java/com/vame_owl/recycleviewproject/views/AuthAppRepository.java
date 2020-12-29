package com.vame_owl.recycleviewproject.views;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.vame_owl.recycleviewproject.model.Message;
import com.vame_owl.recycleviewproject.model.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.firebase.database.FirebaseDatabase.getInstance;


public class AuthAppRepository {
    private Context context;

    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;
    private MutableLiveData<List<Message>> mesMutableLiveData= new MutableLiveData<>();
    List<Message> listMessage = new ArrayList<Message>();

    public MutableLiveData<List<Message>> getMesMutableLiveData() {
        return mesMutableLiveData;
    }

    public List<Message> getListMessage() {
        return listMessage;
    }

    public AuthAppRepository(Context context) {
        this.context = context;
        this.firebaseAuth = FirebaseAuth.getInstance();
        this.userLiveData = new MutableLiveData<>();
        this.loggedOutLiveData = new MutableLiveData<>();


        if (firebaseAuth.getCurrentUser() != null) {
            userLiveData.postValue(firebaseAuth.getCurrentUser());
            loggedOutLiveData.postValue(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void login(String email, String password) {
        System.out.println(context+"!!!!!!!!!!!!!!!!!!!!");
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String uiId = firebaseAuth.getUid();

                            userLiveData.postValue(firebaseAuth.getCurrentUser());
                            System.out.println(context + "succes");
                            System.out.println(userLiveData.getValue()+"user!@@@@@@@");

                            DatabaseReference mDatabase = getInstance().getReference("messages");

                            mDatabase.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                    Message message =  snapshot.getValue(Message.class);
                                    listMessage.add(message);
                                    mesMutableLiveData.setValue(listMessage);

                                    System.out.println(message+"         aaaaaaaaaa");
                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                                }

                                @Override
                                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                                }

                                @Override
                                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                            Toast.makeText(context, "LogIn Succes",Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, "Login Failure: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void register(String email, String password) {
        System.out.println(context+"!!!!!!!!!!!!!!!!!!!!");
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            System.out.println(firebaseAuth.getCurrentUser().getUid());
                            userLiveData.postValue(firebaseAuth.getCurrentUser());

                            //сылка на юзера
                            FirebaseAuth mAuth = FirebaseAuth.getInstance();
                            DatabaseReference mDatabase = getInstance().getReference();

                            String userId= mAuth.getUid();
                            User user = new User(userId , password,email);
                            Toast.makeText(context, "Register Succes  "+mAuth.getCurrentUser().getEmail(),Toast.LENGTH_LONG).show();

                            mDatabase.child("users").child(userId).setValue(user);

                            Message message = new Message(email, "body", "time");

                            Map<String, Object> messageValues = message.toMap();
                            Map<String, Object> childUpdates = new HashMap<>();

                            String key = mDatabase.child("messages").push().getKey();
                            childUpdates.put("/messages/" + key, messageValues);
                            childUpdates.put("/user-messages/" + userId + "/" + key, messageValues);

                            mDatabase.updateChildren(childUpdates);

                        } else {
                            System.out.println(task.getException().getMessage()+"123451111");
                            Toast.makeText(context, "Registration Failure: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void logOut() {
        firebaseAuth.signOut();
        loggedOutLiveData.postValue(true);
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }
}