class DivisionIsZero extends Exception {
    public DivisionIsZero() {
        super("Division cannot be computed!");
    }
}

class Division {
    private int number;
    private int divisor;

    public Division(int number, int divisor) {
        this.number = number;
        this.divisor = divisor;
    }

    public int performDivision() throws DivisionIsZero{
        if(divisor == 0)
            throw new DivisionIsZero();
        return number/divisor;
    }
}

public class DivisionClient {
    public static void main(String[] args) {
        Division d1 = new Division(10, 0);
        Division d2 = new Division(10, 2);
        try {
            System.out.println(d1.performDivision());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(d2.performDivision());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
