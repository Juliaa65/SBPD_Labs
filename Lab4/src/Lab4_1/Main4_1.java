package Lab4_1;

public class Main4_1 {
    public static void main(String[] args) {

        Long x = 3L;
        Long y = 10L;
        Long p = 17L;

        SHDP shdp = new SHDP(x, y, p);

        Long mod = shdp.fastModularExponentiation();
        System.out.println("Result is " + mod);

    }
}
