class Plane {
    protected int Power;
    protected int PlaneID;
    protected static int count = 0;

    public Plane (int Power) {
        this.Power = Power;
        PlaneID = ++count;
    }

    public String getPlaneID() {
        return "" + PlaneID;
    }

    public int getEnginePower () {
        return Power;
    }

    public void takeOff() {
        System.out.println("takeOff " + PlaneID);
    }

    public void land() {
        System.out.println("land " + PlaneID);
    }

    public void fly() {
        System.out.println("fly " + PlaneID);
    }
}

class PassangerPlane extends Plane {
    protected int maxPassangers;

    public PassangerPlane(int Power, int maxPassangers) {
        super(Power);
        this.maxPassangers = maxPassangers;
    } 
    public int getMaxPassangers() {
        return maxPassangers;
    }
}

//Passanger Plane Types

class Concorde extends PassangerPlane {
    public Concorde(int Power, int maxPassangers) {
        super(Power, maxPassangers);
    }

    public void goSuperSonic() {
        System.out.println("Supersonic mode activated " + PlaneID);
    }

    public void goSubSonic() {
        System.out.println("Supersonic mode deactivated " + PlaneID);
    }
}

class Boeing extends PassangerPlane {
    public Boeing(int Power, int maxPassangers) {
        super(Power, maxPassangers);
    }
}

class FighterPlane extends Plane {
    public FighterPlane(int Power) {
        super(Power);
    }

    public void launchMissile() {
        System.out.println("Launching rocket " + PlaneID);
    }
}

//Fighter Plane Types

class MIG extends FighterPlane {
    public MIG(int Power) {
        super(Power);
    }

    public void highSpeedGeometry() {
        System.out.println("High speed selected geometry " + PlaneID);
    }

    public void normalGeometry() {
        System.out.println("Normal selected geometry " + PlaneID);
    }
}

class TomCat extends FighterPlane {
    public TomCat(int Power) {
        super(Power);
    }

    public void refuel() {
        System.out.println("TomCat - Refuelling " + PlaneID);
    }
}

class ProblemPlane {

    public static void main(String[] args) {
        Plane p1 = new MIG(100);
        Plane p2 = new MIG(200);
        Plane p3 = new Concorde(200, 250);
        Plane p4 = new TomCat(300);
        Plane p5 = new Concorde(300, 400);
        Plane p6 = new Boeing(100, 150);

        p1.takeOff();
        p2.takeOff();
        ((MIG)p1).highSpeedGeometry();
        ((MIG)p2).normalGeometry();
        System.out.println(((Concorde)p3).getMaxPassangers() + " " + p3.PlaneID);
        p4.land();
        ((TomCat)p4).refuel();
        ((Concorde)p5).goSuperSonic();
        p6.fly();
    }

}
