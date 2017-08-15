package y2017.m8.d2;

import java.util.Arrays;
import java.util.Comparator;
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
		Arrays.sort(array);
		for(int a:array) {
			System.out.println(a+"+");
		};
		in.close();
	}
	
	//基数排序
	public static final int BUCKET_HEIGHT=10;
	public static void radixSort(int[] array,int size) {
		int[][] buckets=new int[BUCKET_HEIGHT][size+1];//第一个统计数量
		for(int i=0;i<size;i++) {
			int h=array[i]%10;
			int w=++buckets[h][0];
			buckets[h][w]=array[i];
		}
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
			buckets[i][0]=0;
		}
	}
	
	public static int getNumBits(int num) {
		int numBits=1;
		while((num/=10)>0) {
			numBits++;
		}
		return numBits;
	}
	
    public static final long[] DIVS_LONG={
    		1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000
    		,10000000000L
    		,100000000000L
    		,1000000000000L
    		,10000000000000L
    		,100000000000000L
    		,1000000000000000L
    		,10000000000000000L
    		,100000000000000000L
    		,1000000000000000000L};
    
    /**
     * 获取数字的某一位值
     * @param num 数字
     * @param bit 第几位
     * @return
     */
    public static int getNumBitValue(long num,int bit){
    	return (int)(num/DIVS_LONG[bit]%10);
    }
    
    public static final int[] DIVS_INT={
    		1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
    
    public static int getNumBitValue(int num,int bit){
    	return (num/DIVS_INT[bit]%10);
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
