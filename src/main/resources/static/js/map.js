
var map;
var geoJSON;
var request;
var gettingData = false;
var openWeatherMapKey = "f70fd1eb9fb8c63c6a242766f8f90670"
var geocoder = new google.maps.Geocoder();



function initialize() {
    var mapOptions = {
        zoom: 7,
        center: new google.maps.LatLng(50, -50)
    };
    map = new google.maps.Map(document.getElementById('map-canvas'),
        mapOptions);
}


var infowindow = new google.maps.InfoWindow();
// For each result that comes back, convert the data to geoJSON
var jsonToGeoJson = function (weatherItem) {
    var feature = {
        type: "Feature",
        properties: {
            city: weatherItem.name,
            weather: weatherItem.weather[0].main,
            temperature: weatherItem.main.temp,
            min: weatherItem.main.temp_min,
            max: weatherItem.main.temp_max,
            humidity: weatherItem.main.humidity,
            pressure: weatherItem.main.pressure,
            windSpeed: weatherItem.wind.speed,
            windDegrees: weatherItem.wind.deg,
            windGust: weatherItem.wind.gust,
            icon: "http://openweathermap.org/img/w/"
                + weatherItem.weather[0].icon + ".png",
            coordinates: [weatherItem.coord.Lon, weatherItem.coord.Lat]
        },
        geometry: {
            type: "Point",
            coordinates: [weatherItem.coord.Lon, weatherItem.coord.Lat]
        }
    };
    // Set the custom marker icon
    map.data.setStyle(function (feature) {
        return {
            icon: {
                url: feature.getProperty('icon'),
                anchor: new google.maps.Point(25, 25)
            }
        };
    });
    // returns object
    return feature;
};
// Add the markers to the map
var drawIcons = function (weather) {
    map.data.addGeoJson(geoJSON);
    // Set the flag to finished
    gettingData = false;
};
// Clear data layer and geoJSON
var resetData = function () {
    geoJSON = {
        type: "FeatureCollection",
        features: []
    };
    map.data.forEach(function (feature) {
        map.data.remove(feature);
    });
};

function codeAddress(addr, map) {
    geocoder.geocode({ 'address': addr }, function (results, status) {
        if (status == 'OK') {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}

var markers;
var bounds;

function addmarket() {
    markers = [];
    bounds = new google.maps.LatLngBounds();
    var position = new google.maps.LatLng(marker.lat, marker.lng);
    markers.push(
        new google.maps.Marker({
            position: position,
            map: map,
            animation: google.maps.Animation.DROP
        })
    );

    bounds.extend(position);


map.fitBounds(bounds);
}



