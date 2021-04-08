package co.escuelaing.edu.arsw.WeatherInfo.connector.impl;

import co.escuelaing.edu.arsw.WeatherInfo.connector.ConnectorApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ConnectroApiImpl implements ConnectorApi {
    private final String apiKey ="42aafc92cbb3c37a49168ea7f392d26e";

    @Override
    public String getData(String city) {
        StringBuilder data = new StringBuilder();
        URL url = null;
        HttpURLConnection con = null;
        try{
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linea;
            while ((linea = rd.readLine()) != null) {
                data.append(linea);
            }
            rd.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data.toString();
    }
}
