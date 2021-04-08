package co.escuelaing.edu.arsw.WeatherInfo.controller;

import co.escuelaing.edu.arsw.WeatherInfo.connector.impl.ConnectroApiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Clase encargada de ofrecer los metodos http
 * al servidor
 */
@Controller
public class WebController {
    @Autowired
    ConnectroApiImpl connectroApiImpl;

    @GetMapping("/city")
    public ResponseEntity<?> getWeatherInfo(@RequestParam String name){
        String json = connectroApiImpl.getData(name);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
