package ntuc;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {

        int allOrderCount = 0;
        int greaterCount = 0;
        int case3Count = 0;
        boolean isFirstAndLastEqual = true;
        boolean isFirstAndLastEqual1 = true;
        boolean isFirstAndLastEqual2 = true;
        // write your code in Java SE 8
        for(int i=0;i<A.length-1;i++){

            if(A[i] <= A[i+1] ){
                allOrderCount++;

            }

//            if(A[i] < A[i+1] && A[i] <= A[i+2] && A[i+1] > A[i+2]){
//                ++greaterCount;
//                if(A[i] <= A[i+2] && i == A.length - 3 && greaterCount ==1){
//                    isFirstAndLastEqual = true;
//                }
//
//                if(A[i+1] > A[i+2]){
//                    for( int j=i+3;j<A.length-1;j++){
//                        if(A[i+1] <= A[j]){
//                            isFirstAndLastEqual = true;
//                        }
//                    }
//                }
//            }

            if (A[i] > A[i+1]){
                ++greaterCount;

                for( int j=i+2;j<A.length-1;j++) {
                    if (A[i] > A[j]) {
                        isFirstAndLastEqual = false;
                    }
                    if (A[i+1] > A[j]) {
                        isFirstAndLastEqual1 = false;
                    }
                    if (A[i-1] > A[j] && i !=0) {
                        isFirstAndLastEqual2 = false;
                    }
                }
            }



            // if(A[i] < A[i+1] && A[i] > A[i+2] && A[i+1] > A[i+2]){
            //     return 0;
            // }

        }

        if(greaterCount > 1){
            return 0;
        }

        if (isFirstAndLastEqual && isFirstAndLastEqual2 && isFirstAndLastEqual1 && greaterCount == 1){
            return 2;
        }else if ((isFirstAndLastEqual2 && isFirstAndLastEqual1 && !isFirstAndLastEqual) && greaterCount == 1){
            return 1;
        }else if ((isFirstAndLastEqual2 && !isFirstAndLastEqual1 && isFirstAndLastEqual) && greaterCount == 1){
            return 1;
        }else if ((!isFirstAndLastEqual2 && isFirstAndLastEqual1 && isFirstAndLastEqual) && greaterCount == 1){
            return 1;
        }
        else if((!isFirstAndLastEqual && !isFirstAndLastEqual2) && greaterCount == 1){
            return 0;
        }else if((!isFirstAndLastEqual && !isFirstAndLastEqual1) && greaterCount == 1){
            return 0;
        }

        //System.out.println(isFirstAndLastEqual2+""+isFirstAndLastEqual+""+isFirstAndLastEqual1);
        return A.length;



    }
}


/** SQL **/
//-- write your code in PostgreSQL 9.4
//        SELECT m.id,m.title,
//        case
//        when sum(r.number_of_tickets) is null
//        then 0
//        else
//        sum(r.number_of_tickets)
//        end
//        as sold_tickets
//        from reservations r right join movies m on(m.id = r.movie_id) group by m.id,m.title order by sold_tickets desc;