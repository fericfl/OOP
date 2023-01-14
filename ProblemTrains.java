import java.util.ArrayList;

class SizeFull extends RuntimeException {
    public SizeFull() {
        super("Train is full");
    }
}

class Train {
    ArrayList<Carriages> t;
    protected int TrainSize = 15;

    public Train() {
        t = new ArrayList<>();
    }

    public void addCarriage(Carriages element) throws SizeFull{
        if(t.size() >= TrainSize)
            throw new SizeFull();
        t.add(element);
    }

    public boolean equals(Train t) {
        if(getMaxPackages() == t.getMaxPackages())
            return true;
        return false;
    }

    public int getMaxPackages() {
        int sum = 0;
        for(int i = 0; i < t.size(); i++) {
            sum += t.get(i).getPackages();
        }
        return sum;
    }

    public String toString() {
        String aux = "";
        for(int i = 0; i < t.size(); i++) {
            aux += t.get(i).getClass().getName() + " ";
        }
        return aux;
    }
}

class Carriages {
    protected int maxPackages = 0;
    protected int CarriageNo = 0;

    public Carriages(int maxPackages) {
        this.maxPackages = maxPackages;
        CarriageNo++;
    }

    public int getPackages() {
        return maxPackages;
    }

}

abstract class PassangerCar extends Carriages{
    protected int maxPassangers = 0;

    public PassangerCar(int maxPackages, int maxPassangers) {
        super(maxPackages);
        this.maxPassangers = maxPassangers;
    }

    public void openDoors() {
        System.out.println("Opening doors on carriage no. " + CarriageNo);
    }

    public void closeDoors() {
        System.out.println("Closing doors on carriage no. " + CarriageNo);
    }
}

class PassangerCarA extends PassangerCar {
    public PassangerCarA() {
        super(300,40);
    }
}

class PassangerCarB extends PassangerCar {
    public PassangerCarB() {
        super(400,50);
    }

    public void blockDoors() {
        System.out.println("Blocking doors on carriage no. " + CarriageNo);
    }
}

class LoadsCar extends Carriages {
    public LoadsCar() {
        super(400);
    }
}

public class ProblemTrains {
    public static void main(String[] args) {
        Carriages c1 = new PassangerCarA();
        Carriages c2 = new PassangerCarB();
        Carriages c3 = new LoadsCar();

        Train t1 = new Train();
        Train t2 = new Train();

        t1.addCarriage(c1);
        t1.addCarriage(c2);
        t1.addCarriage(c3);

        t2.addCarriage(c1);
        t2.addCarriage(c2);
        t2.addCarriage(c3);

        ((PassangerCarB)c2).blockDoors();

        System.out.println(t1.equals(t2));
        System.out.println(t1.toString());
    }
}