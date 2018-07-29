import java.io.IOException;
import java.util.ArrayList;

public class WeatherApp {
    public static void main(String[] args) throws IOException {

        ArrayList<WeatherInfo> weatherList = WeatherReadAndWrite.readAndWrite("cities.txt");
        for (int i = 0; i < weatherList.size(); i++) {
            String information = weatherList.get(i).toString();
            System.out.println(information);
        }
        WeatherReadAndWrite.ImportingDataToFile("weather.csv",weatherList );
    }

}

