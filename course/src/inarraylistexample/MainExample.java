package inarraylistexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExample {

	Scanner sc=new Scanner(System.in);
	
	List courses=null;
	List batches=null;
	List trainers=null;
	List students=null;
//=================================================================================
	public void addCourse() {
		
		courses=new ArrayList();
		System.out.println("How many courses do you want");
		int i=sc.nextInt();
		for (int j=0;j<i;j++) {
			Course c=new Course();
			System.out.println("Enter course id");
			c.setCid(sc.nextInt());
			
			System.out.println("Enter course name");
			c.setCname(sc.next());
			courses.add(c);
		}
	}
//=================================================================================
	public void displayCourse() {
		if(!courses.isEmpty())
		{
			System.out.println("================================================");
			System.out.println("Course ID"+" | "+"Course Name");
		for(Object o:courses)
		{
			Course c=(Course)o;
			System.out.println(c.getCid()+"         | "+c.getCname());
		}
		System.out.println("======================================================");
	  }
	}
	
//=================================================================================
	
	public void addBatch() 
	{
			batches=new ArrayList();
			System.out.println("How many batches do you want");
			int j=sc.nextInt();
			for (int k=0;k<j;k++)
			{
				Batch b=new Batch();
				System.out.println("Enter batch id");
				b.setBid(sc.nextInt());
				System.out.println("Enter batch name");
				b.setBname(sc.next());
				displayCourse();
				
				List list1= new ArrayList();
				System.out.println("How many courses do you want to allocate");
				int i=sc.nextInt();
				for(int m=0;m<i;m++)
				{
					System.out.println("Enter id for allocation");
					int aid=sc.nextInt();
					for(Object o:courses)
					{
						Course c2=(Course)o;
						if(c2.getCid()==aid)
						{
							list1.add(c2);
						}
					}
					b.setCourse(list1);
				}
				batches.add(b);
				
			}
		}
//=================================================================================
	public void displayBatch()
	{
		if(!batches.isEmpty()) {
			//System.out.println("================================================");
			System.out.println("Batch Id"+" | "+"Batch Name"+"  | "+"Course Id"+"  |"+"Course Name");
			
			for(Object o1:batches)
			{
				Batch b=(Batch)o1;
				//System.out.println(b.getBid()+"       "+b.getBname());
				if(!b.getCourse().isEmpty())
				{
					//System.out.println("Course Id"+"  |"+"Course Name");
					for(Object o2:b.getCourse())
					{
						Course c2=(Course)o2; 
						System.out.println(c2.getCid()+"        |"+c2.getCname()+"       | "+b.getBid()+"      | "+b.getBname());
					}
				}
			}
			System.out.println("=================================================");
		}
	}
//=======================================================================================
	public void addTrainer()
	{
		trainers=new ArrayList();
		 System.out.println("How many trainers do you want");
		 int i=sc.nextInt();
		 for(int j=0;j<i;j++)
		 {
			 Trainer t=new Trainer();
			 System.out.println("Enter trainer id");
			 t.setTid(sc.nextInt());
			 System.out.println("Enter trainer name");
			 t.setTname(sc.next());
			 displayBatch();
			 List list=new ArrayList();
			 System.out.println("How many batches are available");
			 int k=sc.nextInt();
			 for(int a=0;a<k;a++)
			 {
				 Batch b1=new Batch();
				 System.out.println("Enter id for allocation");
				 int f=sc.nextInt();
				 for(Object obj:batches)
					 if(b1.getBid()==f)
					 {
						list.add(b1) ;
					 }
				 t.setBatch(list);
			 }
		 
			 trainers.add(t);
		 }
		 
	}
//===================================================================================
	public void displayTrainer()
	{
		if(!trainers.isEmpty())  
		{
			System.out.println("===================================================");
			System.out.println("Batch Id"+" | "+"Batch Name"+" "+"Trainer Id"+" | "+"Trainer Name");
			for(Object o1:trainers)
			{
				Trainer t2=(Trainer)o1;
				System.out.println();
				if(!t2.getBatch().isEmpty())
				{
					for(Object o2:t2.getBatch())
					{
						Batch b1=(Batch)o2;
						System.out.println(b1.getBid()+"      | "+b1.getBname()+"        |"+t2.getTid()+"      | "+t2.getTname());
					}
				}
			}
		}
	}
 //=================================================================================
	public void addStudent()
	{
		students =new ArrayList();
		System.out.println("How many Student there are");
		int a=sc.nextInt();
		for(int x=0;x<a;x++)
		{
			Student s=new Student();
			System.out.println("Enter student id");
			s.setSid(sc.nextInt());
			
			System.out.println("Enter student name");
			s.setSname(sc.next());
			displayTrainer();
			
			List list2=new ArrayList();
			System.out.println("How many students want to get course");
			int y=sc.nextInt();
			for(int m=0;m<y;m++)
			{
				Trainer t3=new Trainer();
				System.out.println("Enter id for allocation");
				int z=sc.nextInt();
				if(t3.getTid()==z)
				{
					list2.add(t3);
				}
				t3.setBatch(list2);
			}
			students.add(s);
		}
	}
//===============================================================================
	public void displayStudent()
	{
		if(!students.isEmpty())
		{
			System.out.println("===================================================");
			System.out.println("Batch Id"+" | "+"Batch Name"+" "+"Trainer Id"+" | "+"Trainer Name");
			for(Object obj:students)
			{
				Student s1=(Student)obj;
				
				if(!s1.getTrainer().isEmpty())
				{
					for(Object g:s1.getTrainer())
					{
						Trainer t=(Trainer)g;
						System.out.println(t.getTid()+"    |"+t.getTname()+"     |"+s1.getSid()+"   |"+s1.getSname());
					}
				}
			}
			System.out.println("===================================================");
		}
	}
	public static void main(String[] args)
	{
		MainExample me=new MainExample();
		me.addCourse();
		me.displayCourse();
		me.addBatch();
		me.displayBatch();
		me.addTrainer();
		me.displayTrainer();
	}

}
