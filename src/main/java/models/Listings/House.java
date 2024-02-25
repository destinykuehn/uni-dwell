package models.Listings;

import models.Errors.CustomException;

import java.math.BigDecimal;
import java.util.ArrayList;

//public class House extends Property implements Space {
public class House {
    private int lotSize;
    private int houseSize;
    private ArrayList<Room> roomList;

    public House(){
        this.roomList = new ArrayList<Room>();
    }

    public void setRoomList(ArrayList<Room> roomList){
        this.roomList = roomList;
    }

    public ArrayList<Room> getRoomList(String name){
        return this.roomList;
    }

    public void addRoom(Room room){
        this.roomList.add(room);
    }

    public Room getRoom(String name){
        for (Room r : roomList){
            if (r.getName().equals(name)){
                return r;
            }
        }
        return null;
    }

    public void removeRoom(Room room){
        this.roomList.remove(room);
    }

    public void removeRoom(String name){
        int index = 0;
        for (Room r : roomList){
            if (r.getName().equals(name)){
                index = roomList.indexOf(r);
                break;
            }
        }
        this.roomList.remove(index);
    }

    public int getBedroomCount() {
        int count = 0;
        for (Room r : roomList){
            if (r.getType().name().equals("BEDROOM")){
                count++;
            }
        }
        return count;
    }

    public BigDecimal getBathroomCount() {
        double count = 0.0;
        for (Room r : roomList){
            if (r.getType().name().equals("BATHROOM")){
                count += 1.0;
            }
            else if (r.getType().name().equals("HALF_BATHROOM")){
                count += 0.5;
            }
        }
        return BigDecimal.valueOf(count);
    }

    public void setLotSize(int lotSize) throws CustomException {
        if (lotSize > this.houseSize){
            this.lotSize = lotSize;
        }
        else {
            // lot size cannot be smaller
            // than house size
            throw new CustomException(0);
        }
    }

    public int getLotSize() {
        return this.lotSize;
    }

    public void setHouseSize(int houseSize) {
        this.houseSize = houseSize;
    }

    public int getHouseSize() {
        return this.houseSize;
    }

}
