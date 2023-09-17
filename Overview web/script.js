document.addEventListener("DOMContentLoaded", function () {
    const teamMembers = [
        { name: "Member 1", role: "Developer" },
        { name: "Member 2", role: "Designer" },
        { name: "Member 3", role: "Tester" },
        // Add more team members as needed
    ];

    const teamList = document.getElementById("team-list");

    teamMembers.forEach((member) => {
        const listItem = document.createElement("li");
        listItem.textContent = `${member.name} - ${member.role}`;
        teamList.appendChild(listItem);
    });
});
