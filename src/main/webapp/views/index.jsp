<%@ page import="static models.utils.SessionUtils.isAttributeValid" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/index.css">
    <link rel="stylesheet" href="styles/svg-bg.css">
    <script src="https://cdn.jsdelivr.net/npm/kute.js@2.2.4/dist/kute.min.js"></script>

    <title>Uni Dwell: Index</title>
</head>
<body>
<!-- header -->
<jsp:include page="components/header.jsp"/>

<!-- animated svg background -->
<div class="svg-container">
    <svg version="1.1" xmlns="http://www.w3.org/2000/svg"
         xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="100%" height="100%" viewBox="0 100 1600 900" preserveAspectRatio="xMidYMax slice">
        <defs>
            <linearGradient id="bg">
                <stop offset="0%" style="stop-color:rgba(130, 158, 249, 0.06)"></stop>
                <stop offset="50%" style="stop-color:rgba(76, 190, 255, 0.6)"></stop>
                <stop offset="100%" style="stop-color:rgba(115, 209, 72, 0.2)"></stop>
            </linearGradient>
            <path id="wave" fill="url(#bg)" d="M-363.852,502.589c0,0,236.988-41.997,505.475,0 s371.981,38.998,575.971,0s293.985-39.278,505.474,5.859s493.475,48.368,716.963-4.995v560.106H-363.852V502.589z"></path>
        </defs>
        <g>
            <use xlink:href='#wave' opacity=".3">
                <animateTransform
                        attributeName="transform"
                        attributeType="XML"
                        type="translate"
                        dur="10s"
                        calcMode="spline"
                        values="270 230; -334 180; 270 230"
                        keyTimes="0; .5; 1"
                        keySplines="0.42, 0, 0.58, 1.0;0.42, 0, 0.58, 1.0"
                        repeatCount="indefinite">
                </animateTransform>
            </use>
            <use xlink:href='#wave' opacity=".6">
                <animateTransform
                        attributeName="transform"
                        attributeType="XML"
                        type="translate"
                        dur="8s"
                        calcMode="spline"
                        values="-270 230;243 220;-270 230"
                        keyTimes="0; .6; 1"
                        keySplines="0.42, 0, 0.58, 1.0;0.42, 0, 0.58, 1.0"
                        repeatCount="indefinite">
                </animateTransform>
            </use>
            <use xlink:href='#wave' opacty=".9">
                <animateTransform
                        attributeName="transform"
                        attributeType="XML"
                        type="translate"
                        dur="6s"
                        calcMode="spline"
                        values="0 230;-140 200;0 230"
                        keyTimes="0; .4; 1"
                        keySplines="0.42, 0, 0.58, 1.0;0.42, 0, 0.58, 1.0"
                        repeatCount="indefinite">
                </animateTransform>
            </use>
        </g>
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
