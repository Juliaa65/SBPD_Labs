package Lab4_2;

public class Main4_2 {

    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator(4);
        long primeNumber = primeGenerator.generatePrimeNumber();
        System.out.println("Single prime number: " + primeNumber);
    }
}
