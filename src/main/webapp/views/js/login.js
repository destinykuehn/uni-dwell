// check if user is on mobile via
// screen size
let screenWidth = window.innerWidth;
if (screenWidth <= 600){
    let mobileDiv = document.getElementById('student-mobile-switch');
    mobileDiv.innerHTML = `<a onclick="switchDivs('student', 'up')">Sign Up</a>`;
    mobileDiv = document.getElementById('host-mobile-switch');
    mobileDiv.innerHTML = `<a onclick="switchDivs('host', 'up')">Sign Up</a>`;
}

// show sign in/sign up content
// as student or host
function switchUser(user){
    let hostContainer = document.getElementById('host-container');
    let studentContainer = document.getElementById('student-container');
    let studentButton = document.getElementById('student-button');
    let hostButton = document.getElementById('host-button');
    switch(user){
        case 'student':
            hostContainer.style.display = 'none';
            studentContainer.style.display = 'flex';
            studentButton.style.backgroundColor = 'var(--persian-blue)';
            studentButton.style.color = 'var(--light-persian)';
            hostButton.style.backgroundColor = 'var(--light-persian)';
            hostButton.style.color = 'var(--royal-blue-traditional)';
            break;
        case 'host':
            hostContainer.style.display = 'flex';
            studentContainer.style.display = 'none';
            studentButton.style.backgroundColor = 'var(--light-persian)';
            studentButton.style.color = 'var(--royal-blue-traditional)';
            hostButton.style.backgroundColor = 'var(--persian-blue)';
            hostButton.style.color = 'var(--light-persian)';
            break;
    }
}

// switch from sign in to sign up
// and vice-versa
function switchDivs(user, direction) {
    switch(user){
        case 'student':
            let studentContainer = document.getElementById('student-container');
            let studentChildren = studentContainer.children;
            // sign in -> sign up
            if (direction === 'to-left'){
                // move divs to opposite sides
                studentChildren[0].style.transform = 'translateX(100%)';
                studentChildren[1].style.transform = 'translateX(-100%)';

                // update border
                studentChildren[1].style.borderRadius = "0 50% 50% 0";

                afterSwitch('student', 'sign-up', studentChildren);
            }
            // sign up -> sign in
            else if (direction === 'to-right'){
                // return divs to original location
                studentChildren[1].style.transform = '';
                studentChildren[0].style.transform = '';

                // return to og border
                studentChildren[1].style.borderRadius = '';

                afterSwitch('student', 'sign-in', studentChildren);
            }
            // mobile sign in -> sign up
            else if (direction === 'up'){
                studentChildren[1].style.opacity = '1';
                studentChildren[1].style.transform = 'translateY(-15%)';
                studentChildren[0].style.opacity = '0';

                let mobileDiv = document.getElementById('student-mobile-switch');
                mobileDiv.innerHTML = `<a onclick="switchDivs('student', 'down')">Sign In</a>`;

                afterSwitch('student', 'sign-up', studentChildren, 'yes');
            }
            // mobile sign up -> sign in
            else {
                studentChildren[1].style.transform = 'translateY(100%)';
                studentChildren[1].style.opacity = '0';
                studentChildren[0].style.opacity = '1';

                let mobileDiv = document.getElementById('student-mobile-switch');
                mobileDiv.innerHTML = `<a onclick="switchDivs('student', 'up')">Sign Up</a>`;

                afterSwitch('student', 'sign-in', studentChildren, 'yes');
            }
            break;
        case 'host':
            let hostContainer = document.getElementById('host-container');
            let hostChildren = hostContainer.children;
            // sign in -> sign up
            if (direction === 'to-right'){
                // move divs to opposite sides
                hostChildren[0].style.transform = 'translateX(100%)';
                hostChildren[1].style.transform = 'translateX(-100%)';

                // update border
                hostChildren[0].style.borderRadius = "50% 0 0 50%";

                afterSwitch('host', 'sign-up', hostChildren);
            }
            // sign up -> sign in
            else if (direction === 'to-left') {
                // move divs to opposite sides
                hostChildren[0].style.transform = '';
                hostChildren[1].style.transform = '';

                // update border
                hostChildren[0].style.borderRadius = '';

                afterSwitch('host', 'sign-in', hostChildren);
            }
            // mobile sign in -> sign up
            else if (direction === 'up'){
                hostChildren[0].style.opacity = '1';
                hostChildren[0].style.transform = 'translateY(-15%)';
                hostChildren[1].style.opacity = '0';

                let mobileDiv = document.getElementById('host-mobile-switch');
                mobileDiv.innerHTML = `<a onclick="switchDivs('host', 'down')">Sign In</a>`;

                afterSwitch('host', 'sign-up', hostChildren, 'yes');
            }
            // mobile sign up -> sign in
            else {
                hostChildren[0].style.transform = 'translateY(100%)';
                hostChildren[0].style.opacity = '0';
                hostChildren[1].style.opacity = '1';

                let mobileDiv = document.getElementById('host-mobile-switch');
                mobileDiv.innerHTML = `<a onclick="switchDivs('host', 'up')">Sign Up</a>`;

                afterSwitch('host', 'sign-in', hostChildren, 'yes');
            }
            break;
    }
}

