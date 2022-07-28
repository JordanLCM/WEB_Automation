package singleton_Demo;

public class Singleton {

	private static Singleton singleton = new Singleton();

	public static Singleton getInstance() {
		return singleton;
//		returns the class and the methods in it
	}
	
	public static void demoMethod( ) {
	      System.out.println("demoMethod for singleton");
	   }
}