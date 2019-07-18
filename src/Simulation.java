import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Simulation {

    // declaring constructor
    public Simulation() {
    }

    //loadItems: this method loads all items from a text file and returns an ArrayList of Items
    ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> items = new ArrayList<>();

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] oneLine = line.split("=");
            items.add(new Item(oneLine[0], Integer.valueOf(oneLine[1])));
        }

        // TEST - shows what's inside the file
        //for (Item i : items) {
            //System.out.println(i.name + ": " + i.weight);
        //}
         //   System.out.println();

        return items;
    }


     //loadU1: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets. It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
    ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket rocket = new U1();

        int itemCounter = 1;
        int rocketCounter = 1;


        for (Item i : list) {

            while (!rocket.canCarry(i)) {
                rocketCounter++;
                fleet.add(rocket);
                rocket = new U1();
            }
            rocket.carry(i);
            itemCounter++;
        }
        fleet.add(rocket);
        return fleet;
    }


    //loadU2: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets. It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one until all items are loaded. The method then returns the ArrayList of those U2 rockets that are fully loaded.
    ArrayList<Rocket> loadU2(ArrayList<Item> list) {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket rocket = new U2();

        int itemCounter = 1;
        int rocketCounter = 1;

        for (Item i : list) {

            while (!rocket.canCarry(i)) {
                rocketCounter++;
                fleet.add(rocket);
                rocket = new U2();
            }
            rocket.carry(i);
            itemCounter++;
        }
        fleet.add(rocket);
        return fleet;
    }


    // this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again. All while keeping track of the total budget required to send each rocket safely to Mars. runSimulation then returns the total budget required to send all rockets (including the crashed ones).
    int runSimulation(ArrayList<Rocket> list) {
        int fails = 0;
        int i = 1;
        for (Rocket rocket : list) {

            while (!rocket.launch()) {
                rocket.launch();
                fails++;
                //System.out.println("Failed launch(es): " + fails);
            }
            //System.out.println("Nr " + i + " rocket launched");

            while (!rocket.land()) {
                rocket.land();
                fails++;
                //System.out.println("Failed landing(s): " + fails);
            }
            //System.out.println("Nr " + i + " rocket landed");
            i++;
        }
        int budget = list.get(0).cost * (list.size() + fails);
        System.out.println(list.size() + " rockets and " + fails + " fails = "
                + (list.size() + fails) + " in total");
        return budget;
    }

}