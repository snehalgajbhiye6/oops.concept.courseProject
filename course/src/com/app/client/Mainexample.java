package com.app.client;

import java.util.Scanner;

import com.app.service.impl.Addinterface;

public class Mainexample {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Addinterface a=new Addinterface();
		String s=" ";
		
		do
		{
			System.out.println("1) addCourse");
			System.out.println("2) addBatch");
			System.out.println("3) addTrainer");
			System.out.println("4) addStudent");
			System.out.println("5) displayCourse");
			System.out.println("6) displayBatch");
			System.out.println("7) displayTrainer");
			System.out.println("8) displayStudent");
			
			System.out.println("Enter your choice");
			int i=sc.nextInt();
			
			switch(i)
			{
			case 1:
				a.addCourse();
				break;
			case 2:
				a.addBatch();
				break;
			case 3:
				a.addTrainer();
				break;
			case 4:
				a.addStudent();
				break;
			case 5:
				a.displayCourse();
				break;
			case 6:
				a.displayBatch();
				break;
			case 7:
				a.displayTrainer();
				break;
			case 8:
				a.displayStudent();
				break;
			}
			System.out.println("Do you want to continue (y/n)");
			s=sc.next();
		}
		while(s.equals("y"));
    }

}
