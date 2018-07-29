import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherReadAndWrite {

    public static ArrayList<WeatherInfo> readAndWrite (String name) throws IOException {

        FileReader fr = null;
        try{
            fr = new FileReader(name);
        }
        catch (FileNotFoundException ex){
            System.out.println("File not exist");
        }
        BufferedReader br = new BufferedReader(fr);

        ArrayList <WeatherInfo> weatherInfos = new ArrayList<>();
        String city;

        try {
            do {
                city = br.readLine();
                if (city != null) {
                    WeatherApi api = new WeatherApi();
                    String description = api.getDescription(city);
                    int temperature = api.getTemperature(city);
                    WeatherInfo weatherInformation = new WeatherInfo(city, description, temperature);
                    weatherInfos.add(weatherInformation);
                }
            }
            while (city != null);
            br.close();
        }
        catch (IOException ex){
            System.out.println("Błąd wczytywanie danych");
        }
        return weatherInfos;
    }
    public static void ImportingDataToFile(String name, ArrayList<WeatherInfo> listWeather) throws IOException {
        FileWriter fw = null;
        try{
            fw = new FileWriter(name);
        }
        catch (IOException ex){
            System.out.println("Error");
        }
        BufferedWriter bw = new BufferedWriter(fw);
        String newLine = null;

        for (int i = 0; i < listWeather.size(); i++) {
            newLine = listWeather.get(i).getCity() + "," + listWeather.get(i).getDescription()+","+ listWeather.get(i).getTemperature();
            bw.write(newLine);
            bw.newLine();
        }
        bw.close();
    }
}