// update div content after
// switch animation
function afterSwitch(user, state, divs, mobile=''){
    switch(user){
        case 'student':
            let studentMessages = [
                `<h3>Hey there,<br>Techie!</br></h3>
                        <p style="margin: 0.75rem 0 1rem;">
                        We'd love to help you find the perfect abode.<br>Enter your credentials so we can get started!</p>
                        <input type="text" placeholder="900#" maxlength="10" required>
                        <input type="password" placeholder="Password" required>
                        <button class="submit-btn" style="margin-top: 5.25rem;">Sign Up</button>`,

                `<div>
                        <h3>Already a member?</h3>
                        <p>Sign in <a onclick="switchDivs('student', 'to-right')">here.</a></p>
                        </div>`,

                `<h3>Welcome back,<br>Miner!</br></h3>
                        <p>Please sign in with your banweb credentials.</p>
                        <input type="text" placeholder="900#" maxlength="10" required>
                        <input type="password" placeholder="Password" required>
                        <a href="#">Forgot your password?</a>
                        <button class="submit-btn">Sign Up</button>`,

                `<div>
                        <h3>First time here?</h3>
                        <p>Don't worry &mdash; sign up and find your oasis</p><a onclick="switchDivs('student', 'to-left')">now.</a>
                        </div>`
            ]
            // student sign up
            if (state === 'sign-up'){
                if (!mobile) {
                    // sign up
                    divs[0].innerHTML = studentMessages[0];
                    // sign in
                    divs[1].innerHTML = studentMessages[1];
                }
                else {
                    // sign up
                    divs[1].innerHTML = studentMessages[0];
                }
            }
            // student sign in
            else {
                if (!mobile) {
                    // sign up
                    divs[0].innerHTML = studentMessages[2];
                    // sign in
                    divs[1].innerHTML = studentMessages[3];
                }
                else {
                    // sign in
                    divs[0].innerHTML = studentMessages[2];
                }
            }
            break;
        case 'host':
            let hostMessages = [
                `<div>
                        <h3>Already with us?</br></h3>
                        <p>Sign in <a onclick="switchDivs('host', 'to-left')">here.</a></p>
                        </div>`,

                `<h3>Welcome<br>to the club!</br></h3>
                        <p>We'd love to have you with us.</p>
                        <div style="margin-top: 1rem;" class="sign-in-with">
                        <i class="fa-brands fa-google"></i>
                        <i class="fa-brands fa-meta"></i>
                        <i class="fa-brands fa-linkedin"></i>
                        </div>
                        <div class="or">
                        <div class="line"></div>
                        <p>Or</p>
                        </div>
                        <input type="email" placeholder="Email" maxlength="20" required>
                        <input type="password" placeholder="Password" maxlength="10" required>
                        <button style="margin-top: 2.5rem;" class="submit-btn">Sign Up</button>`,

                `<h3>Sign In</h3>
                        <div class="sign-in-with">
                        <i class="fa-brands fa-google"></i>
                        <i class="fa-brands fa-meta"></i>
                        <i class="fa-brands fa-linkedin"></i>
                        </div>
                        <div class="or">
                        <div class="line"></div>
                        <p>Or</p>
                        </div>
                        <input type="email" placeholder="Email" maxlength="20" required>
                        <input type="password" placeholder="Password" maxlength="10" required>
                        <a href="#">Forgot your password?</a>
                        <button class="submit-btn">Sign In</button>`,

                // `<div><h3>Not a host with<br>us yet?</br></h3>
                // <p>Gain visibility and attract the right tenants by signing up</p><a onclick="switchDivs('host', 'to-right')">here.</a>
                // </div>`

                // mobile
                `<h3>Welcome<br>to the club!</br></h3>
                        <p>We'd love to have you with us.</p>
                        <div style="margin: 1rem;" class="mobile-sign-in-with">
                        <i class="fa-brands fa-google"></i>
                        <i class="fa-brands fa-meta"></i>
                        <i class="fa-brands fa-linkedin"></i>
                        </div>
                        <div class="mobile-or">
                        <div class="line"></div>
                        <p>Or</p>
                        </div>
                        <input type="email" placeholder="Email" maxlength="20" required>
                        <input type="password" placeholder="Password" maxlength="10" required>
                        <button style="margin-top: 2.5rem;" class="submit-btn">Sign Up</button>`
            ]
            // host sign up
            if (state === 'sign-up'){
                console.log("if");
                if (!mobile) {
                    // sign in
                    divs[0].innerHTML = hostMessages[0];
                    // sign up
                    divs[1].innerHTML = hostMessages[1];
                }
                else {
                    // sign up
                    divs[0].innerHTML = hostMessages[3];
                }
            }
            // host sign in
            else {
                console.log("else");
                if (!mobile) {
                    console.log("not mobile");
                    // sign up
                    divs[1].innerHTML = hostMessages[2];
                    // sign in
                    divs[0].innerHTML = `<div><h3>Not a host with<br/>us yet?</br></h3>
                    <p>Gain visibility and attract the right tenants by signing up</p><a onClick="switchDivs('host', 'to-right')">here.</a>
                    </div>`;
                } else {
                    console.log("mobile");
                    // sign in
                    divs[0].innerHTML = hostMessages[4];
                }
            }
            break;
    }
}