package xyz.grafgeest.concurrency.deadlock.example2;

public class Foo {
    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
