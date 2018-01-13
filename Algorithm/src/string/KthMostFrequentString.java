//package string;
//
//import java.util.*;
//
///**
// * Created by mukesh on 18/6/17.
// */
//public class KthMostFrequentString {
//
//    public String kthMostFrequentRecurringString(String[] strings,int k){
//
//        HashMap<String,Integer> hashMap = new HashMap<>();
//
//        for (String s:strings){
//            Integer x = hashMap.get(s);
//            if (x == null)
//                x = 0;
//
//            hashMap.put(s,++x);
//        }
//        List<Map.Entry> list = new ArrayList<>(hashMap.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry>() {
//            @Override
//            public int compare(Map.Entry o1, Map.Entry o2) {
//               return ((Integer)(o1.getValue())).compareTo(((Integer)o2.getValue()));
//            }
//        });
//
//        if (list.size() < k) return (String)list.get(k).getKey();
//
//        return null;
//
//    }
//
//}
