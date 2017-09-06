package com.transsion.test.IMEI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-09-06 下午4:37:05
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
	 * 根据IMEI前14位数字生成校验码,修改第15位的校验码
	 * @param imei 
	 * @return 0-9的校验码
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
	 * IMEI的组成
	 *1、前6位数(TAC)是"型号核准号码"，一般代表机型。
	 *2、接着的2位数(FAC)是"最后装配号"，一般代表产地。
	 *3、之后的6位数(SNR)是"串号"，一般代表生产顺序号。
	 *4、最后1位数(SP)通常是"0"，为检验码，目前暂备用。
	 * 生成串号为beginSNR到endSNR-1范围的IMEI
	 * @param tac 机型
	 * @param fac 产地
	 * @param beginSNR 起始顺序号
	 * @param endSNR 结束顺序号
	 * @return 生成的imei列表
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
