package visa;

import java.util.*;

/**
 * Created by milanashara on 3/5/17.
 */
public class ArrayReduction {

    public static int reductionCost(int[] num) {
        Arrays.sort(num);
        List<Integer> intList = new ArrayList<>();
        for (int index = 0; index < num.length; index++)
        {
            intList.add(num[index]);
        }

        List<Integer> costList = new ArrayList<>();
        int cost = 0;



        for (int i =0;i<num.length-1;i++){

            cost =  intList.get(0)+ intList.get(1);

            try{

                intList.remove(0);
                intList.remove(0);
            }catch (Exception e){

            }

            //intList.add(0,cost);
            intList = insert(cost,intList);

            costList.add(cost);
        }
        int sum=0;
        for(Integer costInt:costList){
            sum = sum + costInt;
        }

        return sum;


    }
    public static int reductionCost1(int[] num) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int index = 0; index < num.length; index++){
            queue.offer(num[index]);
        }
        int sum = 0;
        while (queue.size()>1){
            int first = queue.poll();
            int second = queue.poll();
            sum += first + second;
            queue.offer( first + second);
        }
        return sum;

    }

    public static List<Integer> insert(int val,List<Integer> arr){
        int i;
        for(i=0;i<arr.size()-1;i++){
            if(arr.get(0)>val)
                break;
        }
        for(int k=arr.size()-2; k>=i; k--){

            arr.add(k+1,arr.get(k));
        }
        arr.add(i,val);
        return arr;

    }

    public static void main(String arg[]){
        int[] ints = {3,1,2,4,5};
        //System.out.println(reductionCost(ints));
        System.out.println(reductionCost1(ints));

    }
}
