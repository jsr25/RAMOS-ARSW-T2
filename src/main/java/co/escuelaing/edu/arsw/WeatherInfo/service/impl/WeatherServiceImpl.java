package co.escuelaing.edu.arsw.WeatherInfo.service.impl;

import co.escuelaing.edu.arsw.WeatherInfo.cache.WeatherCache;
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

    @Autowired
    @Qualifier("cache")
    WeatherCache cache;

    @Override
    public String getDataByCity(String city) {
        String data="";
        if(cache.contendData(city)){
            data=cache.getByName(city);
        }
        else{
            data = connectorApi.getData(city);
            cache.AddData(city,data);
        }
        return data;
    }
}
