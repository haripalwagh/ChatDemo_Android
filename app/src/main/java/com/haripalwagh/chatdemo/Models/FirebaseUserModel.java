package com.haripalwagh.chatdemo.Models;

/**
 * Created by haripal on 7/25/17.
 */

public class FirebaseUserModel {

    String deviceId = "";
    String deviceToken = "";
    String username = "";

    public FirebaseUserModel() {
      /*Blank default constructor essential for Firebase*/
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
