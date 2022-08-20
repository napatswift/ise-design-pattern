package decorators;

import animals.Quackable;

public class QuackEchoer implements Quackable {
    private Quackable duck;

    public QuackEchoer(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        System.out.print("Echo: ");
        duck.quack();
    }
}
