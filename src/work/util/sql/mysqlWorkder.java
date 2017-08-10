package work.util.sql;

import java.util.List;
import java.util.Scanner;

import javax.xml.transform.Source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

class Entry{
	String name="";
	String type="";
	String detial="";
	boolean isNull=true;
}

public class mysqlWorkder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//splitSqlStr(System.in);
		updateReplace("e:\\1.txt","e:\\2.txt",
				new PrintWriter(new OutputStreamWriter(new FileOutputStream("e:\\5.txt"),"UTF-8")));
	}



	public static void splitSqlStr(InputStream in) {
		List<Entry> entries=new ArrayList<Entry>();
		Scanner input=new Scanner(in);
		String[]strs;
		while(input.hasNext()) {
			strs=input.nextLine().split(" ");
			strs[2]=strs[2].replaceAll("`","");
//			strs[3]=strs[3].replaceAll("(","");
//			strs[3]=strs[3].replaceAll(")","");
//			strs[3]=strs[3].replaceAll("6","");
//			strs[3]=strs[3].replaceAll("8","");
//			strs[3]=strs[3].replaceAll("1","");
//			strs[3]=strs[3].replaceAll("2","");
			
			System.out.println(strs[2]);
			
		}
	}
	
	public static void updateReplace
	(String file1,String file2 ,PrintWriter out) throws IOException {
		BufferedReader reader1=new BufferedReader(new InputStreamReader(new FileInputStream(file1),"UTF-8"));
		BufferedReader reader2=new BufferedReader(new InputStreamReader(new FileInputStream(file2),"UTF-8"));
		List<String> sources=new ArrayList<String>();
		String string=null;
		int count=0;
		while((string=reader1.readLine())!=null) {
			//System.out.println(string);
			//out.println(string);
			sources.add(string);
			count++;
		}
		System.out.println(count);
		count=0;
		
		while((string=reader2.readLine())!=null) {
			//System.out.println(string);
			//out.println(string);
			String str=null;
			if(sources.get(count).lastIndexOf("`ENNAME`=''")>=0) {
				str=sources.get(count).replaceFirst("`ENNAME`=''","`ENNAME`='"+string+"'");
			}
			if(sources.get(count).lastIndexOf("`ENNAME`=NULL")>=0) {
				str=sources.get(count).replaceFirst("`ENNAME`=NULL","`ENNAME`='"+string+"'");
			}
			out.println(str);
			//sources.add(string);
			count++;
		}
		System.out.println(count);
		reader1.close();
		reader2.close();
		out.flush();
		out.close();
	}
}
