const app = (function () {
    let city;
    
    function getCity(){
        city = $("#city").val()
    }

    function getWeatherByName() {
        getCity()
        const promise = $.get({
            url: "/city?name="+city,
            contentType: "application/json",
        });
        promise.then( data => {
            $("#header").append(city)
            console.log(data)
        }, erro =>{
            alert("no se Encontraron los datos solicitados")
        }
        );
    }

    return {
        getWeatherByName : getWeatherByName 
    }



})();