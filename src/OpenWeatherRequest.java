/**
 * Created by briankallay on 3/4/20.
 */
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.net.*;
import java.io.*;

public class OpenWeatherRequest
{

    //class vars
    private static final String apiKey = "";
    private static final String openWeatherURL = "https://api.openweathermap.org/data/2.5/weather?";

    //instance vars
    private String query;

    private Double latitude;
    private Double longitude;

    private String weather;

    public void setQuery(String query)
    {
        this.query = query;
    }

    public void getWeatherData() throws Exception
    {
        URL url = new URL(openWeatherURL + query + apiKey);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        Object obj = new JSONParser().parse(in);
        JSONObject weatherData = (JSONObject) obj;


        Map coord = ((Map)weatherData.get("coord"));
        longitude = (Double)coord.get("lon");
        latitude = (Double)coord.get("lat");


        JSONArray weatherArray = (JSONArray) weatherData.get("weather");
        Map weatherDetails = (Map)weatherArray.get(0);
        weather = (String)weatherDetails.get("main") + ":" + (String)weatherDetails.get("description");
        System.out.println(weather);
    }

}