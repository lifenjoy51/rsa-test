package main;

import java.math.BigInteger;

/**
 * Created by lifenjoy51 on 2016-05-24.
 */
public class RSATest {

    public static void main(String[] args) {
        RSA rsa = new RSA(15);  //14부터 느려짐.
        PublicKey publicKey = rsa.getPublicKey();
        PrivateKey privateKey = rsa.getPrivateKey();

        BigInteger plain = BigInteger.valueOf(123456);
        System.out.println("plain text : \t" + plain);
        BigInteger encrypted = encrypt(plain, publicKey.E, publicKey.N);
        System.out.println("encrypted string : \t" + encrypted);
        BigInteger decrypted = decrypt(encrypted, privateKey.D, privateKey.N);
        System.out.println("decrypted string : \t" + decrypted);
    }

    /**
     * 암호화.
     *
     * @param plain
     * @param E
     * @param N
     * @return
     */
    static BigInteger encrypt(BigInteger plain, BigInteger E, BigInteger N) {
        return plain.modPow(E, N);
    }

    /**
     * 복호화.
     *
     * @param enctypted
     * @param D
     * @param N
     * @return
     */
    static BigInteger decrypt(BigInteger enctypted, BigInteger D, BigInteger N) {
        return enctypted.modPow(D, N);
    }


}
