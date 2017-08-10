package y2017.m7.d31;

import java.util.Scanner;

public class Main {
	static int[] array = new int[1000000];

	public static void main(String[] args) {
		int m, n;
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			m = input.nextInt();
			n = input.nextInt();
			for (int i = 0; i < m; i++) {
				array[i] = input.nextInt();
			}

			quikSort(array, 0, m - 1);
			for (int i = 0; i < n - 1; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.print(array[n - 1] + "\n");
			quikSort_(array, 0, m - 1);
			for (int i = 0; i < n - 1; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.print(array[n - 1] + "\n");
		}
		input.close();
	}

	public static void quikSort(int[] array, int left_, int right_) {

		if (left_ < right_) {

			int left = left_, right = right_, temp = array[left_];
			while (left < right) {
				while (left < right && array[right] <= temp)
					right--;
				if (left < right)
					array[left++] = array[right];

				while (left < right && array[left] > temp) 
					left++;
				if (left < right)
					array[right--] = array[left];
			}
			array[left] = temp;
			quikSort(array, left_, left - 1);
			quikSort(array, left + 1, right_);
		}
	}
	
	public static void quikSort_(int[] array, int left, int right) {

		if(left<right) {
			int l=left;
			int r=right;
			int temp=array[l];
			do {
				do {	
				}while(l<r&&array[r--]<=temp);
				if(l<r)
					array[l++]=array[r];
				do {	
				}while(l<r&&array[l++]>=temp);
				if(l<r)
					array[r--]=array[l];
			}while(l<r);
			array[l]=temp;
			quikSort_(array,left,l-1);
			quikSort_(array,l+1,right);
		}
	}
}
