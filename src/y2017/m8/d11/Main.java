package y2017.m8.d11;

import java.util.Scanner;

/**
 * @author bo.li
 * @date 2017-08-11 ÉÏÎç10:26:07
 * @version 0.0.1
 * 
 */
public class Main {

	private static int[]array=new int[10000];
	public static void main(String[] args) {
		int m;
		Scanner scanner=new Scanner(System.in);
		while((m=scanner.nextInt())>0) {
			for(int i=0;i<m;i++) {
				array[i]=scanner.nextInt();
			}
			System.out.println(getMaxWight(array,0,m-1));
		}
		scanner.close();
	}
	
	public static int getMaxWight(int[] array,int start,int end) {
		if(end-start<=1) {
			return end-start==0?array[start]:array[start]+array[end];
		}
		for(int i=start+1;i<=end;i++) {
			if(array[start]>array[i]) {
				int temp=array[start];
				array[start]=array[i];
				array[i]=temp;
			}
		}
		for(int i=start+2;i<=end;i++) {
			if(array[start+1]>array[i]) {
				int temp=array[start+1];
				array[start+1]=array[i];
				array[i]=temp;
			}
		}
		int minSum=array[start]+array[start+1];
		array[start+1]=minSum;
		return getMaxWight(array, start+1, end)+minSum;
	}

}
