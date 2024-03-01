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
}

function setDarkTheme() {
    removeStyleSheet("styles/light-theme.css")
    addStyleSheet("styles/dark-theme.css")
    setThemeCookie('dark');
}

function setLightTheme() {
    removeStyleSheet("styles/dark-theme.css")
    addStyleSheet("styles/light-theme.css")
    setThemeCookie('light');
}

function setThemeCookie(value) {
    const name = "theme";
    const expires = "";
    document.cookie = name + "=" + value + expires + "; path=/";
}

function removeStyleSheet(href) {
    const links = document.querySelectorAll('link[rel="stylesheet"]'); // Select all <link> elements with rel="stylesheet"
    links.forEach(function(link) {
        if (link.getAttribute('href') === href) {
            link.parentNode.removeChild(link);
        }
    });
}

function addStyleSheet(href) {
    const link = document.createElement('link');
    link.rel = 'stylesheet';
    link.type = 'text/css';
    link.href = href;
    document.head.appendChild(link);
}