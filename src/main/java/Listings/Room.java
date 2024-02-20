package Listings;

import java.util.ArrayList;

public class Room {
    private ArrayList<String> pictureList;
    private int roomSize;
    private Type type;
    private String name;

    public enum Type {
        BEDROOM,
        BATHROOM,
        HALF_BATHROOM,
        LIVING_ROOM,
        KITCHEN,
        OUTDOORS,
        OTHER
    }

    public Room() {
        this.pictureList = new ArrayList<String>();
    }

    public Room(Type type, String name) {
        this.type = type;
        this.name = name;
        this.pictureList = new ArrayList<String>();
    }

    public void setType(Type roomType) {
        this.type = roomType;
    }

    public Type getType(){
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }

    public int getRoomSize() {
        return this.roomSize;
    }

    public void setPictureList(ArrayList<String> pictureList) {
        this.pictureList = pictureList;
    }

    ArrayList<String> getPictureList() {
        return this.pictureList;
    }

    public void addPicture(String picture) {
        this.pictureList.add(picture);
    }

    public void removePicture(String picture) {
        this.pictureList.remove(picture);
    }

}
