package com.tzeloonneoh;

public final class LuckyNumberGenerator {

    private LuckyNumberGenerator() {}

    public static int generateNumber(int upperLimit)
    {
        return 1 + (int)(Math.random() * upperLimit);
    }
}
