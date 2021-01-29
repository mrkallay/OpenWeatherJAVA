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
    private static final String apiKey = "&APPID=3c38c4cc9274664fadb44d2bf3d80298";
    private static final String openWeatherURL = "https://api.openweathermap.org/data/2.5/weather?";

    //instance vars
    private String query;

    private Double temperature;

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


        Map main = ((Map)weatherData.get("main"));
        temperature = ((Double)main.get("temp"));
    }

    public Double getTemperature()
    {
        return temperature;
    }

}