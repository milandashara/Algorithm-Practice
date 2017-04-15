package visa;

/**
 * Created by milanashara on 4/2/17.
 */
public class PlayList {

    static int playlist(String[] songs, int k, String q) {

        int length = Integer.MAX_VALUE;
        for (int i=0;i<songs.length; i++){
                if (songs[i].equals(q)){
                    if (length > Math.abs(i - k)){
                        length = (i-k);
                    }
                }
        }

        if (length < 0){
            length = songs.length - length;
        }

        System.out.print(length);

        return 0;
    }

    public static void main(String arg[]){

        String s[]={"wheniseeyouagain",
                "borntorun",
                "nothingelsematters",
                "cecelia"};

        playlist(s,1,"cecelia");

    }
}
