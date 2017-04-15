package booking;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by milanashara on 4/9/17.
 * Array Chaining
 */
public class Solution4 {

    public static Object[] arrayChaining(String strings[]){

        ArrayList<String> linkedList = new ArrayList<>(strings.length);

        for (int i=0;i<strings.length;i++){
            String s=strings[i].toLowerCase();
            if (linkedList.isEmpty()){
                linkedList.add(s);
            }else {


                if (!linkedList.contains(s)) {
                    for (int j = 0; j < linkedList.size(); j++) {
                        char firstChar = s.charAt(0);
                        char lastChar = s.charAt(s.length() - 1);

                        String tmp = linkedList.get(j);

                        if (tmp.charAt(0) == lastChar){
                            linkedList.add(j,s);
                            break;
                        }else if (tmp.charAt(tmp.length()-1) == firstChar){
                            linkedList.add(j+1,s);
                            break;
                        }

                    }

                    if (!linkedList.contains(s)){
                        linkedList.add(s);
                    }
                }
            }
        }
        return linkedList.toArray();

    }

    public static void main(String arg[]){
        String[] input = {"Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban"};
        Object [] output = arrayChaining(input);
        for (Object s:output){
            System.out.println(s);
        }
    }
}
