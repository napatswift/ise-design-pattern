package animals.composites;

import animals.Quackable;

import java.util.ArrayList;

public class FlockWithLeader implements Quackable {
    ArrayList<Quackable> quackers = new ArrayList<>();

    public void addQuacker(Quackable quacker) {
        quackers.add(quacker);
    }
    @Override
    public void quack() {
        for (int i = 0; i < quackers.size(); i++) {
            if (i == 0) {
                for (int j = 0; j < 3; j++) quackers.get(i).quack();
            } else {
                quackers.get(i).quack();
            }
        }
    }
}
