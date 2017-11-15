package com.satz.test;

import java.util.concurrent.ConcurrentHashMap;

public class Data {
	
	private ConcurrentHashMap<Integer, Long> dataMap = new ConcurrentHashMap<Integer, Long>();
	
	public Data(){
		Thread thread = new Thread(new Cleaner());
		   thread.start();
	}
	
	public void addData(int data){
		dataMap.put(data, System.currentTimeMillis());
	}
	
	public double getData(){
		System.out.println("Sum" +dataMap.keySet().stream().mapToInt(Number::intValue).sum());
		System.out.println("count" +dataMap.keySet().size());
		return (dataMap.keySet().stream().mapToInt(Number::intValue).sum())/dataMap.keySet().size();
	}
	
	public void removeData(int key){
		dataMap.remove(key);
	}

	public void printAllData(){
		System.out.println("ALL DATA");
		for(Integer data : dataMap.keySet()){
			System.out.print(data.intValue() +" ");
		}
		System.out.println();
	}
	
	class Cleaner implements Runnable{

		private void cleanup(){
			for(Integer data : dataMap.keySet()){
				if(dataMap.get(data) < (System.currentTimeMillis()-60000)){
					System.out.println("Time up..removing "+ data);
					dataMap.remove(data);
				}
			}
		}
		
		@Override
		public void run() {
			while(true){
				try {
					System.out.println("Thread is sleeping..");
					Thread.sleep(60000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				cleanup();
				}
			}
			
	}
}
