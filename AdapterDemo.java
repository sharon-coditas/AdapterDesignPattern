package AdapterDesign_Presentation;

interface Bird
{
    public void fly();
    public void makeSound();
}

class Sparrow implements Bird                   //concrete implementation of Bird
{
    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}

interface ToyDuck
{
    // target interface
    // toyducks dont fly they just make
    // squeaking sound
    public void squeak();
}

class PlasticToyDuck implements ToyDuck             //concrete implementation of ToyDuck
{
    @Override
    public void squeak() {
        System.out.println("Squeak");
    }
}

class BirdAdapter implements ToyDuck  {

    Bird bird;
    public BirdAdapter(Bird bird){
        this.bird = bird;
    }

    @Override
    public void squeak() {
        bird.makeSound();
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}