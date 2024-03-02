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