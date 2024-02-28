<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/host-account.css">
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <title>Uni Dwell: Host Profile</title>
</head>
<body>

<div class="grid-container">

    <!-- profile nav -->
    <div class="left-col">

        <!-- logo -->
        <div class="logo">
            <img src="images/uni-dwell-tmp-logo.png">
            <h2>Uni Dwell</h2>
        </div>

        <!-- main nav buttons -->
        <div class="nav-buttons">
            <button onclick="openTab(this)" id="account-btn"><i class="fa-solid fa-user"></i>Account</button>
            <button onclick="openTab(this)" id="listings-btn"><i class="fa-solid fa-house"></i>Listings</button>
            <button onclick="openTab(this)" id="messages-btn"><i class="fa-solid fa-comment"></i>Messages</button>
        </div>

    </div>

    <!-- content -->
    <div class="right-col">

        <div id="messages">

        </div>

        <jsp:include page="components/host-account-div.jsp"/>
        <jsp:include page="components/host-listings-div.jsp"/>

    </div>
</div>

<script>

    openTab(document.getElementById("account-btn"));

    function openTab(button) {
        // reset nav buttons
        document.querySelectorAll('.nav-buttons button').forEach(button => {
            button.style.color = '';
            button.style.backgroundColor = '';
        });

        // set clicked button
        button.style.color = 'white';
        button.style.backgroundColor = '#004bb4';

        openContent(button.id);
    }

    function openContent(buttonId) {
        // hide/show profile content
        const contentList = ["account", "listings", "messages"];
        for (let i = 0; i < contentList.length; i++) {
            const ele = document.getElementById(contentList[i]);
            ele.style.transform = buttonId.includes(contentList[i]) ? '' : "translate(-50%, 100%)";
        }
    }

</script>

</body>
</html>
