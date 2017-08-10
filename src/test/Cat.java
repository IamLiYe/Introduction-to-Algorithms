package test;

import java.io.File;
import java.util.Scanner;

public class Cat{
	public static void main(String[] agrs){
		
			Scanner in=new Scanner(System.in);
			int i=0;
			Cat3 cat=new Cat3();
			while(i>-1) {
				try {
					i=in.nextInt();
					//System.out.print(i);
					cat.getException(i);
				}
				catch(MyException e) {
					System.out.println(e.getMessage());
				}
				A :System.out.println("Hello World");
				
			}
	}
}


class Cat2{
	public void createException(int i) throws MyException {
		if(i<10&&i>0) {
			return;
		}
		else 
			throw new MyException(1,"test.cat.cat2.resultException:i is illegal");
	}
}

class Cat3{
	public void getException(int i) throws MyException{
	   Cat2 cat=new Cat2();
	   cat.createException(i);
	}
}

class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String message;
	
	public MyException(int id,String message) {
		this.id=id;
		this.message=message;
	}
	
	public String getMessage() {
		return new String("["+this.id+"]:"+this.message);
	}
}
