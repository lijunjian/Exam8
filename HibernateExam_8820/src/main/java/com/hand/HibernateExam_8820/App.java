package com.hand.HibernateExam_8820;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.hand.HibernateExam_8820.CustomerJDBCTemplate;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		CustomerJDBCTemplate customerJDBCTemplate = (CustomerJDBCTemplate) context.getBean("customerJDBCTemplate");
		System.out.println("请输入FirstName(first_name):");
		Scanner scan1 = new Scanner(System.in);
		String fn = scan1.nextLine();

		System.out.println("请输入LastName(last_name):");
		Scanner scan2 = new Scanner(System.in);
		String ln = scan2.nextLine();

		System.out.println("请输入Email(email):");
		Scanner scan3 = new Scanner(System.in);
		String em = scan3.nextLine();

		System.out.println("请输入Address ID(address_id):");
		Scanner scan4 = new Scanner(System.in);
		int ai = scan4.nextInt();
		boolean key = true;
		while (key) {
			if (ai < 0 || ai > 606) {
				System.out.println("你输入的Address ID不存在,请重新输入:");
				scan4=new Scanner(System.in);
				ai=scan4.nextInt();
			} else {
				key = false;
			}
		}

		Date dt = new Date();
		
		
		customerJDBCTemplate.create(1, fn, ln, em, ai, dt);

		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH：mm：ss"); 
		
		System.out.println("已经保存的数据如下:");
		List<Customer> customers = customerJDBCTemplate.listCustomers();
		for (Customer record : customers) {
			System.out.println("ID:" + record.getId());
			System.out.println("FirstName:" + record.getFirst_name());
			System.out.println("LastName:" + record.getLast_name());
			System.out.println("Email:" + record.getEmail());
			System.out.println("Address:" + record.getAddress());
			System.out.println("Create_date:" + time.format(dt));
		}
		
		System.out.println("请输入要删除的Customer的ID:");
		Scanner scan5 = new Scanner(System.in);
		int del = scan5.nextInt();
		boolean key1 = true;
		while (key1) {
			if (!customerJDBCTemplate.check(del)) {
				System.out.println("你输入的Customer ID不存在,请重新输入:");
				scan5=new Scanner(System.in);
				del=scan5.nextInt();
			} else {
				break;
			}
		}
		customerJDBCTemplate.delete(del);
		System.out.println("你输入的ID为"+del+"的Customer已经 删除.");

		scan1.close();
		scan2.close();
		scan3.close();
		scan4.close();
	}
}
