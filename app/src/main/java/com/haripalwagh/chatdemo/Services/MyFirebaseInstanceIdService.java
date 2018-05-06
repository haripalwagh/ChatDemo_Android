package com.haripalwagh.chatdemo.Services;

import android.util.Log;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.haripalwagh.chatdemo.Models.FirebaseUserModel;
import com.haripalwagh.chatdemo.Models.User;

/**
 * Created by haripal on 7/25/17.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    User user = User.getInstance();

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        if (refreshedToken != null) {
            Log.d(TAG, "Refreshed token: " + refreshedToken);

            // If you want to send messages to this application instance or
            // manage this apps subscriptions on the server side, send the
            // Instance ID token to your app server.
            sendTokenToServer(refreshedToken);
        }
    }

    public void sendTokenToServer(final String strToken) {
        // API call to send token to Server

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference usersRef = database.getReference("users");

        usersRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                for (com.google.firebase.database.DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    //Getting the data from snapshot
                    FirebaseUserModel firebaseUserModel = userSnapshot.getValue(FirebaseUserModel.class);

                    if (strToken != null && firebaseUserModel.getDeviceId().equals(user.deviceId) && !strToken.equals(firebaseUserModel.getDeviceToken())) {
                        user.deviceToken = strToken;
                        usersRef.child(userSnapshot.getKey()).child("deviceToken").setValue(strToken, new Firebase.CompletionListener() {

                            @Override
                            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                                if (firebaseError != null) {
                                    Log.i(TAG, firebaseError.toString());
                                } else {
                                    System.out.println("Refreshed Token Updated");
                                }
                            }
                        });

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getMessage());
            }
        });

    }
}