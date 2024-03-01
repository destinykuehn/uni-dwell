setTheme();
function setTheme(buttonPressed=false) {
    if (!buttonPressed){
        /* set to cookie theme preference */
        let name = "theme";
        let match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
        if (match) {
            let theme = decodeURIComponent(match[2]);
            theme === "light" ? setLightTheme() : setDarkTheme();
            return;
        }
    }
    /* toggle light/dark theme button */
    const lightb = document.getElementById("light");
    const darkb = document.getElementById("dark");
    if (lightb.style.display !== "none"){
        lightb.style.display = "none";
        darkb.style.display = "block";
        setDarkTheme()
        setMap("dark")
    }
    else {
        lightb.style.display = "block";
        darkb.style.display = "none";
        setLightTheme()
        setMap("light")
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

function setMap(theme) {
    const pathname = document.location.pathname;
    const filename = pathname.split('/').pop();
    if (filename === "listings.jsp") {
        initMap("theme");
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