package xyz.grafgeest;


import java.util.Objects;

public class NotNull {
    public static void test(@javax.validation.constraints.NotNull String arg) {
        Objects.requireNonNull(arg, "arg must not be null");
        System.out.println(arg);
    }

}
