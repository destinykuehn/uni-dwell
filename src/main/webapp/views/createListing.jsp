<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/login.css">
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <title>Uni Dwell: Create Listing</title>
</head>
<body style="overflow: hidden">

<div id="main-container" class="container">
    <div class="form-container" style="position: relative; top: 200px">
        <div class="span-3">
            <form autocomplete="off" id="listing-form" action="ListingServlet" method="GET" style="top: auto; position: relative; padding-top: 250px">
                <input type="hidden" name="action" value="create">
                <input type="hidden" name="isHouse" value="true">
                <input type="hidden" name="isRoom" value="false">
                <input type="hidden" name="numRooms" id="numRooms" value="2">
                <input type="hidden" name="isVisible" value="true">
                <input type="hidden" name="propertyName" value="A Property Name">
                <input type="hidden" name="college" value="NMT">
                <div class="span-3 message">
                    <h2>Create Listing</h2>
                </div>
                <div>
                    <label>Listing Name</label>
                    <input type="text" name="listingName" id="listingName" required>
                </div>
                <div>
                    <label>Property Type</label>
                    <select name="propertyType" id="propertyType">
                        <option value="SINGLE_FAMILY_RESIDENCE">Single Family Residence</option>
                        <option value="MOBILE_HOME">Mobile Home</option>
                        <option value="APARTMENT">Apartment</option>
                        <option value="STUDIO">Studio</option>
                        <option value="PROPERTY_TYPE_OTHER">Other</option>
                    </select>
                </div>
                <!--Address-->
                <div>
                    <label>Address</label>
                    <input type="text" name="address" id="address" required>
                </div>
                <!--Rent-->
                <div>
                    <label>Rent</label>
                    <input type="number" name="rent" id="rent" required>
                </div>
                <!--Deposit-->
                <div>
                    <label>Deposit</label>
                    <input type="number" name="deposit" id="deposit" required>
                </div>
                <!--Date Built-->
                <div>
                    <label>Date Built</label>
                    <input type="date" name="dateBuilt" id="dateBuilt" required>
                </div>
                <!--Date Available-->
                <div>
                    <label>Date Available</label>
                    <input type="date" name="dateAvailable" id="dateAvailable" required>
                </div>
                <!--Cooling Type-->
                <div>
                    <label>Cooling Type</label>
                    <select name="coolingType" id="coolingType">
                        <option value="CENTRAL_AIR">Central Air</option>
                        <option value="EVAPORATIVE_COOLING">Evaporative Cooling</option>
                        <option value="CEILING_FANS">Ceiling Fans</option>
                        <option value="COOLING_OTHER">Other</option>
                        <option value="COOLING_NONE">None</option>
                    </select>
                </div>
                <!--Heating Type-->
                <div>
                    <label>Heating Type</label>
                    <select name="heatingType" id="heatingType">
                        <option value="FORCED_AIR">Forced Air</option>
                        <option value="NATURAL_GAS">Natural Gas</option>
                        <option value="BASEBOARD">Baseboard</option>
                        <option value="HEAT_PUMP">Heat pump</option>
                        <option value="FIREPLACE">Fireplace</option>
                        <option value="HEATING_OTHER">other</option>
                        <option value="HEATING_NONE">None</option>
                    </select>
                </div>
                <!--Parking Type-->
                <div>
                    <label>Parking Type</label>
                    <select name="parkingType" id="parkingType">
                        <option value="ATTACHED_GARAGE">Attached Garage</option>
                        <option value="DETACHED_GARAGE">Detached Garage</option>
                        <option value="DRIVEWAY">Driveway</option>
                        <option value="OFF_STREET">Off Street</option>
                    </select>
                </div>
                <!--Laundry Type-->
                <div>
                    <label>Laundry Type</label>
                    <select name="laundryType" id="laundryType">
                        <option value="IN_UNIT">In Unit</option>
                        <option value="COMMUNAL">Communal</option>
                        <option value="HOOKUPS">Hookups</option>
                        <option value="LAUNDRY_NONE">None</option>
                    </select>
                </div>
                <!--Pets Allowed-->
                <div>
                    <label>Pets Allowed</label>
                    <select name="petsAllowed" id="petsAllowed">
                        <option value="CATS">Cats</option>
                        <option value="DOGS">Dogs</option>
                        <option value="SMALL_DOGS">Small Pets</option>
                        <option value="PET_POLICY_NONE">None</option>
                        <option value="CONTACT_HOST">Contact Host</option>
                    </select>
                </div>

                <!--

                END of PROPERTY FORM Section

                -->

                <div class="span-3">
                    <h4>House Information</h4>
                </div>
                <input type="hidden" name="action" value="new-house">
                <div>
                    <label>House Name</label>
                    <input type="text" name="houseName" id="houseName">
                </div>
                <div>
                    <label>Lot Size</label>
                    <input type="number" name="lotSize" id="lotSize">
                </div>
                <div>
                    <label>House Size</label>
                    <input type="number" name="houseSize" id="HouseSize">
                </div>

                <!--Add new room section to page-->
                <div>
                    <button type="button" style="align-self: center">Add Room</button>
                </div>

                <!--

                END of HOUSE FORM Section

                -->

                <div class="span-3" id="appendHere"></div>


                <div class="span-3">
                    <input type="submit" value="Submit">
                </div>


            </form>

        </div>
    </div>

</div>
<script>
    //Add new room section to page when Add Room button is clicked with unique id
    let numRooms = 0;
    document.querySelector('button').addEventListener('click', function() {
        let form = document.getElementById('appendHere');
        let newRoom = document.createElement('div');
        newRoom.id = "room" + numRooms;
        let roomHTML = "<h4>Room Information</h4> <div> <label>Room Name</label> <input type='text' name='roomName" + numRooms+ "' id='roomName" + numRooms+ "' required> </div> <div> <label>Room Type</label> <select name='roomType" + numRooms+ "' id='roomType" + numRooms+ "' required> <option value='BEDROOM'>Bedroom</option> <option value='BATHROOM'>Bathroom</option> <option value='HALF_BATHROOM'>Half Bathroom</option> <option value='LIVING_ROOM'>Living Room</option> <option value='KITCHEN'>Kitchen</option> <option value='OUTDOORS'>Outdoors</option> <option value='ROOM_TYPE_OTHER'>Other</option></select> </div> <div> <label>Room size</label> <input type='number' name='roomSize" + numRooms+ "' id='roomSize" + numRooms+ "' required> </div>";
        newRoom.innerHTML = roomHTML;

        form.insertAdjacentElement("afterend", newRoom);
        /* Layout of room form
        `
            	<h4>Room Information</h4>
            <div>
                <label>Room Name</label>
                <input type="text" name="roomName" id="roomName" required>
            </div>
            <div>
                <label>Room Type</label>
                <select name="roomType" id="roomType" required>
                    <option value="bedroom">Bedroom</option>
                    <option value="bathroom">Bathroom</option>
                    <option value="halfBathroom">Half Bathroom</option>
                    <option value="livingRoom">Living Room</option>
                    <option value="kitchen">Kitchen</option>
                    <option value="outdoors">Outdoors</option>
                    <option value="roomOther">Other</option>
                </select>
            </div>
            <div>
                <label>Room size</label>
                <input type="number" name="roomSize" id="roomSize" required>
            </div>
        `
        */
        numRooms++;
        document.getElementById('numRooms').value = numRooms;
        console.log(numRooms);
    });



</script>

</body>
</html>
