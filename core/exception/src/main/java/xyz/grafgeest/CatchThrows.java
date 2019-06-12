package xyz.grafgeest;

public class CatchThrows {

    public String test(){
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        } finally {
            return "finally";
        }
    }

    public String test2(){
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        } finally {
            throw new NullPointerException();
        }
    }

}
