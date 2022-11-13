class Complex {  
    private double re, im;
    private static int k = 0;

    public Complex(double r, double i) {
        re = r;
        im = i;
    }

    public void Module() {
        double module;
        module = Math.sqrt(re*re + im*im);
        System.out.println("Module is: " +module);
    }

    public void Print() {
        System.out.println("Value is: " +re+ " i*" +im);
        k++;
    }

    public void Sum(Complex n) {
        double re_sum, im_sum;
        re_sum = n.re + re;
        im_sum = n.im + im;
        System.out.println("Sum is: " +re_sum+ " + i*" +im_sum);
    }

    public void CountComplex() {
        System.out.println("The number of times a complex no has been printed is: " +k);
    }
}

class ClientComplex {
    public static void main(String[] args) {
        Complex complex, complex1;
        complex = new Complex(1,2);
        complex.Print();

        complex.Module();
        //complex.Sum(2, 3, 4, 5);
        complex.CountComplex();

        complex1 = new Complex(2, 3);
        complex.Sum(complex1);
        
    }
}
