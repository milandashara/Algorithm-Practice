package booking;


import java.util.*;

/**
 * Created by milanashara on 4/1/17.
 * Hotel review search
 * Performance improvements needed
 */
public class Solution1 {

    static Map<Long,Long> hotelMap = new HashMap<>();

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        String[] splited = words.split("\\s+");


        Long M = Long.parseLong(in.nextLine().trim());
        for (Long i = 0l;i<M;i++){
            Long hotelId = Long.parseLong(in.nextLine().trim());
            String review = in.nextLine();
            if (hotelMap.get(hotelId) == null){
                hotelMap.put(hotelId,0l);
            }
            for (String search:splited){
                if (review.toLowerCase().contains(search.toLowerCase())){
                    Long count = hotelMap.get(hotelId);
                    count++;
                    hotelMap.put(hotelId,count);
                }
            }
        }


        for (Map.Entry entry:entriesSortedByValues(hotelMap)){
            System.out.print(entry.getKey() + " ");
        }
    }

    static <K,V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Map.Entry<K,V>> sortedEntries = new ArrayList<Map.Entry<K,V>>(map.entrySet());

        Collections.sort(sortedEntries,
                new Comparator<Map.Entry<K,V>>() {
                    @Override
                    public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortedEntries;
    }
}


