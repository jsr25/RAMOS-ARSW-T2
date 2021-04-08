package co.escuelaing.edu.arsw.WeatherInfo.connector;

/**
 * interfaz que permite la connexion con la api
 */
public interface ConnectorApi {
    /**
     * Metodo que permite la conexion con el api
     * @param city nombre de la ciudad
     * @return datos obtenidos de la api
     */
    public String getData(String city);
}
