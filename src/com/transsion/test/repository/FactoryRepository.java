package com.transsion.test.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * @author {2016521xiaoli@gmail.com}
 * @date 2017-09-06 ÏÂÎç6:48:10
 * @version 0.0.1
 * 
 */
public class FactoryRepository<E>{
	
	private static volatile Map<String,?> repositories=null;
	
	
	FactoryRepository(){
		if(repositories==null) {
			repositories=new HashMap<String,Queue<E>>();
		}
	}
	
    public void put(String key,E item) {
    	
    }
    
    public void put(String key,List<E> itemList) {
    	
    }
	
	public static void main(String[] args) {
//		for(int i=0;i<10000;i++) {
//			CardRepository<String> re=new CardRepository<String>();
//		}
	}
}

class FacotryCloset<E>{
	
	private volatile List<E> emptyCloset;
	private volatile List<E> hotCloset;
	private volatile List<E> coldCloset;
	
	public FacotryCloset() {
		emptyCloset=new ArrayList<E>();
		hotCloset=new ArrayList<E>();
		coldCloset=new ArrayList<E>();
	}
}
