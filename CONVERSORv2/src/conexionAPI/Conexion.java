package conexionAPI;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class Conexion {
	public static double obtenerCotizacion(String monedaOrigen, String monedaDestino) throws Exception {
	    // Crea una URL para la API
	    String urlStr = "https://openexchangerates.org/api/latest.json?app_id=381aad80babe43d684b0a206432193f9&symbols=" + monedaDestino + "&base=" + monedaOrigen;
	    System.out.println(urlStr);
	    URL url = new URL(urlStr);

	    // Abre una conexión HTTP a la URL
	    HttpURLConnection con = (HttpURLConnection) url.openConnection();

	    // Establece el método HTTP GET
	    con.setRequestMethod("GET");

	    // Lee la respuesta de la API
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer content = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	        content.append(inputLine);
	    }
	    in.close();
	    con.disconnect();

	    // Convierte la respuesta de la API de JSON a un objeto Java utilizando la clase JSONObject
	    JSONObject jsonObject = new JSONObject(content.toString());

	    // Obtiene la cotización de la moneda de origen a la moneda de destino
	    double tasaCambio = jsonObject.getJSONObject("rates").getDouble(monedaDestino);

	    return tasaCambio;
	}
	
	
	
	public static JSONObject obtenerDivisasDisponibles() throws Exception {
        // Crea una URL para la API
        URL url = new URL("https://openexchangerates.org/api/currencies.json");

        // Abre una conexión HTTP a la URL
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Establece el método HTTP GET
        con.setRequestMethod("GET");

        // Lee la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        // Convierte la respuesta de la API de JSON a un objeto Java utilizando la clase JSONObject
         JSONObject jsonObject = new JSONObject(content.toString());
         return jsonObject;
         
         
         
         
         
//        // Itera sobre las claves de objeto JSON y muestra los nombres de las divisas disponibles
//        Iterator<String> keys = jsonObject.keys();
//        while(keys.hasNext()) {
//            String key = keys.next();
//            String value = jsonObject.getString(key);
//            System.out.println(key + " - " + value);
//            */
        }
    }
	
	

