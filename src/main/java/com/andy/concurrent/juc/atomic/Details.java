package com.andy.concurrent.juc.atomic;

public class Details {

    volatile int numberTimesInvoked;

    public int getNumberTimesInvoked() {
        return numberTimesInvoked;
    }

    public void setNumberTimesInvoked(int numberTimesInvoked) {
        this.numberTimesInvoked = numberTimesInvoked;
    }

}
