package zalando;


public class Main {

    public static String solution(int[] T) {
        // write your code in Java SE 8
        int numOfDaysPerSeason = T.length / 4;
        int winterAmplitude = findAmplitude(0,numOfDaysPerSeason,T);
        int springAplitude =findAmplitude(numOfDaysPerSeason,numOfDaysPerSeason*2,T);
        int sumerAplitude =findAmplitude(numOfDaysPerSeason*2,numOfDaysPerSeason*3,T);
        int automAplitude =findAmplitude(numOfDaysPerSeason*3,numOfDaysPerSeason*4,T);

        int maxAmplitude = Math.max(Math.max(Math.max(winterAmplitude,springAplitude),sumerAplitude),automAplitude);

        if (maxAmplitude == winterAmplitude){
            return "WINTER";
        }
        if (maxAmplitude == springAplitude){
            return "SPRING";
        }
        if (maxAmplitude == sumerAplitude){
            return "SUMMER";
        }

        return "AUTUMN";


    }

    public static int findAmplitude(int start,int end,int[] T){
        System.out.printf("start %s end %s \n:",start,end);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            min = Math.min(T[i],min);
            max = Math.max(T[i],max);
        }
        return Math.abs(max-min);
    }

    public static void main(String s[]){
        int[] T = {2, 1, 1, 10, 2, 13, 3, -18};
        System.out.println(solution(T));

    }

    public String solution(int A, int B) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        int aCount = 0;
        int bCount = 0;

        if(A == 0 && B == 0){

        }
        else if(A == 1 && B == 0){
            sb.append("a");
        }
        else if(A == 0 && B == 1){
            sb.append("a");
        }
        else if (A == 1 && B == 1){
            sb.append("b");
        }

        else if (A >= B){
            sb.append("a");
            sb.append("a");
            aCount++;
            aCount++;
            for (int i = 2;i<A+B;i++){

                if (sb.charAt(i-1) == 'a' && sb.charAt(i-2) == 'a' && bCount < B){
                    sb.append("b");
                    bCount++;
                }else if (aCount < A){
                    sb.append("a");
                    aCount++;
                }else if (bCount < B){
                    sb.append("b");
                    bCount++;
                }
            }
        }
        else {
            sb.append("b");
            sb.append("b");
            bCount++;
            bCount++;
            for (int i = 2;i<A+B;i++){

                if (sb.charAt(i-1) == 'b' && sb.charAt(i-2) == 'b' && aCount < A){
                    sb.append("a");
                    aCount++;
                }else if (bCount < B){
                    sb.append("b");
                    bCount++;
                }else if (aCount < A){
                    sb.append("a");
                    aCount++;
                }
            }
        }
        return sb.toString();
    }
}

