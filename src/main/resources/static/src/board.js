document.addEventListener("DOMContentLoaded", () => {
    const boardContent = document.getElementById("boardContent");
    const searchBtn = document.getElementById("searchBtn");
    const searchInput = document.getElementById("search");
    const writeBtn = document.getElementById("writeBtn");
    const postModal = document.getElementById("postModal");
    const closeModal = document.querySelector(".close");
    const postForm = document.getElementById("postForm");

    let notices = [
        { id: 1, title: "공지사항 1", author: "관리자", date: "2024-05-01" },
        { id: 2, title: "공지사항 2", author: "관리자", date: "2024-05-02" },
        { id: 3, title: "공지사항 3", author: "관리자", date: "2024-05-03" }
    ];

    function displayNotices(data) {
        boardContent.innerHTML = "";
        data.forEach(notice => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${notice.id}</td>
                <td>${notice.title}</td>
                <td>${notice.author}</td>
                <td>${notice.date}</td>
                <td><button class="deleteBtn" data-id="${notice.id}">삭제</button></td>
            `;
            boardContent.appendChild(row);
        });

        // Add delete functionality
        document.querySelectorAll(".deleteBtn").forEach(button => {
            button.addEventListener("click", (e) => {
                const id = parseInt(e.target.dataset.id);
                notices = notices.filter(notice => notice.id !== id);
                displayNotices(notices);
            });
        });
    }

    function searchNotices() {
        const query = searchInput.value.toLowerCase();
        const filteredNotices = notices.filter(notice => 
            notice.title.toLowerCase().includes(query) || 
            notice.author.toLowerCase().includes(query)
        );
        displayNotices(filteredNotices);
    }

    function addNotice(title, author, content) {
        const date = new Date().toISOString().split('T')[0];
        const id = notices.length ? notices[notices.length - 1].id + 1 : 1;
        const newNotice = { id, title, author, date };
        notices.push(newNotice);
        displayNotices(notices);
    }

    // Initial display
    displayNotices(notices);

    // Search button event
    searchBtn.addEventListener("click", searchNotices);

    // Search input enter key event
    searchInput.addEventListener("keyup", (e) => {
        if (e.key === "Enter") {
            searchNotices();
        }
    });

    // Write button event
    writeBtn.addEventListener("click", () => {
        postModal.style.display = "block";
    });

    // Close modal event
    closeModal.addEventListener("click", () => {
        postModal.style.display = "none";
    });

    // Post form submit event
    postForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const title = document.getElementById("postTitle").value;
        const author = document.getElementById("postAuthor").value;
        const content = document.getElementById("postContent").value;
        addNotice(title, author, content);
        postModal.style.display = "none";
        postTitle.value = "";
        postAuthor.value = "";
        postContent.value = "";
    });
});
