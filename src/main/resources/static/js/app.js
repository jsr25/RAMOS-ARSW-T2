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
            $("#header").empty()
            $("#header").append("Weather Info City: "+city)
            let json = JSON.parse(data)
            let main =json.main
            let info =json.weather[0]
            console.log(json.coord)
            showInfo(main,info)
            map.addmarket(json.coord)
        }, erro =>{
            alert("no se Encontraron los datos solicitados")
        }
        );
    }

    function showInfo(main,info){
        let table ="<tbody id=\"body\"><tr><td>"+info.main+"</td><td>"+info.description+"</td><td>"+main.feels_like+"</td><td>"+main.humidity+"</td><td>"+main.pressure+"</td><td>"+main.temp+"</td><td>"+main.temp_max+"</td><td>"+main.temp_min+"</td></tr></tbody>"
        $("#body").remove()
        $("#table").append(table)
    }

    

    return {
        getWeatherByName : getWeatherByName 
        
    }



})();