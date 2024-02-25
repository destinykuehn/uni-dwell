package models.Users;

import java.time.LocalDateTime;

public class Message {

    private int messageId;
    private User sender;
    private User receiver;
    private String text;
    private LocalDateTime timeStamp;
    private Conversation conversation;

    public Message() {
        setTimeStamp();
        this.timeStamp = getTimeStamp();
    }

    public Message(User sender, User receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        setTimeStamp();
        this.timeStamp = getTimeStamp();
    }

    public Message(Conversation conversation, User sender, User receiver, String text) {
        this.conversation = conversation;
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        setTimeStamp();
        this.timeStamp = getTimeStamp();
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

//    protected void setMessageId() {
//        int count = 0;
//        for (Message m : this.conversation.messageList) {
//            count += 1;
//        }
//        this.messageId = count;
//    }

    public int getMessageId() {
        return this.messageId;
    }

    public void setSender(User user) {
        this.sender = user;
    }

    public User getSender() {
        return this.sender;
    }

    public void setReceiver(User user) {
        this.receiver = user;
    }

    public User getReceiver() {
        return this.receiver;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setTimeStamp() {
        this.timeStamp = LocalDateTime.now();
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }


}
