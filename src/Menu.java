import java.sql.*;
import java.util.Scanner;


public class Menu {
    public void menu(){
        int choice = new Scanner(System.in).nextInt();
        do {
            System.out.println("- 1 Ajouter une ville !");
            System.out.println("- 2 Afficher une ville !");
            System.out.println("- 3 Suppremir une ville !");
            System.out.println("- 4 Modifier une ville !");
            System.out.println("- 5 Afficher les historique !");
            System.out.println("---- Entrez ton choix");
            switch (choice){
                case 1 :
                    //ajouter();
                    break;
                case 2 :
                    //afficher();
                    break;
                case 3:
                    //suppremir();
                    break;
                case 4:
                    //modifier();
                    break;
                case 5 :
                    //AfficherH();
            }
        }while (choice!=0);

    }
}
