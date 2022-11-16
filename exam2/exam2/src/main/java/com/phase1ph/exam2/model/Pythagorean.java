package com.phase1ph.exam2.model;


public class Pythagorean {
    private int a;
    private int b;
    private int c;
    private float average;


    public Pythagorean() {
        super();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return  "A-" + a +
                "\nB-" + b +
                "\nC-" + c +
                "\nAVG-" + average;
    }
}
