package y2017.m8.d1;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test1433 {

	static int[] javaBeans=new int[1000];
	static int[] catFood=new int[1000];
	static double[] value=new double[1000];
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int m,n;
		while((m=input.nextInt())>0){
			n=input.nextInt();
			for(int i=0;i<n;i++){
				javaBeans[i]=input.nextInt();
				catFood[i]=input.nextInt();
				value[i]=(double)javaBeans[i]/catFood[i];
			}
			quikSort_(javaBeans,catFood,0,n-1);
			for(int i=0;i<n;i++) {
				System.out.printf("%d %d\n",javaBeans[i],catFood[i]);
			}
			System.out.printf("%.3f\n",getBeans(m, n));
			System.out.printf("%.3f\n",getBeans_(m, n).doubleValue());
		}
		input.close();
	}
	
	public static BigDecimal getBeans_(int food,int n) {
		int beans=0;
		int i=0;
		for(;i<n&&food>catFood[i];i++) {
			beans+=javaBeans[i];
			food-=catFood[i];
		}
		if(i<n) {
			BigDecimal javaBean=new BigDecimal(Integer.valueOf(javaBeans[i]*food));
			javaBean=javaBean.divide(new BigDecimal(Integer.valueOf(catFood[i])),3,BigDecimal.ROUND_DOWN);
			return javaBean.add(new BigDecimal(beans));
		}
		return new BigDecimal(beans);
	}
	
	public static double getBeans(int food,int n) {
		double beans=0.0;
		int i=0;
		for(;i<n&&food>catFood[i];i++) {
			beans+=javaBeans[i];
			food-=catFood[i];
		}
		if(i<n) {
			double value=(double)(javaBeans[i]*food)/catFood[i];
			beans+=value;
		}
		return beans;
	}
	static  double getMaxJavaBean(int m,int n){
		double javaBean=0.0;
		
		return javaBean;
	}
	
	static void sort(int[] javaBeans,int[] catFood, int left_, int right_) {
		
		if (left_ < right_) {

			int left = left_, right = right_, tempBean = javaBeans[left_],tempFood=catFood[left_];
			double tempValue=(double)tempBean/tempFood;
			while (left < right) {
				while (left < right && (double)javaBeans[right]/catFood[right] <= tempValue)
					right--;
				if (left < right) {
					javaBeans[left] = javaBeans[right];
					catFood[left++] = catFood[right];
				}
				while (left < right && (double)javaBeans[right]/catFood[right] >=tempValue) 
					left++;
				if (left < right) {
					javaBeans[right] = javaBeans[left];
					catFood[right--] = catFood[left];
				}	

			}
			javaBeans[left] = tempBean;
			sort(javaBeans,catFood, left_, left - 1);
			sort(javaBeans,catFood, left + 1, right_);
		}
	}
	
	static void quikSort_(int[] javaBeans,int[] catFood, int left, int right) {

		if(left<right) {
			int l=left;
			int r=right;
			int tempBean=javaBeans[l];
			int tempFood=catFood[l];
			double temp=value[l];
			do {
				while(l<r) {
					 if(value[r]>temp)
						 break;
					 r--;
				}
				if(l<r)
				{
					javaBeans[l] = javaBeans[r];
					catFood[l]=catFood[r];
					value[l]=value[r];
					l++;
				}
				while(l<r) {
					if(value[l]<temp)
						break;
					l++;
				}
				if(l<r)
				{
					javaBeans[r] = javaBeans[l];
					catFood[r]=catFood[l];
					value[r]=value[l];
					r--;
				}
					
			}while(l<r);
			javaBeans[l]=tempBean;;
			catFood[l]=tempFood;
			value[l]=temp;
			quikSort_(javaBeans,catFood,left,l-1);
			quikSort_(javaBeans,catFood,l+1,right);
		}
	}

}


