<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- styles -->
    <link rel="stylesheet" href="../stylesheets/global.css">
    <link rel="stylesheet" href="../stylesheets/messages.css">
    <!-- icons -->
    <script src="https://kit.fontawesome.com/2db75599be.js" crossorigin="anonymous"></script>
    <title>MinerDwellings: Messages</title>
</head>
<body>

    <div class="chat-box">
        <div class="chat-header">
            <div class="header-left">
                <i class="fa-solid fa-arrow-left"></i>
                <p>picture</p>
                <p>Name</p>
            </div>
            <div class="header-right">
                <i class="fa-solid fa-phone"></i>
            </div>
        </div>

        <div id="message-container">
            <div class="message">Test Message</div>
        </div>

        <div class="text-input">
            <div class="attachment">attach</div>
            <input id="text" type="text" placeholder="Write a message...">
            <i class="fa-regular fa-face-smile"></i>
            <i class="fa-solid fa-arrow-up" onclick="sendMessage()"></i>


        </div>

    </div>


    <script>
        function sendMessage(){
            let text = document.getElementById('text').value;
            clearInput();
            let xhr = new XMLHttpRequest();
            let url = "/MinerDwellings/ChatServlet?messageContent=" + encodeURIComponent(text);
            xhr.open("GET", url, true);
            // xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    // rewrite gallery div
                    document.getElementById('message-container').innerHTML =
                        document.getElementById('message-container').innerHTML + xhr.responseText;
                    console.log("success");
                }
            };
            console.log(text);
            let data = ("messageContent=" + text);
            xhr.send(data);
        }

        function clearInput() {
            document.getElementById('text').value = "";
        }
    </script>
</body>
</html>
