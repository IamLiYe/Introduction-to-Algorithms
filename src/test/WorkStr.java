package test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-08-19 обнГ2:42:01
 * @version 0.0.1
 * 
 */
public class WorkStr {
	public static void main(String[] args) {
		printMemberCards(System.out);
	}
	
	public static void printSouHou() {
		for(int i=0;i<10000;i++)
			System.out.println("1708190501"+fiilZero(i,5));
	}
	public static String fiilZero(int i,int width) {
		String str="%0"+width+"d";
		return new String(String.format(str,i));
	}
	
	public static void printMemberCards(PrintStream os) {
		for(int i=0;i<5000;i++)
			System.out.println("11120824"+fiilZero(i,4));
	}
}
