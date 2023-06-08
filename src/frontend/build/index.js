const MOTORCYCLE_API = "http://localhost:8080/api/v1/motorcycles";

async function fetchMotorcycles() {
    const data = await fetch(MOTORCYCLE_API);
    const motorcycles = await data.json();

    const motorcycleSection = document.querySelector("#motorcycleSection");
    motorcycleSection.innerHTML = "";

    for (const motorcycle of motorcycles) {
        const div = document.createElement("div");
        div.innerHTML = "------------------<br/>";
        for (const attribute in motorcycle) {
            div.innerHTML += `${attribute} of this motorcycle is: ${motorcycle[attribute]}<br/>`;
        }
        div.innerHTML += "------------------<br/>";
        motorcycleSection.appendChild(div);
    }
}

async function postMotorcycle(event) {
    event.preventDefault();

    const motorcycleMake = document.querySelector("#motorcycleMake").value;
    const motorcycleModel = document.querySelector("#motorcycleModel").value;
    const motorcycleYear = document.querySelector("#motorcycleYear").value;

    const motorcycleDto = {
        motorcycleMake,
        motorcycleModel,
        motorcycleYear
    }

    const initialRequestObj = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(motorcycleDto)
    }

    await fetch(MOTORCYCLE_API, initialRequestObj);

    await fetchMotorcycles();

}

const motorcycleForm = document.querySelector("#motorcyclePostForm");
motorcycleForm.addEventListener("submit", postMotorcycle)