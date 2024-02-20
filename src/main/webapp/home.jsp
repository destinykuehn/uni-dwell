<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- styles -->
    <link rel="stylesheet" href="stylesheets/global.css">
    <link rel="stylesheet" href="stylesheets/home.css">
    <!-- icons -->
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <!-- kute.js -->
    <script src="https://cdn.jsdelivr.net/npm/kute.js@2.2.4/dist/kute.min.js"></script>
    <title>MinerDwellings: Home</title>
</head>
<body>
    <div class="bg-pic-container">
<%--        <img alt="home-page" src="images/temp-home-pic.jpeg" class="bg-pic">--%>
        <svg id="bg"
             class="bg-pic"
             viewBox="0 125 960 540"
             width="100%"
             height="100%"
             xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
            <path id="m1p1" d="M0 403L107 399L213 121L320 370L427 336L533 246L640 422L747 279L853 415L960 404L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#9fff36"></path>
            <path id="m1p2" d="M0 365L107 283L213 173L320 262L427 325L533 385L640 220L747 402L853 402L960 236L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#16f782"></path>
            <path id="m1p3" d="M0 328L107 366L213 205L320 335L427 409L533 229L640 362L747 439L853 186L960 232L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00e9b9"></path>
            <path id="m1p4" d="M0 339L107 317L213 272L320 408L427 294L533 444L640 294L747 287L853 328L960 418L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00d7dc"></path>
            <path id="m1p5" d="M0 376L107 391L213 276L320 444L427 450L533 424L640 439L747 368L853 289L960 416L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00c2e6"></path>
            <path id="m1p6" d="M0 461L107 323L213 417L320 425L427 446L533 415L640 412L747 371L853 476L960 320L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00abe0"></path>
            <path id="m1p7" d="M0 424L107 436L213 349L320 390L427 357L533 379L640 376L747 433L853 438L960 404L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#0093dc"></path>
            <path id="m1p8" d="M0 493L107 396L213 471L320 465L427 412L533 405L640 384L747 402L853 495L960 416L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#007ad4"></path>
            <path id="m1p9" d="M0 439L107 501L213 484L320 494L427 493L533 497L640 450L747 504L853 505L960 451L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#005fc7"></path>
            <path id="m1p10" d="M0 462L107 519L213 506L320 503L427 498L533 482L640 507L747 463L853 489L960 483L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#2541b2"></path>
            <path id="m2p1" style="visibility:hidden" d="M0 391L107 260L213 230L320 385L427 358L533 252L640 324L747 417L853 353L960 367L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#9fff36"></path>
            <path id="m2p2" style="visibility:hidden" d="M0 264L107 425L213 398L320 289L427 226L533 249L640 361L747 319L853 310L960 273L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#16f782"></path>
            <path id="m2p3" style="visibility:hidden" d="M0 404L107 353L213 409L320 399L427 257L533 278L640 346L747 340L853 456L960 279L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00e9b9"></path>
            <path id="m2p4" style="visibility:hidden" d="M0 463L107 386L213 462L320 313L427 427L533 396L640 412L747 439L853 367L960 363L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00d7dc"></path>
            <path id="m2p5" style="visibility:hidden" d="M0 463L107 332L213 324L320 420L427 389L533 456L640 433L747 379L853 461L960 349L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00c2e6"></path>
            <path id="m2p6" style="visibility:hidden" d="M0 400L107 476L213 355L320 427L427 364L533 459L640 370L747 429L853 463L960 425L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#00abe0"></path>
            <path id="m2p7" style="visibility:hidden" d="M0 420L107 432L213 417L320 426L427 493L533 489L640 404L747 464L853 414L960 392L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#0093dc"></path>
            <path id="m2p8" style="visibility:hidden" d="M0 502L107 503L213 437L320 422L427 502L533 486L640 441L747 473L853 470L960 459L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#007ad4"></path>
            <path id="m2p9" style="visibility:hidden" d="M0 472L107 463L213 465L320 449L427 464L533 509L640 515L747 495L853 494L960 475L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#005fc7"></path>
            <path id="m2p10" style="visibility:hidden" d="M0 498L107 492L213 523L320 502L427 485L533 488L640 519L747 510L853 484L960 519L960 541L853 541L747 541L640 541L533 541L427 541L320 541L213 541L107 541L0 541Z" fill="#2541b2"></path>
        </svg>
        <script>
            let tween1 = KUTE.fromTo(
                '#m1p1', {path: '#m1p1'}, {path: '#m2p1'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween2 = KUTE.fromTo(
                '#m1p2', {path: '#m1p2'}, {path: '#m2p2'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween3 = KUTE.fromTo(
                '#m1p3', {path: '#m1p3'}, {path: '#m2p3'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween4 = KUTE.fromTo(
                '#m1p4', {path: '#m1p4'}, {path: '#m2p4'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween5 = KUTE.fromTo(
                '#m1p5', {path: '#m1p5'}, {path: '#m2p5'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween6 = KUTE.fromTo(
                '#m1p6', {path: '#m1p6'}, {path: '#m2p6'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween7 = KUTE.fromTo(
                '#m1p7', {path: '#m1p7'}, {path: '#m2p7'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween8 = KUTE.fromTo(
                '#m1p8', {path: '#m1p8'}, {path: '#m2p8'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween9 = KUTE.fromTo(
                '#m1p9', {path: '#m1p9'}, {path: '#m2p9'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
            let tween10 = KUTE.fromTo(
                '#m1p10', {path: '#m1p10'}, {path: '#m2p10'},
                {repeat: 999, duration: 18000, yoyo: true}
            ).start();
        </script>
    </div>
<%--    <header class="mobile-header">--%>
<%--        <img src="images/temp-logo.png" alt="logo" onclick="window.location.href = 'home.jsp'">--%>
<%--    </header>--%>
    <header>
<%--        <h1>LOGO</h1>--%>
        <img src="images/temp-logo.png" alt="logo" onclick="window.location.href = 'home.jsp'">
        <div class="nav-links">
            <nav>
                <a>Home</a>
                <a>Listings</a>
                <a>Service</a>
                <a>About</a>
                <a>Contact</a>
            </nav>
        </div>
        <div id="account-icon-container" onclick="setAccountDiv('open')">
            <i class="fa-solid fa-user"></i>
<%--            <p>Log In</p>--%>
            <p>Your Account</p>
        </div>
    </header>
    <div id="account">
        <div class="account-layout">
            <i class="fa-solid fa-xmark" onclick="setAccountDiv('hide')"></i>
            <img alt="profile-pic" src="images/temp-profile-pic.jpeg">
            <h1>Kit Cat</h1>
            <a>View Your Account</a>
        </div>
    </div>

    <div class="listing-selection">
        <nav>
            <div>
                <i class="fa-solid fa-house"></i>
                <p>All</p>
            </div>
            <div>
                <i class="fa-solid fa-wand-magic-sparkles"></i>
                <p>New</p>
            </div>
            <div>
                <i class="fa-solid fa-dog"></i>
                <p>Pet Friendly</p>
            </div>
            <div>
                <i class="fa-solid fa-star"></i>
                <p>Highly Rated</p>
            </div>
            <div>
                <i class="fa-solid fa-person-hiking"></i>
                <p>Adventurous</p>
            </div>
            <div>
                <i class="fa-solid fa-door-open"></i>
                <p>Open</p>
            </div>
        </nav>
    </div>

    <!-- mobile compatibility -->
    <div class="mobile-bottom-menu">
        <div>
            <i class="fa-solid fa-house"></i>
            <p>Home</p>
        </div>
        <div>
            <i class="fa-solid fa-list"></i>
            <p>Listings</p>
        </div>
        <div>
            <i class="fa-solid fa-user"></i>
            <p>Account</p>
        </div>
    </div>


    <script>
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "ExampleServlet", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                let response = xhr.responseText;
                console.log(response); // Handle the response as needed
            }
        };
        xhr.send();


        function setAccountDiv(action) {
            let div = document.getElementById('account');
            if (action === 'open'){
                // div.style.display = "block";
                div.style.transform = 'translateX(-105%)';
                document.getElementById(
                    'account-icon-container').style.opacity = "0";
                return;
            }
            // div.style.display = "";
            div.style.transform = 'translateX(102%)';
            document.getElementById(
                'account-icon-container').style.opacity = "1";
        }
    </script>

</body>
</html>
