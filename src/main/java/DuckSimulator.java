import adapters.GooseAdapter;
import adapters.PigeonAdapter;
import animals.*;
import decorators.QuackCounter;
import decorators.QuackEchoer;

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
}
