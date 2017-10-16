package com.transsion.test.IMEI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.aop.TargetSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-09-06 下午4:37:05
 * @version 0.0.1
 * 
 */

public class IMEIUtil {
	
	public static String TEST_STRING="parm=2342593&";
	private static int MAX_IMEI_NUMBER=1000000;
	private static int MIN_IMEI_NUMBER=0;
	private static int DEFAULT_IMEI_CHECKECODE=0;
	static ShaPasswordEncoder passwordEncoder=new ShaPasswordEncoder();
	
    private static void  encoder(String userName,String userPassword) {
    	String rowPassword=passwordEncoder.encodePassword(userPassword,userName);
    	System.out.println("rowPassword");
    	String algorithm=passwordEncoder.getAlgorithm();
    	System.out.println(algorithm);
    	if(passwordEncoder.isPasswordValid(rowPassword,userPassword,userName))
    		System.out.println("OK");
    }
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
		//List<String> list=produceIMEIs("100861","311",1,10000000);
		//list.stream().forEach(str->{System.out.println(str);});
		//randSeq();
//		String stringX="110";
//		String string="110";
//		String stringTemp="110";
//		string=simpleEncryption(string);
//		System.out.println(string);
//	    stringTemp=simpleDencryption(string);
//		System.out.println(stringTemp);
//		System.out.println(stringX.equals(stringTemp));
		//encoder("superAdmin","549412608sad");
		System.out.println(new Date(System.currentTimeMillis()).toString());
		
	}
	
	private static final char[][] passwordTable = {
			{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
					'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E',
					'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
					'Z' },
			{ 'H', 'm', '0', 'p', 'W', 'M', 'z', '7', 'y', 'P', 'r', 'w', 'h', 'g', 'T', 'u', 'U', 'f', 'k', '8', '5',
					'B', 'L', '6', 'I', 'x', 'E', 'q', 'G', 't', 'v', 'F', 'O', 'C', 'K', 'Q', 'S', 'N', 'o', 'R', 'D',
					'i', '9', 'X', 'n', '4', 'b', '3', 'Y', 'A', 'V', 'l', 'J', '1', 'j', 'a', 'Z', 'e', '2', 's', 'd',
					'c' } };
	private static String simpleEncryption(String password) {
		String srcSep=String.valueOf(passwordTable[0]);
		String destSep=String.valueOf(passwordTable[1]);
	    char[] encryPassword=password.toCharArray();
	    for(int i=0;i<password.length();i++) {
	    	 int index=srcSep.lastIndexOf(encryPassword[i]);
	    	 if(index>=0) {
	    		 encryPassword[i]=destSep.charAt(index);
	    	 }
	    }
		return String.valueOf(encryPassword);
	}
	
	private static String simpleDencryption(String password) {
		String srcSep=String.valueOf(passwordTable[1]);
		String destSep=String.valueOf(passwordTable[0]);
	    char[] encryPassword=password.toCharArray();
	    for(int i=0;i<password.length();i++) {
	    	char ch=encryPassword[i];
	    	int index=srcSep.lastIndexOf(encryPassword[i]);
	    	if(index>=0) {
	    		encryPassword[i]=destSep.charAt(index);
	    	}
	    }
		return String.valueOf(encryPassword);
	}
	
	public static void randSeq() {
		char[] x = {'0','1','2','3','4','5','6','7','8','9','#','@','!','*','`','_','<','>','(',')','%','$','/','?'
				,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
				,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};    
        List<Character> list = new ArrayList<Character>();   
        List<Character> randlist = new ArrayList<Character>();   
        for(int i = 0;i < x.length;i++){    
            System.out.print(x[i]+", ");    
            list.add(x[i]);
            randlist.add(x[i]);
        }    
        System.out.println();    
            
        Collections.shuffle(randlist);    
            
        Iterator<Character> ite = list.iterator();
        Iterator<Character> rite = randlist.iterator(); 
        System.out.println("{");
        System.out.println("{");
        while(ite.hasNext()){    
            System.out.print("'"+ite.next().toString()+"',");  
        }
        System.out.println("}");
        System.out.println("{");
        while(rite.hasNext()){    
            System.out.print("'"+rite.next().toString()+"',");  
        }
        System.out.println("}");
        System.out.println("}");
        System.out.println(randlist.size());
	}
}
