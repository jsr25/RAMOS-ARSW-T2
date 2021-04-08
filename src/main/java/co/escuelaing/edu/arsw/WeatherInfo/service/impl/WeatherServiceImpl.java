package co.escuelaing.edu.arsw.WeatherInfo.service.impl;

import co.escuelaing.edu.arsw.WeatherInfo.connector.ConnectorApi;
import co.escuelaing.edu.arsw.WeatherInfo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa la interfaz del servicio
 */
@Component
@Qualifier("service")
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    @Qualifier("conn")
    ConnectorApi connectorApi;

    @Override
    public String getDataByCity(String city) {
        return connectorApi.getData(city);
    }
}
