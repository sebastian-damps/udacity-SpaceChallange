import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // declaring object Simulation
        Simulation simulation = new Simulation();

        // Loading Items for Phase-1 and Phase-2
        ArrayList<Item> phase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = simulation.loadItems("phase-2.txt");


        // Load a fleet of U1 rockets for Phase-1 and then for Phase-2
        ArrayList<Rocket> u1fleedP1 = simulation.loadU1(phase1);
        ArrayList<Rocket> u1FleetP2 = simulation.loadU1(phase2);

        // Run the simulation using the fleet of U1 rockets and display the total budget required.
        int budgetU1P1 = simulation.runSimulation(u1fleedP1);
        System.out.println("Budget of U1 fleet in Phase 1 = " + budgetU1P1 + " millions");

        int budgetU1P2 = simulation.runSimulation(u1FleetP2);
        System.out.println("Budget of U1 fleet in Phase 2 = " + budgetU1P2 + " millions");

        System.out.println("Total budget of U1 fleet = " + (budgetU1P1 + budgetU1P2) + " millions");

        // Load a fleet of U2 rockets for Phase-1 and then for Phase-2
        ArrayList<Rocket> u2FleedP1 = simulation.loadU2(phase1);
        ArrayList<Rocket> u2FleetP2 = simulation.loadU2(phase2);

        // Run the simulation using the fleet of U2 rockets and display the total budget required.
        int budgetU2P1 = simulation.runSimulation(u2FleedP1);
        System.out.println("Budget of U2 fleet in Phase 1 = " + budgetU2P1 + " millions");

        int budgetU2P2 = simulation.runSimulation(u2FleetP2);
        System.out.println("Budget of U2 fleet in Phase 2 = " + budgetU2P2 + " millions");

        System.out.println("Total budget of U2 fleet = " + (budgetU2P1 + budgetU2P2) + " millions");

        if( (budgetU1P1 + budgetU1P2) >  (budgetU2P1 + budgetU2P2) ){
            System.out.println("In this simulation using Rockets U2 is cheaper than using rockets U1 by "+ ((budgetU1P1 + budgetU1P2)-(budgetU2P1 + budgetU2P2))+" millions.");
        }
        else{
            System.out.println("In this simulation using Rockets U1 is cheaper than using rockets U2 by "+ ((budgetU2P1 + budgetU2P2)-(budgetU1P1 + budgetU1P2))+" millions.");

        }

    }
}
