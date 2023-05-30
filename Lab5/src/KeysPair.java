import java.math.BigInteger;
import java.util.Random;

public class KeysPair {

    private BigInteger n;
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger p1;
    private BigInteger p2;
    private int bitLength;
    private BigInteger phi;

    public BigInteger getN() {
        return n;
    }

    public BigInteger getPrivateKey() {
        return generateDForPrivateKey();
    }

    public BigInteger getPublicKey() {
        return generateEForPublicKey();
    }

    public KeysPair(int bitLength) {
        this.bitLength = bitLength;
        this.p1 = generatePrimeNumber();
        this.p2 = generatePrimeNumber();
        this.n = p1.multiply(p2);
        this.phi = calculatePhi();
    }


    public BigInteger generatePrimeNumber() {
        Random random = new Random();
        return BigInteger.probablePrime(bitLength / 2, random);
    }


    public BigInteger calculatePhi() {
        return p1.subtract(BigInteger.ONE).multiply(p2.subtract(BigInteger.ONE));
    }


    public BigInteger generateEForPublicKey() {
        BigInteger e = BigInteger.TWO;
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        return e;
    }


    public BigInteger generateDForPrivateKey() {
        return generateEForPublicKey().modInverse(phi);
    }
}
