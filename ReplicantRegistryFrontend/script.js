const baseURL = "http://localhost:8080/api/replicants";

// Show the replicant list
document.getElementById("viewReplicants").addEventListener("click", () => {
    document.getElementById("replicantList").style.display = "block";
    document.getElementById("addReplicantForm").style.display = "none";
    fetchReplicants();
});

// Show the add replicant form
document.getElementById("addReplicant").addEventListener("click", () => {
    document.getElementById("replicantList").style.display = "none";
    document.getElementById("addReplicantForm").style.display = "block";
});

// Fetches all replicants from the backend and populates the table
async function fetchReplicants() {
    try {
        const response = await fetch(baseURL);
        const replicants = await response.json();
        const tableBody = document.getElementById("replicantTableBody");
        tableBody.innerHTML = ""; // Clear any existing rows

        // Populate the table with replicants
        replicants.forEach(replicant => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${replicant.id}</td>
                <td>${replicant.name}</td>
                <td>${replicant.model}</td>
                <td>${replicant.inceptionDate}</td>
                <td>${replicant.status}</td>
                <td>
                    <button onclick="viewProfile(${replicant.id})">Profile</button>
                    <button class="delete" onclick="deleteProfile(${replicant.id})">Delete</button>
                    <button class="chat" onclick="openChat(${replicant.id})">Chat</button>
                </td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error("Error fetching replicants:", error);
    }
}

// Deletes a replicant and refreshes the list
async function deleteProfile(id) {
    if (confirm("Are you sure you want to delete this replicant?")) {
        try {
            const response = await fetch(`${baseURL}/${id}`, { method: "DELETE" });
            if (!response.ok) throw new Error(`Failed to delete replicant with ID ${id}`);
            alert("Replicant deleted successfully!");
            fetchReplicants();
        } catch (error) {
            console.error("Error deleting replicant:", error);
            alert("Failed to delete replicant. Please try again.");
        }
    }
}

// Displays the replicant's profile in a modal
async function viewProfile(id) {
    try {
        const response = await fetch(`${baseURL}/${id}`);
        if (!response.ok) throw new Error(`Failed to fetch profile for ID ${id}`);
        const replicant = await response.json();
        const profileContent = document.getElementById("profileContent");
        profileContent.innerHTML = `
            <img src="${replicant.imageUrl}" alt="${replicant.name}" style="width: 150px; border-radius: 10px;">
            <p><strong>ID:</strong> ${replicant.id}</p>
            <p><strong>Name:</strong> ${replicant.name}</p>
            <p><strong>Model:</strong> ${replicant.model}</p>
            <p><strong>Inception Date:</strong> ${replicant.inceptionDate}</p>
            <p><strong>Status:</strong> ${replicant.status}</p>
            <h3>Bio</h3>
            <p><strong>Physical Characteristics:</strong> ${replicant.physicalCharacteristics}</p>
            <p><strong>Aliases:</strong> ${replicant.aliases}</p>
            <p><strong>Affiliations:</strong> ${replicant.affiliations}</p>
            <p><strong>Crimes:</strong> ${replicant.crimes}</p>
            <p><strong>Behavior Notes:</strong> ${replicant.behaviorNotes}</p>
            <p><strong>Termination Priority:</strong> ${replicant.terminationPriority}</p>
        `;
        openModal();
    } catch (error) {
        console.error("Error fetching replicant profile:", error);
    }
}

// Open and close modal
function openModal() {
    document.getElementById("profileModal").style.display = "block";
}

function closeModal() {
    document.getElementById("profileModal").style.display = "none";
}
