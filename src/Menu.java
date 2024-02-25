import java.sql.*;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Menu {
    public void menu() throws SQLException{
        int choice;
        do {
            System.out.println("- 1 Ajouter une ville !");
            System.out.println("- 2 Afficher les villes !");
            System.out.println("- 3 Suppremir une ville !");
            System.out.println("- 4 Modifier une ville !");
            System.out.println("- 5 Afficher les historique !");
            System.out.println("- 6 Rechercher l'histoire des villes précédentes");
            System.out.println("---- Entrez ton choix");
             choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1 :
                    ajouter();
                    break;
                case 2 :
                    System.out.println(DataConnection.getCity());
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    updateCity();
                    break;
                case 5 :
                    afficherH();
                    break;
                case 6 :
                    search();
                    break;
                default:
                    System.out.println("Entrer un nomber entre 0 et 6 !");
                    break;
            }
        }while (choice!=0);

    }

    public void ajouter() throws SQLException{
        System.out.println("ENTRE CITY ID !");
        Integer cityId = new Scanner(System.in).nextInt();

        System.out.println("ENTRE CITY NAME !");
        String cityName = new Scanner(System.in).nextLine();

        System.out.println("ENTRE THE CITY TEMPERATURE !");
        Integer currentTemperature = new Scanner(System.in).nextInt();

        System.out.println("ENTRE THE CITY HUMIDITY !");
        Integer currentHumidity = new Scanner(System.in).nextInt();

        System.out.println("ENTRE THE CITY WINDSPEED !");
        Integer currentWindSpeed = new Scanner(System.in).nextInt();

        DataConnection.addCity(new City(cityId, cityName, currentTemperature, currentHumidity , currentWindSpeed));

        DataConnection.addCityHistory(new CityHistory(cityId, currentTemperature, cityName));
    }
    public void remove() throws  SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|         Supprimer une ville         |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez le nom du ville à supprimer :");
        String name =new Scanner(System.in).nextLine();
        DataConnection.deleteCity(DataConnection.getCity().stream().filter(city1 -> city1.getCityName().equals(name)).collect(Collectors.toList()).get(0).getCityName());

    }
    public void updateCity() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|         Modifier une ville         |");
        System.out.println("+-------------------------------------+");
        System.out.println("| - Entrez Id du ville à Modifier :");
        Integer ID= new Scanner(System.in).nextInt();

        System.out.println("ENTRE CITY NAME !");
        String NAME = new Scanner(System.in).nextLine();

        System.out.println("ENTRE THE CITY TEMPERATURE !");
        Integer TEM  = new Scanner(System.in).nextInt();

        System.out.println("ENTRE THE CITY HUMIDITY !");
        Integer HUM = new Scanner(System.in).nextInt();

        System.out.println("ENTRE THE CITY WINDSPEED !");
        Integer WINDO = new Scanner(System.in).nextInt();

        DataConnection.updateCity(new City(ID, NAME , TEM , HUM , WINDO));
        DataConnection.modifierH(new CityHistory(ID , TEM , NAME));
    }

    public void search() throws SQLException {
        System.out.println("Entrez le nom de la ville à rechercher :");
        String cityName = new Scanner(System.in).nextLine();
        System.out.println("╔══════════════════════════╗");
        System.out.println("║          Search          ║");
        System.out.println(" ══════════════════════════ ");
        DataConnection.searchCityHistory(cityName);
    }
    public void afficherH() throws SQLException {
        System.out.println("+-------------------------------------+");
        System.out.println("|         historique des villes         |");
        System.out.println("+-------------------------------------+");
        for ( CityHistory cityHistory : DataConnection.getCityHistory()){
            System.out.println("----------------------------");
            System.out.println("ID: " + cityHistory.getHistoricalDataId());
            System.out.println("Nom de la ville: " + cityHistory.getCityName());
            System.out.println("ID de la ville: " + cityHistory.getCityId());
            System.out.println("Date: " + cityHistory.getDate());
            System.out.println("Température: " + cityHistory.getTemperature());
            System.out.println("-----------------------------");
        }
    }
}
