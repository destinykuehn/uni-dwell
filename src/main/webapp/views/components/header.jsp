<header>
    <div class="header-first-row">
        <div class="header-logo">
            <p>Logo Image here</p>
            <p>Uni Dwell</p>
        </div>
        <nav>
            <a href="home.jsp">Home</a>
            <a href="#">Colleges</a>
            <a href="listings.jsp">Listings</a>
            <a href="#">About</a>
            <a href="#">Contact</a>
        </nav>
        <div class="theme-account">
            <!-- light/dark theme toggle -->
            <div id="theme-container"
                 onclick="setTheme(true)">
                <i class="fa-solid fa-lightbulb" id="light"></i>
                <i class="fa-solid fa-moon" id="dark"></i>
            </div>
            <i class="fa-solid fa-circle-user" onclick="openAccountDiv()"></i>
        </div>
    </div>
    <div class="header-second-row">
        <div class="header-drop" onclick="hideOrShowHeader()">
            <i id="header-up-arrow" class="fa-solid fa-caret-up"></i>
            <i id="header-down-arrow" class="fa-solid fa-caret-down"></i>
        </div>
    </div>
</header>
<div class="account-header-div">
    <div class="x-container">
        <i class="fa-solid fa-xmark" id="account-header-x" onclick="closeAccountDiv()"></i>
    </div>
    <div class="header-account-info">
        <a href="host-account.jsp"><i class="fa-solid fa-circle-user"></i></a>
        <h2>Your Name</h2>
        <button>Log Out</button>
    </div>
</div>