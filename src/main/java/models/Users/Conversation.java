package models.Users;

import java.util.ArrayList;

public class Conversation {
    private ArrayList<Message> messageList;
    private String conversationName;
    private User p1;
    private User p2;
//    protected User contact;

    public Conversation() {

    }

    public Conversation(User p1, User p2) {
        this.messageList = new ArrayList<Message>();
        this.p1 = p1;
        this.p2 = p2;
//        this.contact = contact;
//        this.conversationName = String.format("%s %s", contact.getFirstName(), contact.getLastName());
    }

//    protected User getContact() {
//        return this.contact;
//    }

    public void printMessages() {
        for (Message m : this.messageList) {
            System.out.printf("%s: %s\n", m.getSender().getFirstName(), m.getText());
        }
    }

    public void addMessage(Message message) {
        message.setConversation(this);
        this.messageList.add(message);
    }

//    protected String getMessage(int messageId) {
//        for (Message m : this.messageList) {
//            if (m.getMessageId() == messageId) {
//                return m.getText();
//            }
//        }
//        return null;
//    }

    public User[] getPeople() {
        return new User[]{this.p1, this.p2};
    }



}
