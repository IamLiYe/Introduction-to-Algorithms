package y2017.m8.d2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Node{
	int begin;
	int end;
}

class NodeSort implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		if(o1.begin==o2.begin)
			return o1.end-o2.end;
		else 
			return o1.begin-o2.begin;
	}
}

public class Main {
	public static Node[] acArray=new Node[100];
	static {
		for(int i=0;i<100;i++)
			acArray[i]=new Node();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int m;
		while((m=in.nextInt())>0) {
			for(int i=0;i<m;i++) {
				acArray[i].begin=in.nextInt();
				acArray[i].end=in.nextInt();
			}
			Arrays.sort(acArray,0,m,new NodeSort());
			int count=0;
			int end=acArray[0].end;
			for(int i=1;end<24&&i<m;i++) {
				
			}
			System.out.println(acArray);
		}
		in.close();
	}
	
}
