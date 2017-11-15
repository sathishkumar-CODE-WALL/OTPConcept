package com.satz.test;

import java.util.Scanner;

public class DataHandler {
	
	Data data = new Data();
	
	public static void main(String args[]){
		DataHandler dataHandler = new DataHandler();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("Enter new Data");
			 int dataVal = sc.nextInt();
			dataHandler.doStuff(dataVal);
		}
		
	}
	
	public void doStuff(int dataVal){
		data.addData(dataVal);
		System.out.println("AVG : "+data.getData());
		data.printAllData();
		System.out.println("AVG : "+data.getData());
	}
	

}
