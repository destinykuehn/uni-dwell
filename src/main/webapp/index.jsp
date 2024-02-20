<html>
<body>
<h2>Hello World!</h2>
</body>
<script>
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "ExampleServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let response = xhr.responseText;
            // Use the HTML content as needed
            console.log(response);
        }
    };
    xhr.send();
</script>
</html>
