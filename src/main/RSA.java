package main;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by lifenjoy51 on 2016-05-24.
 */
public class RSA {

    private static int BIT_LENGTH;
    BigInteger p;
    BigInteger q;
    BigInteger N;
    BigInteger L;
    BigInteger E;
    BigInteger D;

    RSA(int bitLength) {

        BIT_LENGTH = bitLength;

        // p�� q ���� ����.
        // p,q�� �Ҽ�.
        //p = new Random().int
        p = getRandomPrimeNumber();
        q = getRandomPrimeNumber();
        N = p.multiply(q);

        // L�� ���Ѵ�.
        // L = lcm(p-1, q-1)
        L = lcm(p.add(BigInteger.ONE.negate()), q.add(BigInteger.ONE.negate()));

        // E�� ���Ѵ�.
        // 1<E<L
        // gcd(E,L)=1
        E = BigInteger.valueOf(2);
        for (; E.compareTo(L) < 0; E = E.add(BigInteger.ONE)) {
            //System.out.println("E : " + E);
            if (E.gcd(L).equals(BigInteger.ONE)) {
                break;
            }
        }

        // D�� ���Ѵ�.
        // 1<D<L
        // E*D mod L = 1
        D = BigInteger.valueOf(2);
        for (; D.compareTo(L) < 0; D = D.add(BigInteger.ONE)) {
            //System.out.println("D : " + D + "\t" + E.multiply(D).mod(L));
            if (E.multiply(D).mod(L).equals(BigInteger.ONE)) {
                break;
            }
        }

        // logs
        System.out.println("p : " + p);
        System.out.println("q : " + q);
        System.out.println("N : " + N);
        System.out.println("L : " + L);
        System.out.println("E : " + E);
        System.out.println("D : " + D);
    }

    /**
     * ���� �Ҽ� ����.
     *
     * @return
     */
    BigInteger getRandomPrimeNumber() {
        return BigInteger.probablePrime(BIT_LENGTH, new Random(System.nanoTime()));
    }

    /**
     * �ּ� �����
     *
     * @param a
     * @param b
     * @return
     */
    BigInteger lcm(BigInteger a, BigInteger b) {
        //System.out.println("lcm : " + a + " , " + b);
        return a.multiply(b).divide(a.gcd(b));
    }

    /**
     * ����Ű ��ȯ
     *
     * @return
     */
    PublicKey getPublicKey() {
        PublicKey publicKey = new PublicKey(E, N);
        return publicKey;
    }

    /**
     * ����Ű ��ȯ.
     *
     * @return
     */
    PrivateKey getPrivateKey() {
        PrivateKey privateKey = new PrivateKey(D, N);
        return privateKey;
    }
}
