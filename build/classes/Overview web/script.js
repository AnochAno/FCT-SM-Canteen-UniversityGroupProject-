document.addEventListener("DOMContentLoaded", function () {
    const teamMembers = [
        { name: "Subanchan.K", role: "Developer" },
        { name: "Sabeshan.A", role: "Designer" },
        { name: "Sasikaran.S", role: "Tester" },
        { name: "Sivavishnu.S", role: "Specalist" },
        { name: "Thibakaran.T", role: "Tester" },
        { name: "Keerththikan.A", role: "Tester" },
        { name: "PriyaLakshan.K", role: "Tester" },
        { name: "Anojan.T", role: "Tester" }
        
    ];

    const teamList = document.getElementById("team-list");

    teamMembers.forEach((member) => {
        const listItem = document.createElement("li");
        listItem.textContent = `${member.name} - ${member.role}`;
        teamList.appendChild(listItem);
    });
});
