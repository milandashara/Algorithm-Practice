package booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by milanashara on 4/15/17.
 *
 * Find Longest substring having non repeated characters from a String
 * Timecomplexity O(1)
 */
public class Solution7 {

    public static void main(String arg[]){
        //String str = "abcadaebfgahigklmnopqrst,bbbbb,abcabcbb,pwwkew";
        String str = "pwwkew";

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,List<Position>> mapPosition = new HashMap<>();
        int maxLength = 0;
        int lastRepeated  = 0;
        int start = 0 ;
        int j = str.length();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);

                if (mapPosition.containsKey(c)){

                    int length =   i - mapPosition.get(c).get((mapPosition.get(c).size()-1)).getI();

                    if (length>maxLength){
                        j=i;
                        start=mapPosition.get(c).get((mapPosition.get(c).size()-1)).getI();
                        lastRepeated = i;
                    }

                    maxLength = Math.max(maxLength, length);


                    mapPosition.get(c).add(new Position(i));


                }
            }else {
                map.put(c,1);
                List<Position> positionList = new ArrayList<Position>();
                positionList.add(new Position(i));


                //if reached last
                if (i==str.length()-1) {
                    if (i - lastRepeated > maxLength) {
                        j = i;
                        start = lastRepeated;
                    }

                    maxLength = Math.max(maxLength, i - lastRepeated);
                }
                mapPosition.put(c,positionList);
            }
        }

//        for (Map.Entry<Character,List<Position>> entry:mapPosition.entrySet()){
//            System.out.println();
//            System.out.println(entry.getKey()+":" +entry.getValue());
//        }
//
//        for (Map.Entry entry:map.entrySet()){
//            System.out.println();
//            System.out.println(entry.getKey()+":" +entry.getValue());
//        }
//
//        System.out.println(maxLength);
//        System.out.println(start);
//        System.out.println(j);

        System.out.println(str.substring(start,j));

    }


}

 class Position{
    int i;

    public Position(int i) {
        this.i = i;
    }

     public int getI() {
         return i;
     }

     @Override
     public String toString() {
         return "Position{" +
                 "i=" + i +
                 '}';
     }
 }
