package com.app.service.impl;

import java.util.Scanner;

import com.app.model.Batch;
import com.app.model.Course;
import com.app.model.Student;
import com.app.model.Trainer;
import com.app.service.Service;

public class Addinterface implements Service
{
    Scanner sc=new Scanner(System.in);
    
    private Course course=null;
    private Batch batch=null;
    private Trainer trainer=null;
    private Student student=null;
	@Override
	public void addCourse()
	{
		course =new Course();
		System.out.println("Enter your id");
		course.setCid(sc.nextInt());
			
		System.out.println("Enter  course");
		course.setCname(sc.next());
		
	}

	@Override
	public void addBatch() 
	{
        if(course!=null)
        {
        	batch=new Batch();
        	System.out.println("Enter batch id");
        	batch.setBid(sc.nextInt());
        
        	System.out.println("Enter batch name");
        	batch.setBname(sc.next());
        	batch.setCourse(course);
        }
	}

	@Override
	public void addTrainer()
	{
		if(course!=null && batch!=null)
        {
        	trainer=new Trainer();
        	System.out.println("Enter trainer id");
        	trainer.setTid(sc.nextInt());
        
        	System.out.println("Enter trainer name");
        	trainer.setTname(sc.next());
        	trainer.setBatch(batch);
        }
	}

	@Override
	public void addStudent()
	{
		if(batch!=null && trainer!=null)
		{
			student =new Student();
			System.out.println("Enter trainer id");
			student.setSid(sc.nextInt());
			
			System.out.println("Enter triner name");
			student.setSname(sc.next());
		}
	}

	@Override
	public void displayCourse() 
	{
		System.out.println("Course Id "+" "+"Course Name");
		System.out.println(course.getCid()+" "+course.getCname());
		
	}

	@Override
	public void displayBatch()
	{
		

		if(course!=null && batch!=null)
		{
			System.out.println("Course Id "+" "+"Course Name"+" "+" Batch Id "+" "+"Batch Name");
			System.out.println(batch.getBid()+" "+batch.getBname()+" "+batch.getCourse().getCid()+" "+batch.getCourse().getCname());
		}
		
	}

	@Override
	public void displayTrainer()
	{
		
	    if(batch!=null && trainer!=null)
	    {
	    	System.out.println(" Batch Id "+" "+"Batch Name"+" "+"Trainer Id"+" "+"Trainer Name");
	    	System.out.println(trainer.getBatch().getBid()+" "+trainer.getBatch().getBname()+" "+trainer.getTid()+" "+trainer.getTname());
	    }
	}

	@Override
	public void displayStudent()
	{
		

	     if(trainer!=null && student!=null)
	     {
	    	 System.out.println("Trainer Id"+" "+"Trainer Name"+" "+"Student Id"+" "+"Student Name");
	    	 System.out.println(student.getTrainer().getTid()+" "+student.getTrainer().getTname()+" "+student.getSid()+" "+student.getSname());
	     }
	}

}
