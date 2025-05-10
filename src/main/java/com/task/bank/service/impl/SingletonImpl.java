package com.task.bank.service.impl;

import java.io.Serializable;



public class SingletonImpl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1415855400879950685L;
	private static SingletonImpl instance ;
	
	//By constructor
	private SingletonImpl() {
		
	}
	
	
	//By clone
	@Override
	protected Object clone()throws CloneNotSupportedException{
		
		throw new CloneNotSupportedException();
	}
	
	//By Serialize 
	public SingletonImpl readResolve() {
		return instance;
	}
	
	
	
	public static  SingletonImpl getInstance() {
		if(instance ==null) {
			synchronized(SingletonImpl.class) {
				if(instance == null)
				{
					instance = new SingletonImpl();
				}
			}
		}
		
		return instance;
	}
	
	
	
}
