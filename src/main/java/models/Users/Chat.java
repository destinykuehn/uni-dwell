package models.Users;

import java.util.ArrayList;

public class Chat extends Conversation {
    private ArrayList<Conversation> conversationList;

    public Chat() {
        this.conversationList = new ArrayList<Conversation>();
    }

    public ArrayList<Conversation> getConversationList() {
        return this.conversationList;
    }

    public void addConversation(Conversation conversation) {
        this.conversationList.add(conversation);
    }

    public void removeConversation(Conversation conversation) {
        this.conversationList.remove(conversation);
    }

//    protected Conversation getConversation(User contact) {
//        for (Conversation c : conversationList) {
//            if (c.p1 == contact || c.p2 == contact){
//                System.out.println("found c");
//                return c;
//            }
//        }
//        return null;
//    }
}
