const schoolList = ["New Mexico Institute of Mining and Technology",
    "University of New Mexico",
    "New Mexico State University",
    "Eastern New Mexico University",
    "Massachusetts Institute of Technology"]

function filterSchools() {
    /* get input */
    const input = document.getElementById("school-input").value.toLowerCase();
    /* find schools that match input */
    const filteredSchools = schoolList.filter(school => school.toLowerCase().includes(input));

    /* clear options div */
    const schoolOptionsContainer = document.getElementById("school-options");
    schoolOptionsContainer.innerHTML = '';

    /* add new option buttons */
    filteredSchools.forEach(school => {
        const button = document.createElement('button');
        button.textContent = school;
        button.onclick = function() {
            setSchool(this);
        };
        schoolOptionsContainer.appendChild(button);
    });
}

function setSchool(button) {
    /* set button text as input text */
    document.getElementById("school-input").value = button.innerText;
    /* clear options div */
    const schoolOptionsContainer = document.getElementById("school-options");
    schoolOptionsContainer.innerHTML = '';
    /* prevent form submission */
    event.preventDefault();
}