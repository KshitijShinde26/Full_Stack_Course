let tasks = [];

function addTask() {
    const title = document.getElementById("taskTitle").value.trim();
    const dueDate = document.getElementById("dueDate").value;

    if (!title) return;

    tasks.push({
        id: Date.now(),
        title,
        dueDate,
        completed: false
    });

    renderTasks();

    document.getElementById("taskTitle").value = "";
    document.getElementById("dueDate").value = "";
}

function renderTasks() {
    const list = document.getElementById("taskList");
    list.innerHTML = "";

    tasks.forEach(task => {
        const item = document.createElement("div");
        item.className = "task-item";

        item.innerHTML = `
            <div class="task-left">
                <input type="checkbox" ${task.completed ? "checked" : ""} 
                    onchange="toggleTask(${task.id})">
                <span>${task.title}</span>
                ${task.dueDate ? `<span class="due-date">${task.dueDate}</span>` : ""}
            </div>
            <button class="delete-btn" onclick="deleteTask(${task.id})">✖</button>
        `;

        list.appendChild(item);
    });
}

function toggleTask(id) {
    tasks = tasks.map(t =>
        t.id === id ? { ...t, completed: !t.completed } : t
    );
    renderTasks();
}

function deleteTask(id) {
    tasks = tasks.filter(t => t.id !== id);
    renderTasks();
}