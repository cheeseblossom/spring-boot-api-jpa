const post = document.getElementById("doPost");
const put = document.getElementById("doPut");
const remove = document.getElementById("doDelete");
const rremove = document.getElementById("doRDelete");

if (post != null) {
  post.addEventListener("click", function () {
    fetch("/api/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        text: document.getElementById("text").value
      })
    })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .catch((error) => console.log(error));
  });
}

if (put != null) {
  put.addEventListener("click", function () {
    fetch("/api/change", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        idx: document.getElementById("idx").value,
        text: document.getElementById("text").value
      })
    })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .catch((error) => console.log(error));
  });
}

if (remove != null) {
  remove.addEventListener("click", function () {
    fetch("/api/remove", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        idx: document.getElementById("idx").value
      })
    })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .catch((error) => console.log(error));
  });
}

if (rremove != null) {
  rremove.addEventListener("click", function () {
    fetch("/api/rremove", {
      method: "delete",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        idx: document.getElementById("idx").value
      })
    })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .catch((error) => console.log(error));
  });
}