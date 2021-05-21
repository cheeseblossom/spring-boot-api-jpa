const post = document.getElementById("doPost");
const put = document.getElementById("doPut");

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