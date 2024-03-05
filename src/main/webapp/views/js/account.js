openTab(document.getElementById("account-btn"));

function openTab(button) {
    // reset nav buttons
    document.querySelectorAll('.nav-buttons button').forEach(button => {
        button.style.color = '';
        button.style.backgroundColor = '';
    });

    // set clicked button
    button.style.color = 'white';
    button.style.backgroundColor = 'var(--dark-accent)';

    openContent(button.id);
}

function openContent(buttonId) {
    // hide/show profile content
    const contentList = ["account", "listings", "messages"];
    for (let i = 0; i < contentList.length; i++) {
        const ele = document.getElementById(contentList[i]);
        ele.style.transform = buttonId.includes(contentList[i]) ? '' : "translate(-50%, 100%)";
    }
}

function edit(action, ele='') {
    switch (action) {
        case 'listing':
            editListing(ele);
            break;
        case 'personal-info':
            editPersonalInfo();
            break;
        case 'profile-pic':
            editProfilePic();
            break;
        default:
            console.log('Unknown edit request.');
    }
}

function editListing(listing) {

}

function editPersonalInfo() {

}

function editProfilePic() {

}