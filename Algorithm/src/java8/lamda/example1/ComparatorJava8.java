package java8.lamda.example1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mukesh on 6/6/17.
 */
public class ComparatorJava8 {

    public static void main(String arg[]){

        //Java 7
        Comparator<Developer> byName = new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        //Java 8 lamda
        Comparator<Developer> byNameJava8 =
                (Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());

        List<Developer> developerList = getDevelopers();

        //Collections.sort(developerList,byName);

        Collections.sort(developerList,byNameJava8);

        System.out.println("After Sort");
        for (Developer developer : developerList) {
            System.out.println(developer);
        }




    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<>();

        result.add(new Developer("mkyong", new BigDecimal("70000")));
        result.add(new Developer("alvin", new BigDecimal("80000")));
        result.add(new Developer("jason", new BigDecimal("100000")));
        result.add(new Developer("iris", new BigDecimal("170000")));

        return result;

    }
}
