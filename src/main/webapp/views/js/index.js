function fetch(form, method, servlet) {
    const data = formToString(form);
    console.log(data);
    handleRequest(
        method,
        servlet + data);
    // document.getElementById(target).innerHTML = (response === 0) ? "Fail" : "Success";
    return false;
}

function forward(form, method, servlet, target) {
    const data = formToString(form);
    console.log(data);
    handleRequest(
        method,
        servlet + '?' + data);
    // document.getElementById(target).innerHTML = (response === 0) ? "Fail" : "Success";
}

function formToString(form) {
    let dataString = '?';
    for (const element of form.elements) {
        if (element.name) {
            dataString += `${element.name}=${element.value}&`;
        }
    }
    return dataString;
}

function handleRequest(method, servlet) {
    let response;
    let xhr= new XMLHttpRequest();
    xhr.open(method, servlet, false);
    xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                console.log("Response from servlet:", xhr.responseText);
            } else {
                console.error("Request failed:", xhr.status);
            }
        }
    };
    xhr.send();
}

function handleResponse(response, action, target) {
    return {
        'updateHTML': 'Sunday',
        'redirect': 'Monday',
    }[action] || 'Invalid day';
}