import java.io.File;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mukesh on 24/5/17.
 */
class Main {

    public static void main(String arg[]) throws InterruptedException,ParseException{

        Float f = new Float(23.2);
        Double d = new Double("23.35d");

        Helper helper = new Helper();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2017);
        System.out.println(""+calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        int x = 5;
        x = x >> 1;
        Long test = new Long(500L);
        //int a = new Integer(new String("500.00"));
        Locale locale = new Locale("","");
        int c = 9;
        int b = 2;
        float e;

        if (c >= 100);
        if (c  == 9){
            System.out.print("test");
        }else {

        }

        File file = new File("test.txt");
        File backup = new File("test.txt.bak");
        backup.delete();
        file.renameTo(backup); //Location 1

        Integer before = new Integer(25);
        Integer after = ++before == 26?5:new Integer(10);
        System.out.print(after - before);
        Date simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd").parse("2017-10-10");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(simpleDateFormat);
        calendar1.get(Calendar.DAY_OF_MONTH);
        Helper.Inner inner = helper.new Inner();
        List<Integer> integerList = new ArrayList<Integer>();
        for (Object o: integerList){

        }

        Thread thread = new Thread();
        thread.start();
        System.out.print("test 1");
        thread.wait(1000l);
        System.out.print("test 2");



    }

     static class Helper{

        class Inner{
            int data;
        }

    }


}

class Main1{

    public static void main(String arg[]){}

}
