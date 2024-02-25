<%@ page import="static models.utils.SessionUtils.isAttributeValid" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/index.css">
    <link rel="stylesheet" href="styles/svg-bg.css">
<%--    <script src="https://cdn.jsdelivr.net/npm/kute.js@2.2.4/dist/kute.min.js"></script>--%>

    <title>Uni Dwell: Index</title>
</head>
<body>
<!-- header -->
<jsp:include page="components/header.jsp"/>

<!-- animated svg background -->
<div class="svg-container">
    <svg viewBox="0 0 900 450" width="900" height="450" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1">
        <!-- svg wave 1 -->
        <path id="w1p1" d="M0 335L21.5 332.5C43 330 86 325 128.8 322.2C171.7 319.3 214.3 318.7 257.2 324C300 329.3 343 340.7 385.8 347.2C428.7 353.7 471.3 355.3 514.2 346.7C557 338 600 319 642.8 316.5C685.7 314 728.3 328 771.2 329C814 330 857 318 878.5 312L900 306L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#fa7268"></path>
        <path id="w1p2" d="M0 329L21.5 336.5C43 344 86 359 128.8 359.8C171.7 360.7 214.3 347.3 257.2 340.7C300 334 343 334 385.8 339.7C428.7 345.3 471.3 356.7 514.2 360.7C557 364.7 600 361.3 642.8 355.2C685.7 349 728.3 340 771.2 341.5C814 343 857 355 878.5 361L900 367L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#ef5f67"></path>
        <path id="w1p3" d="M0 383L21.5 382.3C43 381.7 86 380.3 128.8 378.3C171.7 376.3 214.3 373.7 257.2 374.7C300 375.7 343 380.3 385.8 379.2C428.7 378 471.3 371 514.2 366C557 361 600 358 642.8 363.3C685.7 368.7 728.3 382.3 771.2 385.2C814 388 857 380 878.5 376L900 372L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#e34c67"></path>
        <path id="w1p4" d="M0 383L21.5 383.7C43 384.3 86 385.7 128.8 387.8C171.7 390 214.3 393 257.2 397.3C300 401.7 343 407.3 385.8 407.5C428.7 407.7 471.3 402.3 514.2 399.2C557 396 600 395 642.8 394.5C685.7 394 728.3 394 771.2 395C814 396 857 398 878.5 399L900 400L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#d53867"></path>
        <path id="w1p5" d="M0 417L21.5 419.7C43 422.3 86 427.7 128.8 426.8C171.7 426 214.3 419 257.2 417.5C300 416 343 420 385.8 419.8C428.7 419.7 471.3 415.3 514.2 412.2C557 409 600 407 642.8 409.5C685.7 412 728.3 419 771.2 419.8C814 420.7 857 415.3 878.5 412.7L900 410L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#c62368"></path>

        <!-- svg wave 2 -->
        <path id="w2p1" style="visibility:hidden" d="M0 285L21.5 296.7C43 308.3 86 331.7 128.8 334.7C171.7 337.7 214.3 320.3 257.2 318.7C300 317 343 331 385.8 322.7C428.7 314.3 471.3 283.7 514.2 266.3C557 249 600 245 642.8 255.8C685.7 266.7 728.3 292.3 771.2 301.7C814 311 857 304 878.5 300.5L900 297L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#fa7268"></path>
        <path id="w2p2" style="visibility:hidden" d="M0 356L21.5 347.5C43 339 86 322 128.8 309.2C171.7 296.3 214.3 287.7 257.2 297.7C300 307.7 343 336.3 385.8 350.8C428.7 365.3 471.3 365.7 514.2 352.7C557 339.7 600 313.3 642.8 298.8C685.7 284.3 728.3 281.7 771.2 291.2C814 300.7 857 322.3 878.5 333.2L900 344L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#ef5f67"></path>
        <path id="w2p3" style="visibility:hidden" d="M0 337L21.5 339C43 341 86 345 128.8 353C171.7 361 214.3 373 257.2 379C300 385 343 385 385.8 378.8C428.7 372.7 471.3 360.3 514.2 350.3C557 340.3 600 332.7 642.8 329.5C685.7 326.3 728.3 327.7 771.2 326.7C814 325.7 857 322.3 878.5 320.7L900 319L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#e34c67"></path>
        <path id="w2p4" style="visibility:hidden" d="M0 389L21.5 392.3C43 395.7 86 402.3 128.8 400.2C171.7 398 214.3 387 257.2 381.8C300 376.7 343 377.3 385.8 375.2C428.7 373 471.3 368 514.2 374C557 380 600 397 642.8 396C685.7 395 728.3 376 771.2 374C814 372 857 387 878.5 394.5L900 402L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#d53867"></path>
        <path id="w2p5" style="visibility:hidden" d="M0 409L21.5 411.3C43 413.7 86 418.3 128.8 419.3C171.7 420.3 214.3 417.7 257.2 417.3C300 417 343 419 385.8 413.5C428.7 408 471.3 395 514.2 391.7C557 388.3 600 394.7 642.8 403.5C685.7 412.3 728.3 423.7 771.2 429.7C814 435.7 857 436.3 878.5 436.7L900 437L900 451L878.5 451C857 451 814 451 771.2 451C728.3 451 685.7 451 642.8 451C600 451 557 451 514.2 451C471.3 451 428.7 451 385.8 451C343 451 300 451 257.2 451C214.3 451 171.7 451 128.8 451C86 451 43 451 21.5 451L0 451Z" fill="#c62368"></path>
<%--    <script>--%>
<%--        let tween1 = KUTE.to(--%>
<%--            '#w1p1',--%>
<%--            { path: '#w2p1' },--%>
<%--            {repeat: Infinity, duration: 20000, yoyo: true}--%>
<%--        ).start();--%>
<%--        let tween2 = KUTE.to(--%>
<%--            '#w1p2',--%>
<%--            { path: '#w2p2' },--%>
<%--            {repeat: Infinity, duration: 20000, yoyo: true}--%>
<%--        ).start();--%>
<%--        let tween3 = KUTE.to(--%>
<%--            '#w1p3',--%>
<%--            { path: '#w2p3' },--%>
<%--            {repeat: Infinity, duration: 20000, yoyo: true}--%>
<%--        ).start();--%>
<%--        let tween4 = KUTE.to(--%>
<%--            '#w1p4',--%>
<%--            { path: '#w2p4' },--%>
<%--            {repeat: Infinity, duration: 20000, yoyo: true}--%>
<%--        ).start();--%>
<%--        let tween5 = KUTE.to(--%>
<%--            '#w1p5',--%>
<%--            { path: '#w2p5' },--%>
<%--            {repeat: Infinity, duration: 20000, yoyo: true}--%>
<%--        ).start();--%>
<%--    </script>--%>

    </svg>

</div>


<!-- form -->
<h2>Uni Dwell: Index</h2>
<form autocomplete="off" action="IndexServlet" method="POST">
    <div>
        <input type="text" name="college" placeholder="Enter College Name...">
    </div>
    <input type="submit" value="Submit">
</form>
<%--<% if (!isAttributeValid(session, "college")) { %>--%>
<%--    <p>This school is invalid. Please try again.</p>--%>
<%--<% } %>--%>
</body>
</html>
