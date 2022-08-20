package adapters;

import animals.Pigeon;
import animals.Quackable;

public class PigeonAdapter implements Quackable {
    private Pigeon pigeon;

    public PigeonAdapter(Pigeon pigeon) {
        this.pigeon = pigeon;
    }

    @Override
    public void quack() {
        this.pigeon.coo();
        this.pigeon.coo();
    }
}
