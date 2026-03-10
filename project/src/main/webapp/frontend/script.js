function addTask() {

    var title = document.getElementById("taskInput").value.trim();
    var priority = document.getElementById("priority").value;

    if (title === "") {
        alert("Please enter a task");
        return;
    }

    fetch("../tasks", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "title=" + encodeURIComponent(title) + "&priority=" + priority
    })
    .then(function () {

        document.getElementById("taskInput").value = "";
        loadTasks();

    });

}



function loadTasks() {

    fetch("../tasks")
    .then(function (res) {
        return res.json();
    })
    .then(function (data) {

        var list = document.getElementById("taskList");
        list.innerHTML = "";

        data.forEach(function (task) {

            var card = document.createElement("div");
            card.className = "task-card";

            var checked = task.completed ? "checked" : "";
            var completedClass = task.completed ? "completed" : "";

            card.innerHTML =

                "<div class='task-left'>" +

                "<input type='checkbox' class='task-check' " + checked +
                " onchange='toggleTask(" + task.id + ")'>" +

                "<span class='task-title " + completedClass + "'>" +
                task.title +
                "</span>" +

                "<span class='priority " + task.priority + "'>" +
                task.priority +
                "</span>" +

                "</div>" +

                "<div class='task-actions'>" +

                "<button class='edit-btn' onclick=\"editTask(" + task.id + ", '" + task.title + "')\">" +
                "✏" +
                "</button>" +

                "<button class='delete-btn' onclick='deleteTask(" + task.id + ")'>" +
                "🗑" +
                "</button>" +

                "</div>";

            list.appendChild(card);

        });

    });

}



function deleteTask(id) {

    fetch("../tasks?id=" + id, {
        method: "DELETE"
    })
    .then(function () {
        loadTasks();
    });

}



function toggleTask(id) {

    fetch("../tasks?id=" + id, {
        method: "PUT"
    })
    .then(function () {
        loadTasks();
    });

}



function editTask(id, title) {

    var newTitle = prompt("Edit Task", title);

    if (newTitle === null || newTitle.trim() === "") {
        return;
    }

    fetch("../tasks", {

        method: "PATCH",

        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },

        body: "id=" + id + "&title=" + encodeURIComponent(newTitle)

    })
    .then(function () {
        loadTasks();
    });

}



window.onload = loadTasks;