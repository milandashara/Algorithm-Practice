package kelly;

/**
 * Created by mukesh on 4/6/17.
 */
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Main {

    private static List<String> rules = new ArrayList<String>(6);
    private static Map<String,String> ruleMap = new HashMap<String,String>();

    static{
        rules.add("AB");
        rules.add("BA");
        rules.add("CB");
        rules.add("BC");
        rules.add("AA");
        rules.add("CC");

        ruleMap.put("AB","AA");
        ruleMap.put("BA","AA");
        ruleMap.put("CB","CC");
        ruleMap.put("BC","CC");
        ruleMap.put("AA","A");
        ruleMap.put("CC","C");

    }

    public String solution(String S) {
        // write your code in Java SE 8

        while(true){
            List<String> matchingRules = getMatchingRule(S);
            if(matchingRules.size() == 0){
                break;
            }

            //pick random rule
            int random = 0;
            if(matchingRules.size() > 1)
                random = getRandom(0,matchingRules.size());


            String rule = matchingRules.get(random);
            String replaceWith = ruleMap.get(rule);


            S=S.replaceFirst(rule,replaceWith);

        }

        return S;

    }

    public int getRandom(int start,int end){

        return  (start ) + (int)(Math.random()* ( end - start + 1));
    }

    public List<String> getMatchingRule(String str){
        List<String> matchingRules = new ArrayList<String>();

        for(String rule:rules){
            if(str.contains(rule)){
                matchingRules.add(rule);
            }
        }
        return matchingRules;

    }

}