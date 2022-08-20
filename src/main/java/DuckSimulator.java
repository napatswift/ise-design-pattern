import adapters.GooseAdapter;
import adapters.PigeonAdapter;
import animals.*;
import animals.composites.Flock;
import animals.composites.FlockWithLeader;
import decorators.QuackCounter;
import decorators.QuackEchoer;
import factories.AbstractDuckFactory;
import factories.CountingDuckFactory;
import factories.DuckFactory;
import factories.EchoingAndCountingDuckFactory;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

    void simulate() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);

        System.out.println("Quackologists say: \"The ducks quacked "+ QuackCounter.getQuacks() +" times\"");

        Quackable counterEcho = new QuackCounter(new QuackEchoer(new MallardDuck()));
        Quackable echoCounter = new QuackEchoer(new QuackCounter(new MallardDuck()));

        simulate(counterEcho);
        simulate(echoCounter);
    }

    void simulate(Quackable duck) {
        duck.quack();
    }

    void simulateFactory() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory echoingAndCountingDuckFactory = new EchoingAndCountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = countingDuckFactory.createRedheadDuck();
        Quackable duckCall = echoingAndCountingDuckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);
        simulate(pigeonDuck);

        System.out.println("Quackologists say: \"The ducks quacked "+ QuackCounter.getQuacks() +" times\"");
    }

    public void simulateFlock() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        Flock flock = new Flock();
        flock.addQuacker(mallardDuck);
        flock.addQuacker(redHeadDuck);
        flock.addQuacker(duckCall);
        flock.addQuacker(rubberDuck);

        flock.quack();
    }

    public void simulateFlockWithLeader() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        FlockWithLeader flock = new FlockWithLeader();
        flock.addQuacker(mallardDuck);
        flock.addQuacker(redHeadDuck);
        flock.addQuacker(duckCall);
        flock.addQuacker(rubberDuck);

        flock.quack();
    }
}
