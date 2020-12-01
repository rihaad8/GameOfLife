import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import Game.GameOfLife;

public class Verwaltung {

    public void run(String[] args){

        int HEIGHT = 20;
        int WIDTH = 20;
        System.out.println("Herzlich Willkommen zum Game of Life");
        char userInput;
        GameOfLife gameOfLife = new GameOfLife();
        int coordinates[] = scanAndRead(args);
        int[][] showingArray = gameOfLife.startGameOfLife(WIDTH, HEIGHT,coordinates);
        int runCount = 0;
        do {
            int currentLife = gameOfLife.countLife(showingArray);
            System.out.println("----------------------------------------------------");
            System.out.println("[y] Um die naechste Gernation auszugeben");
            System.out.println("[n] Um das Programm zu beenden");
            System.out.printf("Aktuelle Generation: %d Aktueller Lebensstand: %d \n", runCount, currentLife);
            System.out.println("----------------------------------------------------");
            Scanner input = new Scanner(System.in);
            userInput = input.next().charAt(0);
            if(userInput == 'n'){
                System.out.println("Bis zum naechsten mal.");
                break;
            }
            showingArray = gameOfLife.nextGen(showingArray, HEIGHT, WIDTH);
            runCount++;
        }while(userInput == 'y');

    }
    private int[] scanAndRead(String[] args){
        File file = new File(args[0]);

        try {
            Scanner sc = new Scanner(file);
            int array[] = new int[(sc.nextInt())*2];
            for(int i = 0;sc.hasNextLine();i++) {
                array[i] = sc.nextInt();
                //System.out.println(array[i]);
            }
            sc.close();
            return array;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            int failArray[] = {-1};
            return failArray;
        }

    }
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("Bitte gueltigen Dateipfad zur Nutzung angeben.");
            System.exit(0);
        }
        // create Verwaltung
        Verwaltung verwaltung = new Verwaltung();
        // method start
        verwaltung.run(args);
    }
}
