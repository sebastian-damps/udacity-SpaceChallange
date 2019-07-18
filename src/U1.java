public class U1 extends Rocket {

    public U1 (){
        cost = 100; //100 million
        weight = 10000;
        maxWeight = 18000;
        currentWeight = weight;
        launchExplosion = 0.0;
        landingCrash = 0.0;

    }
    //launch: a method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
    public boolean launch() {

        int random = (int)(Math.random() * 100 + 1);
        launchExplosion = 5.0 * (currentWeight - weight) / (maxWeight - weight);

        //TEST
        //System.out.println("launchExplosion = " + launchExplosion + "; Random Number = " + random);

        return launchExplosion <= random;
    }

    //land: a method that also returns either true or false based on the success of the landing.
    public boolean land() {

        int random = (int)(Math.random() * 100 + 1);
        landingCrash = 1.0 * (currentWeight - weight) / (maxWeight - weight);

        //TEST
        //System.out.println("launchExplosion = " + launchExplosion + "; Random Number = " + random);

        return landingCrash <= random;
    }

}