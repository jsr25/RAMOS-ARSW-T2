package co.escuelaing.edu.arsw.WeatherInfo.cache;

/**
 * Interfaz creada para el servicio de cache
 *
 */
public interface WeatherCache {

    /**
     * Metodo que permite obtener los datos apartir de la cache
     * @param key llave para obtener datos
     * @return retorna los daots almacenados
     */
    public String getByName(String key);

    /**
     * Metodo que permite agregar los datos al cache
     * @param key llave con la que se quiere guardar
     * @param data datos que se quieren almacenar
     * @return valor boolean informando que el registro fue exitoso
     */
    public boolean AddData(String key, String data);

    /**
     * Metodo que permite consultar si la llave ya esta guardada en cache
     * @param key llave que se queire consultar
     * @return valor indicando si esa llave esta registrada
     */
    public boolean contendData(String key);

}
