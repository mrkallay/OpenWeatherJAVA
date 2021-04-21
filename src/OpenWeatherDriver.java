/**
 * Created by briankallay on 3/4/20.
 */
import java.util.Scanner;
public class OpenWeatherDriver
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);

        while(true)
        {
            System.out.println("What zip code would you like the weather for?");
            String zip = in.nextLine();

            OpenWeatherRequest owr = new OpenWeatherRequest();
            //owr.setQuery("q=london,uk");
            owr.setQuery("zip=" + zip + "&units=imperial");
            owr.getWeatherData();
            System.out.println("Current Temperature for " + zip + ": " + owr.getTemperature());
        }
    }
}
