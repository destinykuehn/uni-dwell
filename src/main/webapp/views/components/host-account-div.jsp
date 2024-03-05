<div id="account" class="content">
    <h2>My Account</h2>
    <div class="profile-pic">
        <div>
            <img src="images/temp-profile-pic.jpeg">
            <h3>Kit Kat</h3>
        </div>
        <button class="edit" onclick="edit('profile-pic')">
            <i class="fa-solid fa-pen-to-square"></i>Edit
        </button>
    </div>
    <div class="personal-info-grid">
        <div>
            <label>First Name</label>
            <input readonly type="text" id="firstName">
        </div>
        <div>
            <label>Last Name</label>
            <input readonly type="text" id="lastName">
        </div>
        <div></div>
        <div>
            <label>Email</label>
            <input readonly type="email" id="emailName">
        </div>
        <div>
            <label>Password</label>
            <input readonly type="password" id="password">
        </div>
        <div></div>
        <div>
            <label>Phone</label>
            <input readonly type="tel" id="tel-number">
        </div>
        <div></div>
        <button class="edit" onclick="edit('personal-info')">
            <i class="fa-solid fa-pen-to-square"></i>Edit
        </button>
    </div>
    <div>
        <button class="delete">Delete Account</button>
    </div>
</div>
