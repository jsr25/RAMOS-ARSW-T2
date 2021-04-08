package co.escuelaing.edu.arsw.WeatherInfo.service;

/**
 * Interfaz que ofrece los servicios al controlador
 */
public interface WeatherService {
    /**
     * Metodo que permite obtener los datos del clima
     * @param city nombre de la ciudad
     * @return informacion obtenida
     */
    public String getDataByCity(String city);

}
