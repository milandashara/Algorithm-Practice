package amazon;

public class StringComparision {

        public String solution(String S, String T) {
            // write your code in Java SE 8

            if (S == T){
                return "NOTHING";
            }
            int diff = Math.abs(S.length() - T.length());
            if (diff > 1){
                return "IMPOSSIBLE";
            }

            // INSERT OR DELETE

                // INSERT
                if (S.length() + 1 == T.length()){

                    int i = 0;
                    for (char c:T.toCharArray()){
                        if (c != S.charAt(i)) {
                            return "INSERT "+c;
                        }
                        i++;
                    }

                }

                //REMOVE
                else if(S.length() == T.length() + 1){

                    int i = 0;
                    for (char c:S.toCharArray()){
                        if (c != T.charAt(i)) {
                            return "REMOVE "+c;
                        }
                        i++;
                    }

                }



            // Move
            if (diff == 0){
                int i = 0;
                for (char c:S.toCharArray()){
                    if (c != T.charAt(i)) {
                        return "MOVE "+c;
                    }
                    i++;
                }
            }

            return "ERROR";

        }

}
