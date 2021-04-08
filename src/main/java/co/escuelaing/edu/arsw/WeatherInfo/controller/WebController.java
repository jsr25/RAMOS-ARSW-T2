package co.escuelaing.edu.arsw.WeatherInfo.controller;

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

    @GetMapping("/city")
    public ResponseEntity<?> getWeatherInfo(@RequestParam String name){
        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}
