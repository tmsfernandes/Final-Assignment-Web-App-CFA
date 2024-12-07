const baseURL = "http://localhost:8080/api/replicants";

document.getElementById("viewReplicants").addEventListener("click", () => {
    document.getElementById("replicantList").style.display = "block";
    document.getElementById("addReplicantForm").style.display = "none";
    fetchReplicants();
});

document.getElementById("addReplicant").addEventListener("click", () => {
    document.getElementById("replicantList").style.display = "none";
    document.getElementById("addReplicantForm").style.display = "block";
});

async function fetchReplicants() {
    try {
        const response = await fetch(baseURL);
        const replicants = await response.json();
        const tableBody = document.getElementById("replicantTableBody");
        tableBody.innerHTML = ""; // Clear previous rows

        replicants.forEach(replicant => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${replicant.id}</td>
                <td>${replicant.name}</td>
                <td>${replicant.model}</td>
                <td>${replicant.inceptionDate}</td>
                <td>${replicant.status}</td>
                <td>
                    <button onclick="deleteReplicant(${replicant.id})">Delete</button>
                </td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error("Error fetching replicants:", error);
    }
}

async function deleteReplicant(id) {
    try {
        const response = await fetch(`${baseURL}/${id}`, { method: "DELETE" });
        if (response.ok) {
            fetchReplicants(); // Refresh the list
        }
    } catch (error) {
        console.error("Error deleting replicant:", error);
    }
}

document.getElementById("replicantForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const name = document.getElementById("name").value;
    const model = document.getElementById("model").value;
    const inceptionDate = document.getElementById("inceptionDate").value;
    const status = document.getElementById("status").value;

    try {
        const response = await fetch(baseURL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name, model, inceptionDate, status })
        });
        if (response.ok) {
            document.getElementById("replicantForm").reset();
            alert("Replicant added successfully!");
        }
    } catch (error) {
        console.error("Error adding replicant:", error);
    }
});