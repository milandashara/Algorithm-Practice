package rakuten;

import java.util.*;

/**
 * @author milan
 */
public class Main {



    public static void main(String a[]){


        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        List<Interval> intervals = new ArrayList<>();
        for (int i=0;i<count;i++){
            String s[] = scanner.nextLine().split("\\s");

            Interval interval = new Interval(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            intervals.add(interval);

        }

        //sort by start time

        Collections.sort(intervals);

//        for (Interval i:intervals){
//            System.out.println(i.start+ " "+i.end);
//        }



        int singles = getSingles(intervals);
        int doubles = getDoubles(intervals);
        System.out.println(singles+ " "+doubles);

    }

    public static int getSingles(List<Interval> intervals){


        Integer s = null;
        Integer e = null;
        int singles = 0;
        for (int i=0;i< intervals.size()-1;i++){

            Interval interval = intervals.get(i);

            s =  interval.start;
            e =  interval.end;

            //for (int j=i;j< i+2;j++){

                Interval interval1 = intervals.get(i+1);

                int s1 = interval1.start;
                int e1 = interval1.end;


                if (s1 < e ) {
                    singles = singles + Math.min(e, e1) - Math.max(s, s1);
                }
//                else {
//                    break;
//                }

            //}


        }

        return singles;

    }

    public static int getDoubles(List<Interval> intervals){


        Integer s1 = null;
        Integer e1 = null;

        Integer s2 = null;
        Integer e2 = null;

        Integer s3 = null;
        Integer e3 = null;

        Integer s4 = null;
        Integer e4 = null;

        Integer s5 = null;
        Integer e5 = null;
        int doubles = 0;

        if (intervals.size()<4){
            return doubles;
        }



        for (int i = 0;i<intervals.size()-3;i++){
            Interval interval1 = intervals.get(i);
            Interval interval2 = intervals.get(i+1);
            Interval interval3 = intervals.get(i+2);
            Interval interval4 = intervals.get(i+3);
            //Interval interval5 = intervals.get(i+4);


                s1 = interval1.start;
                e1 = interval1.end;

                s2 = interval2.start;
                e2 = interval2.end;

                s3 = interval3.start;
                e3 = interval3.end;

                s4 = interval4.start;
                e4 = interval4.end;

//                s5 = interval5.start;
//                e5 = interval5.end;


                if (s2 < e1 && s2 < e2 && s2 < e3 && s3 < e1 && s3 < e2 && s3 < e3 && s4 < e1 && s4 < e2 && s4 < e3 ) {
                    doubles = doubles +  ((Math.min(Math.min(e1-s2, e2-s3),e3-s4)));
                }





        }

        return doubles;

    }
}

class Interval implements Comparable<Interval>{
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Interval o)
    {
        return(start - o.start);
    }

}
