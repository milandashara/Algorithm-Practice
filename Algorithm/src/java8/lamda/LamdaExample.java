package java8.lamda;

/**
 * Created by mashara on 29/10/17.
 */

@FunctionalInterface
interface Executable{
	int execute(int a,int b);
	//int another();
}

class Runner{

	public int run(Executable executable){
		System.out.println("inside runner");
		return executable.execute(12,13);
	}
}
public class LamdaExample {

	public static void main(String arg[]){
		new Runner().run((a,b)->{System.out.println("test");return a+b;});
	}
}
