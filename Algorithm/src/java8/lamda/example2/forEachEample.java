package java8.lamda.example2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mukesh on 6/6/17.
 */
public class forEachEample {

    public static void main(String arg[]){
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((key,value) -> {
            System.out.println(key +","+value);
        });


        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");

//lambda
//Output : A,B,C,D,E
        stringList.forEach((item)->{
            System.out.println(item);
        });

        //Stream and filter

        //Stream is sequence of elements supporting sequential or parallel aggregate functions
//Output : B
        stringList.stream()
                .filter(s->s.contains("B"))
                .forEach(System.out::println);
    }
}
