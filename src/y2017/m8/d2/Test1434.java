package y2017.m8.d2;

import java.util.Scanner;

public class Test1434 {
	static int[] Ti_S=new int[100];
	static int[] Ti_E=new int[100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int m;
		int[]array= {9,3,1,5,0,2,5,6,8,7,8,4,1,3,6,3,55,89,34,20};
		radixSort(array, 20);
		System.out.println(array.toString());
		for(int a:array) {
			System.out.println(a+",");
		}
		while((m=in.nextInt())>0) {
			for(int i=0;i<m;i++) {
				Ti_S[i]=in.nextInt();
				Ti_E[i]=in.nextInt();
			}
		}
	}
	public static final int BUCKET_HEIGHT=10;
	
	public static void radixSort(int[] array,int size) {
		int[][] buckets=new int[BUCKET_HEIGHT][size+1];//第一个统计数量
		for(int i=0;i<size;i++) {
			int h=array[i]%10;
			int w=++buckets[h][0];
			buckets[h][w]=array[i];
		}
		for(int i=0;i<BUCKET_HEIGHT;i++)
			buckets[i][0]=0;
		readRdixArray(buckets, array, size);
	}
	
	public static void readRdixArray(int[][] buckets,int[]array,int size) {
		int count=0;
		for(int i=0;count<size&&i<BUCKET_HEIGHT;i++) {
			int width=buckets[i][0];
			int w=1;
			while(width-->0) {
				array[count++]=buckets[i][w++];
			}
		}
	}
	
	public static int getNumBits(int num) {
		int numBits=1;
		while((num/=10)>0) {
			numBits++;
		}
		return numBits;
	}
	
	public static int getMaxNum(int[] array,int size) {
		int max=array[0];
		for(int i=1;i<size;i++) {
			if(max<array[i])
				max=array[i];
		}
		return max;
	}
}
