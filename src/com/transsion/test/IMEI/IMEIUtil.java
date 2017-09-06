package com.transsion.test.IMEI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-09-06 ����4:37:05
 * @version 0.0.1
 * 
 */
public class IMEIUtil {
	private static int MAX_IMEI_NUMBER=1000000;
	private static int MIN_IMEI_NUMBER=0;
	private static int DEFAULT_IMEI_CHECKECODE=0;
	public static void produceIMEI(String TAC,int number) {
		
	}
	
	/**
	 * ����IMEIǰ14λ��������У����,�޸ĵ�15λ��У����
	 * @param imei 
	 * @return 0-9��У����
	 */
	private static int []weights= {0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,0};
    private static int getIMEIChecekCode(String imei) {
    	//ISO7064MOD11_2
		int sum=0;
		String temp=imei.substring(0, imei.length()-1);
		for(int i=0;i<temp.length();i++) {
			sum+=(temp.charAt(i)-'0')*weights[i+1];
		}
		System.out.println(sum);
		int  remainder=(11-sum%10)%10;
		return remainder;
	}
	
	
	/**
	 * IMEI�����
	 *1��ǰ6λ��(TAC)��"�ͺź�׼����"��һ�������͡�
	 *2�����ŵ�2λ��(FAC)��"���װ���"��һ�������ء�
	 *3��֮���6λ��(SNR)��"����"��һ���������˳��š�
	 *4�����1λ��(SP)ͨ����"0"��Ϊ�����룬Ŀǰ�ݱ��á�
	 * ���ɴ���ΪbeginSNR��endSNR-1��Χ��IMEI
	 * @param tac ����
	 * @param fac ����
	 * @param beginSNR ��ʼ˳���
	 * @param endSNR ����˳���
	 * @return ���ɵ�imei�б�
	 */
	
	public static List<String> produceIMEIs(String tac,String fac,int beginSNR,int endSNR) {
		if(beginSNR>endSNR) {
			int temp=beginSNR;
			beginSNR=endSNR;
			endSNR=temp;
		}
		int number=endSNR-beginSNR+1;
		beginSNR=beginSNR<MIN_IMEI_NUMBER?MIN_IMEI_NUMBER:beginSNR;
		endSNR=endSNR>MAX_IMEI_NUMBER?MAX_IMEI_NUMBER:endSNR;
		String[] imeis=new String[endSNR-beginSNR];
		for(int i=0;i<(endSNR-beginSNR);i++) {
			imeis[i]=String.format("%S%S%06d",tac.substring(0,6),fac.substring(0,2),i+beginSNR);
			imeis[i]+=getIMEIChecekCode(imeis[i]);
		}
		return new ArrayList<String>(Arrays.asList(imeis));
	}
	
	public static void main(String[] args) {
		List<String> list=produceIMEIs("100861","311",1,10000000);
		list.stream().forEach(str->{System.out.println(str);});
	}
}
