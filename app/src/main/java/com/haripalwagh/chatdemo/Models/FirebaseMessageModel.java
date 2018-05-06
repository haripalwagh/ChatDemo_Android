package com.haripalwagh.chatdemo.Models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

/**
 * Created by haripal on 7/25/17.
 */

public class FirebaseMessageModel {

    private String senderDeviceId;
    private String text;
    private Long createdDate;
    private String senderName;
    private String Id;

    public FirebaseMessageModel() {
      /*Blank default constructor essential for Firebase*/
    }

    public String getSenderDeviceId() {
        return senderDeviceId;
    }

    public void setSenderDeviceId(String senderDeviceId) {
        this.senderDeviceId = senderDeviceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public java.util.Map<String, String> getCreatedDate() {
        return ServerValue.TIMESTAMP;
    }

    @Exclude
    public Long getCreatedDateLong() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}