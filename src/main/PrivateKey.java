package main;

import java.math.BigInteger;

class PrivateKey {

    BigInteger D;
    BigInteger N;

    public PrivateKey(BigInteger d, BigInteger n) {
        D = d;
        N = n;
    }
}