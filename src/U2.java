public class U2 extends Rocket {

    public U2 (){
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
        currentWeight = weight;
        launchExplosion = 0.0;
        landingCrash = 0.0;

    }
    //launch: a method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
    public boolean launch() {
        int random = (int)(Math.random() * 100 + 1);
        launchExplosion = 4.0 * (currentWeight - weight) / (maxWeight - weight);
        return launchExplosion <= random;
    }
    // land: a method that also returns either true or false based on the success of the landing.
    public boolean land() {
        int random = (int)(Math.random() * 100 + 1);
        landingCrash = 8.0 * (currentWeight - weight) / (maxWeight - weight);
        return landingCrash <= random;
    }
}