document.getElementById("doPost").addEventListener("click", function () {
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