setTheme();

/* set theme of site */
function setTheme(buttonPressed=false) {
    if (!buttonPressed){
        /* set to site theme to cookie theme preference */
        let name = "theme";
        let match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
        if (match) {
            let theme = decodeURIComponent(match[2]);
            theme === "light" ? setLightTheme() : setDarkTheme();
            checkLightToggle(theme);
            return;
        }
    }
    /* user pressed theme toggle */
    const lightb = document.getElementById("light");
    const darkb = document.getElementById("dark");
    if (lightb.style.display !== "none"){
        lightb.style.display = "none";
        darkb.style.display = "block";
        setDarkTheme()
    }
    else {
        lightb.style.display = "block";
        darkb.style.display = "none";
        setLightTheme()
    }
    setMap();
}

/*
    make sure theme toggle shows matching icon
    even if it wasn't pressed
*/
function checkLightToggle(theme) {
    const lightb = document.getElementById("light");
    const darkb = document.getElementById("dark");
    if (theme === "light") {
        lightb.style.display = "block";
        darkb.style.display = "none";
    }
    else {
        lightb.style.display = "none";
        darkb.style.display = "block";
    }
}

/* set theme to dark */
function setDarkTheme() {
    removeStyleSheet("styles/light-theme.css")
    addStyleSheet("styles/dark-theme.css")
    setThemeCookie('dark');
}

/* set theme to light */
function setLightTheme() {
    removeStyleSheet("styles/dark-theme.css")
    addStyleSheet("styles/light-theme.css")
    setThemeCookie('light');
}

/* set theme preference cookie */
function setThemeCookie(value) {
    const name = "theme";
    const expires = "";
    document.cookie = name + "=" + value + expires + "; path=/";
}

/* get theme cookie value */
function getThemeCookie() {
    const cookies = document.cookie.split(';');
    for (const cookie of cookies) {
        const [cookieName, cookieValue] = cookie.trim().split('=');
        if (cookieName === "theme") {
            return cookieValue;
        }
    }
    return null;
}

/* if on listings page, set map theme */
function setMap() {
    const pathname = document.location.pathname;
    const filename = pathname.split('/').pop();
    if (filename === "listings.jsp") {
        initMap();
    }
}

/* remove stylesheet from page */
function removeStyleSheet(href) {
    const links = document.querySelectorAll('link[rel="stylesheet"]'); // Select all <link> elements with rel="stylesheet"
    links.forEach(function(link) {
        if (link.getAttribute('href') === href) {
            link.parentNode.removeChild(link);
        }
    });
}

/* add stylesheet to page */
function addStyleSheet(href) {
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.type = 'text/css';
    link.href = href;
    document.head.appendChild(link);
}

function openAccountDiv() {
    const accountDiv = document.getElementsByClassName("account-header-div")[0];
    accountDiv.style.transform = "translate(0, 0)";
}

function closeAccountDiv() {
    const accountDiv = document.getElementsByClassName("account-header-div")[0];
    accountDiv.style.transform = "";
}

function hideOrShowHeader() {
    const upArrow = document.getElementById("header-up-arrow");
    const downArrow = document.getElementById("header-down-arrow");
    const header = document.getElementsByTagName("header")[0];
    const headerFirstRow = document.getElementsByClassName("header-first-row")[0];
    const children = headerFirstRow.children;

    /* collapse header */
    if (upArrow.style.display !== "none") {
        console.log("in if");
        // Loop through each child and set the font size
        for (let i = 0; i < children.length; i++) {
            children[i].style.display = 'none';
        }
        header.style.height = "5%";
        upArrow.style.display = "none";
        downArrow.style.display = "block";
    }
    /* show header */
    else {
        for (let i = 0; i < children.length; i++) {
            children[i].style.display = '';
        }
        header.style.height = "";
        upArrow.style.display = "";
        downArrow.style.display = "";
    }
}