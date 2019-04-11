import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet ss = new TreeSet<Test>();
        ss.add(new Test(0));
        ss.add(new Test(0));

        System.out.println(((TreeSet) ss).first().hashCode());
        "".indexOf(1);
        Integer.valueOf(1);
    }

    static class Test implements Comparable<Test>
    {
        public Integer i = 0;

        public Test(Integer i) {
            this.i = i;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        public int compareTo(Test o) {
            return this.i.compareTo(o.i);
        }

        @Override
        public String toString() {
            return "i=" + i;
        }
    }
}
