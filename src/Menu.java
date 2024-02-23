import java.sql.*;
import java.util.Scanner;


public class Menu {
    public void menu() throws SQLException {
        int choice;
        do {
            System.out.println("- 1 Ajouter une ville !");
            System.out.println("- 2 Afficher une ville !");
            System.out.println("- 3 Suppremir une ville !");
            System.out.println("- 4 Modifier une ville !");
            System.out.println("- 5 Afficher les historique !");
            System.out.println("---- Entrez ton choix");
             choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1 :
                    ajouter();
                    break;
                case 2 :
                    //afficher();
                    System.out.println(DataConnection.getCity());
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    update();
                    break;
                case 5 :
                    //AfficherH();
            }
        }while (choice!=0);

    }

    public void ajouter() throws SQLException {
        City city = new City();
        System.out.println("ENTRE CITY ID !");
        city.setCityId(new Scanner(System.in).nextInt());
        System.out.println("ENTRE CITY NAME !");
        city.setCityName(new Scanner(System.in).nextLine());
        System.out.println("ENTRE THE CITY TEMPERATURE !");
        city.setCurrentTemperature(new Scanner(System.in).nextInt());
        System.out.println("ENTRE THE CITY HUMIDITY !");
        city.setCurrentHumidity(new Scanner(System.in).nextInt());
        System.out.println("ENTRE THE CITY WINDSPEED !");
        city.setCurrentWindSpeed(new Scanner(System.in).nextInt());

        DataConnection.addCity(city);
    }
    public void update() throws SQLException {
        City city = new City();
        System.out.println("ENTRE THE ID !");
        city.setCityId(new Scanner(System.in).nextInt());

        System.out.println("ENTRE CITY NAME !");
        city.setCityName(new Scanner(System.in).nextLine());

        System.out.println("ENTRE THE CITY TEMPERATURE !");
        city.setCurrentTemperature(new Scanner(System.in).nextInt());

        System.out.println("ENTRE THE CITY HUMIDITY !");
        city.setCurrentHumidity(new Scanner(System.in).nextInt());

        System.out.println("ENTRE THE CITY WINDSPEED !");
        city.setCurrentWindSpeed(new Scanner(System.in).nextInt());

        DataConnection.updateCity(city);
    }

    public void remove() throws SQLException {
        System.out.println("ENTRE THE ID !");
        Integer Id = new Scanner(System.in).nextInt();
        DataConnection.deleteCity(Id);
    }
}
