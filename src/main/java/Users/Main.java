package Users;

import Listings.House;
import Listings.Listing;
import Listings.Room;
import Users.Chat;
import Users.User;

public class Main {

    public static void main(String[] args){

        Listing l1 = new Listing();

        User John = new User(User.Role.HOST);
        John.setFirstName("John");
        User Jane = new User(User.Role.STUDENT);
        Jane.setFirstName("Jane");
        Conversation conversation = new Conversation(John, Jane);
        Message m1 = new Message(John, Jane, "Wanna netflix and chill?");
        Message m2 = new Message(Jane, John, "Your place or mine? ;)");
        conversation.addMessage(m1);
        conversation.addMessage(m2);
        // John.getChat().get
        //John.addConversation(conversation);
        conversation.printMessages();
//        System.out.println(John.getConversation(Jane).getMessage(0));
//        System.out.println(John.getConversation(Jane).getMessage(1));

//        Chat chat = new Chat();
//
//        chat.add


//        House house = new House();
//        house.setHouseSize(1500);
//        Room b1 = new Room(Room.Type.BATHROOM, "bathroom 1");
//        Room m = new Room(Room.Type.BEDROOM, "Master Bedroom");
//        System.out.println(b1.getName());
//        System.out.println(m.getName());
//
//        house.addRoom(b1);
//        house.addRoom(m);
//        house.addRoom(new Room(Room.Type.BATHROOM, "bathroom 2"));
//        house.addRoom(new Room(Room.Type.HALF_BATHROOM, "half_bath 1"));
//        house.addRoom(new Room(Room.Type.OUTDOORS, "Porch"));
//
//        System.out.println(house.getBathroomCount());
//
//        Listing l1 = new Listing(house);
//        if (l1.isHouse()){
//            House l1h1 = l1.getHouse();
//            l1.setVisible(true);
//            System.out.println(l1h1.getBedroomCount());
//            System.out.println(l1.isVisible());
//        }
//        else {
//            Room l1r1 = l1.getRoom();
//        }
    }
}
