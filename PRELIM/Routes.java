//DIAMANTE, Christina | BSIT 2A
//Routes to Moalboal
import java.util.Scanner;
public class Routes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String Barili = "", Dumanjug = "", Route = "";
        double distance = 0, speed;
        
        System.out.println("\tDestination: MOALBOAL");
        System.out.print("Input your speed (km/hr) : ");
        speed = scan.nextDouble();
        scan.nextLine();

        System.out.print("Is Barili Obstructed? (Yes or No?) : ");
        Barili = scan.nextLine().trim();
        if(Barili.toLowerCase().equals("yes")) {
            System.out.print("Is Domanjug Obstructed? (Yes or No?) : ");
            Dumanjug = scan.nextLine().trim();
        }
        if(Barili.toLowerCase().equals("yes") && Dumanjug.toLowerCase().equals("yes")) {
            Route = "\tCeby City (SBT)\tSTART \n\tMinglanilla\t\t\tRoute 1 \n\tSan Fernando\t\tRoute 2 \n\tCarcar\t\t\t\tRoute 3 \n\tSibonga\t\t\t\tRoute 4 \n\tArgao\t\t\t\t\tRoute 5 \n\tRonda\t\t\t\t\tRoute 5.1 \n\tAlcantara\t\t\tRoute 5.2 \n\tMoalboal\t\t\t\tEND";
            distance = 108;
        }else if(Barili.toLowerCase().equals("yes") && Dumanjug.toLowerCase().equals("no")){
            Route = "\tCebu City (SBT)\tSTART \n\tMinglanilla\t\t\tRoute 1 \n\tSan Fernando\t\tRoute 2 \n\tCarcar\t\t\t\tRoute 3 \n\tSibonga\t\t\t\tRoute 4.2 \n\tDumanjug\t\t\t\tRoute 4.2.1 \n\tAlcantara\t\t\tRoute 4.2.2 \n\tMoalboal\t\t\t\tEND";
            distance = 98;
        }else{
            Route = "\tCebu City (SBT)\tSTART \n\tMinglanilla\t\t\tRoute 1 \n\tSan Fernando\t\tRoute 2 \n\tCarcar\t\t\t\tRoute 3 \n\tBarili\t\t\t\tRoute 4.1 \n\tDumanjug\t\t\t\tRoute 4.1.1 \n\tAlcantara\t\t\tRoute 4.1.2 \n\tMoalboal\t\t\t\tEND";
            distance = 84.9;
        }
        System.out.println("\n\t\t\t***OUTPUT*** \nRecommended Route:\n" + Route + "\nSpeed: " + speed + " km/hrs \nDistance: " + distance
            + " km \nEstimated Time of Arrival: " + (int)(distance/speed) + " hour(s) " + (int)((distance/speed - Math.floor(distance/speed))*60) + " minute(s)");
    }
}