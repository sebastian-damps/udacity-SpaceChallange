public class Rocket implements SpaceShip{
    int cost;
    int weight;
    int maxWeight;
    int currentWeight;
    double launchExplosion;
    double landingCrash;


    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    //canCarry: a method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
    public boolean canCarry(Item item) {
        return currentWeight + item.weight <= maxWeight;
    }

    //carry: a method that also takes an Item object and updates the current weight of the rocket.
    public int carry(Item item) {
        currentWeight += item.weight;
        return currentWeight;
    }

}
