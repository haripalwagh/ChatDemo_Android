package com.haripalwagh.chatdemo.Models;

/**
 * Created by haripal on 7/25/17.
 */

public class MessageCell {
    String messageSender;
    String messageText;
    String messageDateTime;
    Boolean isSender;

    public MessageCell(String messageSender, String messageText, String messageDateTime, Boolean isSender){
        this.messageSender = messageSender;
        this.messageText = messageText;
        this.messageDateTime = messageDateTime;
        this.isSender = isSender;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public String getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(String messageSender) {
        this.messageSender = messageSender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Boolean getSender() {
        return isSender;
    }

    public void setSender(Boolean sender) {
        isSender = sender;
    }
}