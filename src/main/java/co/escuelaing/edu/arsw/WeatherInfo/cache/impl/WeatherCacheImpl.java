package co.escuelaing.edu.arsw.WeatherInfo.cache.impl;

import co.escuelaing.edu.arsw.WeatherInfo.cache.WeatherCache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Qualifier("cache")
public class WeatherCacheImpl implements WeatherCache {
    private HashMap<String,String> register= new HashMap<String,String>();

    @Override
    public String getByName(String key) {
        System.out.println("ENTRO a cache");
        return register.get(key);
    }

    @Override
    public boolean AddData(String key, String data) {
        register.put(key,data);
        return register.containsKey(key);
    }

    @Override
    public boolean contendData(String key) {
        return register.containsKey(key);
    }
}
