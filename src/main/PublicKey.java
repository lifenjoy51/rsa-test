package main;

import java.math.BigInteger;

class PublicKey {

    BigInteger E;
    BigInteger N;

    public PublicKey(BigInteger e, BigInteger n) {
        E = e;
        N = n;
    }
}