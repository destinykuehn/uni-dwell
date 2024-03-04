package controllers;

/* Handle Listing information */

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;
import java.sql.*;

import models.Errors.CustomException;
import models.Listings.House;
import models.Listings.Listing;
import models.Listings.Property;
import models.Listings.Room;

@WebServlet("/ListingServlet")
public class ListingServlet extends HttpServlet {
    /* Exception logger */
    private static final Logger logger = Logger.getLogger(IndexServlet.class.getName());

    private static final int maxChar = 15;

    public ListingServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            System.out.printf("Hello from %s%n", this.getClass().getName());
            if (Objects.equals(req.getParameter("action"), "create")){
                if(Objects.equals(req.getParameter("isHouse"), "true") && Objects.equals(req.getParameter("isRoom"), "true")){
                    System.out.println("Invalid listing type");
                }
                else if(Objects.equals(req.getParameter("isHouse"), "true")) {
                    System.out.println("Creating a new house listing");
                    createHouseListing(req, resp);
                }
                else if(Objects.equals(req.getParameter("isRoom"), "true")) {
                    System.out.println("Creating a new room listing");
                    createRoomListing(req, resp);
                }
                else {
                    System.out.println("No listing type specified");
                }

            }
            else if (Objects.equals(req.getParameter("action"), "update")){
                System.out.println("Updating a listing");
                /* Update a listing */
            }
            else if (Objects.equals(req.getParameter("action"), "delete")){
                System.out.println("Deleting a listing");
                /* Delete a listing */
            }
            else if (Objects.equals(req.getParameter("action"), "view")){
                System.out.println("View a listing");
                /* View a listing */
            }
            else {
                System.out.println("No action specified");
            }


        }
        catch (Exception e) {
            handleException(e);
        }

    }

    private void handleException(Exception e) {
        /* Log the error message */
        logger.severe("An error occurred: " + e.getMessage());
        /* Log the stack trace */
        logger.throwing(ExampleServlet.class.getName(), "methodName", e);
    }

    private int createHouseListing(HttpServletRequest req, HttpServletResponse resp) throws CustomException, SQLException, IOException, ClassNotFoundException {

        House house = createHouse(req, resp);
        Listing listing = new Listing(house);

        String listingName = req.getParameter("listingName");

        if (!checkTextValid(listingName)) {
            System.out.println("Invalid listing name");
            return 1;
        }

        listing.setListingName(listingName);

        String numRooms = req.getParameter("numRooms");

        if (house != null) {
            house.setRoomList(createRooms (req, resp, Integer.parseInt(numRooms)));
        }

        createProperty(req, resp, listing);

        //insertListingIntoDB(listing,"NMT", "Host");

        ArrayList<Listing> listings = new ArrayList<Listing>();

        retrieveListingsFromDBbyCollege(req, listings);

        printListings(listings, 0, 1);


        return 0;
    }

    private void createRoomListing(HttpServletRequest req, HttpServletResponse resp) {
        Room room = createRooms(req, resp, 1).getFirst();
        if (room != null) {
            Listing listing = new Listing(room);
        }
    }

    private void updateListing(HttpServletRequest req, HttpServletResponse resp, ArrayList<Listing> listings ) throws IOException, CustomException, SQLException {
        String listingPosition = req.getParameter("listingPosition");
        ByteArrayInputStream oldInputStream = serializeListing(listings.get(Integer.parseInt(listingPosition)));

        if (Objects.equals(req.getParameter("isHouse"), "true")) {
            House house = createHouse(req, resp);
            Listing listing = new Listing(house);
            String listingName = req.getParameter("listingName");
            if (!checkTextValid(listingName)) {
                System.out.println("Invalid listing name");
                return;
            }
            listing.setListingName(listingName);
            String numRooms = req.getParameter("numRooms");
            if (house != null) {
                house.setRoomList(createRooms(req, resp, Integer.parseInt(numRooms)));
            }
            createProperty(req, resp, listing);
            ByteArrayInputStream newInputStream = serializeListing(listing);
            updateListingInDB(oldInputStream, newInputStream);
        }
        else if (Objects.equals(req.getParameter("isRoom"), "true")) {
            Room room = createRooms(req, resp, 1).getFirst();
            if (room != null) {
                Listing listing = new Listing(room);
                String listingName = req.getParameter("listingName");
                if (!checkTextValid(listingName)) {
                    System.out.println("Invalid listing name");
                    return;
                }
                listing.setListingName(listingName);
                createProperty(req, resp, listing);
                ByteArrayInputStream newInputStream = serializeListing(listing);
                updateListingInDB(oldInputStream, newInputStream);
            }
        }

    }


    private void deleteListing(HttpServletRequest req, HttpServletResponse resp) {
        /* Delete a listing */
    }

    private void viewListing(HttpServletRequest req, HttpServletResponse resp) {
        /* View a listing */
    }

    private House createHouse(HttpServletRequest req, HttpServletResponse resp) throws CustomException {
        String houseName = req.getParameter("houseName");
        String lotSize = req.getParameter("lotSize");
        String houseSize = req.getParameter("houseSize");

        if (!checkTextValid(houseName)) {
            System.out.println("Invalid house name");
            return null;
        }
        if (!checkNumberValid(lotSize)) {
            System.out.println("Invalid lot size");
            return null;
        }
        if (!checkNumberValid(houseSize)) {
            System.out.println("Invalid house size");
            return null;
        }

        House house = new House();
        house.setName(houseName);
        house.setLotSize(Integer.parseInt(lotSize));
        house.setHouseSize(Integer.parseInt(houseSize));

        return house;
    }

    private ArrayList<Room> createRooms(HttpServletRequest req, HttpServletResponse resp, int numRooms){
        ArrayList<Room> roomList = new ArrayList<Room>();
        for (int i = 0; i < numRooms; i++) {
            //Add room to house
            String roomName = req.getParameter("roomName" + i);
            String roomSize = req.getParameter("roomSize" + i);
            String roomType = req.getParameter("roomType" + i);

            if (!checkTextValid(roomName)) {
                System.out.println("Invalid room name");
                return null;
            }

            if (!checkNumberValid(roomSize)) {
                System.out.println("Invalid room size");
                return null;
            }

            Room room = new Room();
            room.setName(roomName);
            room.setRoomSize(Integer.parseInt(roomSize));
            room.setType(Room.Type.valueOf(roomType));

            roomList.add(room);

        }
        return roomList;
    }
    private int createProperty(HttpServletRequest req, HttpServletResponse resp, Listing listing) throws CustomException {
        String propertyName = req.getParameter("propertyName");
        String propertyType = req.getParameter("propertyType");
        String address = req.getParameter("address");
        String rent = req.getParameter("rent");
        String deposit = req.getParameter("deposit");
        String dateBuilt = req.getParameter("dateBuilt");
        String dateAvailable = req.getParameter("dateAvailable");
        String coolingType = req.getParameter("coolingType");
        String heatingType = req.getParameter("heatingType");
        String parkingType = req.getParameter("parkingType");
        String laundryType = req.getParameter("laundryType");
        String petsAllowed = req.getParameter("petsAllowed");

        if (!checkTextValid(propertyName)) {
            System.out.println("Invalid property name");
            return 1;
        }
        if (!checkTextValid(address)) {
            System.out.println("Invalid address");
            return 1;
        }
        if (!checkNumberValid(rent)) {
            System.out.println("Invalid rent");
            return 1;
        }
        if (!checkNumberValid(deposit)) {
            System.out.println("Invalid deposit");
            return 1;
        }
        if (!checkDateValid(dateBuilt)) {
            System.out.println("Invalid dateBuilt");
            return 1;
        }
        if (!checkDateValid(dateAvailable)) {
            System.out.println("Invalid dateAvailable");
            return 1;
        }

        listing.setName(propertyName);
        listing.setRent(Integer.parseInt(rent));
        listing.setDeposit(Integer.parseInt(deposit));
        listing.setDateBuilt(java.sql.Date.valueOf(dateBuilt));
        listing.setDateAvailable(java.sql.Date.valueOf(dateAvailable));
        listing.setAddress(address);
        listing.setPropertyType(Property.Type.valueOf(propertyType));
        listing.setCooling(Property.Cooling.valueOf(coolingType));
        listing.setHeating(Property.Heating.valueOf(heatingType));
        listing.setParking(Property.Parking.valueOf(parkingType));
        listing.setLaundry(Property.Laundry.valueOf(laundryType));
        listing.setPetPolicy(Property.PetPolicy.valueOf(petsAllowed));

        return 0;
    }


    private void insertListingIntoDB(Listing listing, String college, String host) throws IOException, SQLException {
        ByteArrayInputStream inputStream = serializeListing(listing);
        String sql = "INSERT INTO Listings (college, host, listingObj) VALUES (?, ?, ?)";
        String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
        String ps = "cse3026uni-dwell";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "admin", ps);
        PreparedStatement update = con.prepareStatement(sql);
        update.setString(1, college);
        update.setString(2, host);
        update.setBlob(3, inputStream);
        update.executeUpdate();
        inputStream.close();
        con.close();
    }

    private void retrieveListingsFromDBbyCollege(HttpServletRequest req, ArrayList<Listing> listings) throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT listingObj FROM Listings WHERE college = ?";
        String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
        String ps = "cse3026uni-dwell";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "admin", ps);
        PreparedStatement query = con.prepareStatement(sql);
        query.setString(1, req.getParameter("college"));
        ResultSet res = query.executeQuery();
        while (res.next()) {
            byte[] bytes = res.getBytes("listingObj");
            ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
            Listing retrivedListing = deserializeListing(byteIn);
            listings.add(retrivedListing);
        }
        con.close();
    }

    private void retrieveListingsFromDBbyHost(HttpServletRequest req, ArrayList<Listing> listings) throws IOException, SQLException, ClassNotFoundException {
        String sql = "SELECT listingObj FROM Listings WHERE host = ?";
        String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
        String ps = "cse3026uni-dwell";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "admin", ps);
        PreparedStatement query = con.prepareStatement(sql);
        query.setString(1, req.getParameter("host"));
        ResultSet res = query.executeQuery();
        while (res.next()) {
            byte[] bytes = res.getBytes("listingObj");
            ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
            Listing retrivedListing = deserializeListing(byteIn);
            listings.add(retrivedListing);
        }
        con.close();
    }

    private void updateListingInDB(ByteArrayInputStream oldInputStream, ByteArrayInputStream newInputStream) throws IOException, SQLException {
        String sql = "UPDATE Listings SET listingObj = ? WHERE listingObj = ?";
        String url = ("jdbc:mysql://uni-dwell-db.cpysmemiu2q3.us-east-2.rds.amazonaws.com:3306/uni-dwell");
        String ps = "cse3026uni-dwell";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, "admin", ps);
        PreparedStatement update = con.prepareStatement(sql);
        update.setBlob(1, newInputStream);
        update.setBlob(2, oldInputStream);
        update.executeUpdate();
        oldInputStream.close();
        newInputStream.close();
        con.close();
    }

    private ByteArrayInputStream serializeListing(Listing listing) throws IOException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(byteOut);
            outputStream.writeObject(listing);
            outputStream.flush();
            byte[] bytes = byteOut.toByteArray();
            ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
            return byteIn;
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e){
                //Handle exception
            }
        }
    }

    private Listing deserializeListing(ByteArrayInputStream byteIn) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(byteIn);
            Object o = inputStream.readObject();
            return (Listing) o;
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e){
                //Handle exception
            }
        }
    }

    private void printListings(ArrayList<Listing> listings, int start, int end) {
        System.out.println("#################");
        System.out.println("Printing listings:");
        System.out.println("#################");
        for (int i = start; i < end; i++) {
            System.out.println("###############################################");
            System.out.println("###############################################");
            System.out.println("Listing Name:   " + listings.get(i).getListingName());
            System.out.println("Property Name:  " + listings.get(i).getName());
            System.out.println("Is House:       " + listings.get(i).isHouse());
            System.out.println("Is Room:        " + listings.get(i).isRoom());
            System.out.println("Is Visible:     " + listings.get(i).isVisible());
            System.out.println("Rent:           " + listings.get(i).getRent());
            System.out.println("Deposit:        " + listings.get(i).getDeposit());
            System.out.println("Date Built:     " + listings.get(i).getDateBuilt());
            System.out.println("Date Available: " + listings.get(i).getDateAvailable());
            System.out.println("Address:        " + listings.get(i).getAddress());
            System.out.println("Property Type:  " + listings.get(i).getPropertyType());
            System.out.println("Cooling:        " + listings.get(i).getCooling());
            System.out.println("Heating:        " + listings.get(i).getHeating());
            System.out.println("Parking:        " + listings.get(i).getParking());
            System.out.println("Laundry:        " + listings.get(i).getLaundry());
            System.out.println("Pet Policy:     " + listings.get(i).getPetPolicy());
            System.out.println("Lot Size:       " + listings.get(i).getHouse().getLotSize());
            System.out.println("House Size:     " + listings.get(i).getHouse().getHouseSize());
            System.out.println("House Name:     " + listings.get(i).getHouse().getName());

            for (Room r : listings.get(i).getHouse().getRoomList("")){
                System.out.println(">>>Room<<<");
                System.out.println("Room Name:      " + r.getName());
                System.out.println("Room Size:      " + r.getRoomSize());
                System.out.println("Room Type:      " + r.getType());
            }

        }
    }


    private boolean checkTextValid(String text) {
        return text != null && text.length() <= maxChar && text.matches("[a-zA-Z0-9 ]+");
    }

    private boolean checkNumberValid(String number) {
        return number != null && number.length() <= maxChar && number.matches("[0-9]+");
    }

    private boolean checkDateValid(String date) {
        return date != null && date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

}
