/**
 * Created by briankallay on 3/4/20.
 */
public class OpenWeatherDriver
{
    public static void main(String[] args) throws Exception
    {
        OpenWeatherRequest owr = new OpenWeatherRequest();
        //owr.setQuery("q=london,uk");
        owr.setQuery("zip=94501");
        owr.getWeatherData();
    }
}
