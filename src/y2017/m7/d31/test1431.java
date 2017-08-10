package y2017.m7.d31;

import java.util.Scanner;
/**
 * AC����:http://ac.jobdu.com/problem.php?pid=1431

��Ŀ������
����n���������밴�Ӵ�С��˳���������ǰm�������
���룺
ÿ��������������У���һ����������n,m(0<n,m<1000000)���ڶ��а���n��������ͬ���Ҷ���������[-500000,500000]��������
�����
��ÿ��������ݰ��Ӵ�С��˳�����ǰm�������
�������룺
5 3
3 -35 92 213 -644
���������
213 92 3
 * @author bo.li
 *
 */
public class test1431 {
	static int[] array=new int[1000000];
	public static void main(String[] args) {
		int m,n;
		Scanner input=new Scanner(System.in);
		while(input.hasNext()) {
			m=input.nextInt();
			n=input.nextInt();
			for(int i=0;i<m;i++) {
				array[i]=input.nextInt();
			}
			sort(m,n);
			for(int i=0;i<n;i++) {
				System.out.println(array[i]);
			}
			System.out.println();
			quikSort(array,0,m-1);
			for(int i=0;i<n;i++) {
				System.out.println(array[i]);
			}
			System.out.println();
		}
		input.close();
	}
	
	/*
	 * ѡ������ʵ��
	 */
	public static void sort(int m,int n) {
		int end=m==n?m-1:n;
		for(int i=0;i<end;i++) {
			for(int j=i+1;j<m;j++) {
				if(array[i]<array[j]){
					array[i]^=array[j];
					array[j]^=array[i];
					array[i]^=array[j];
				}
			}
		}
	}
	
	public static void quikSort(int[]array,int left_,int right_) {
		if(left_<right_) {
			int left=left_;
			int right=right_;
			int temp=array[left_];
			while(left<right) {
				while(left<right&&array[right]<=temp) {
					right--;
				}
				
				if(left<right) {
					array[right++]=array[right];
				}
				while(left<right&&array[left]>temp) {
					left++;
				}
				if(left<right) {
					array[left--]=array[right];
				}
			}
			array[left]=temp;
			quikSort(array,left_,left-1);
			quikSort(array,left+1,right);
		}
	}
}
