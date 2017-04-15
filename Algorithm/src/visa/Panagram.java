package visa;

/**
 * Created by milanashara on 4/2/17.
 */
public class Panagram {

    static String isPangram(String[] strings) {

        StringBuilder result = new StringBuilder();

        for (String s:strings) {

            //remove spaces
            char ch[] = s.toCharArray();
            String nstr = "";
            for (int i = 0; i < s.length(); i++) {
                if (ch[i] != ' ') {
                    nstr = nstr + ch[i];
                }
            }

            if (check(s)){
                result.append("1");
            }else {
                result.append("0");
            }
        }
        return result.toString();

    }

    static boolean check(String str){


        int count=0;
        for(char c='a';c<='z';c++){
            if( (str.indexOf(c)>=0) )
                count++;
        }
        if(count ==26)
            return true;
        else
            return false;
    }


    public static void main(String arg[]){

        String s[]={"wheniseeyouagain",
                "borntorun",
                "nothingelsematters",
                "cecelia"};



    }
}
