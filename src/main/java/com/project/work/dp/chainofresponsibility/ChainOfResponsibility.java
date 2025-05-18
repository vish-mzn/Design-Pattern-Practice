package com.project.work.dp.chainofresponsibility;

import java.util.Scanner;

import com.project.work.dp.chainofresponsibility.Constant.Response;
import com.project.work.model.Employee;

public class ChainOfResponsibility {
	
	
	private static IApprover createChain() {
		IApprover handler = new RequestHandler();
		
		IApprover approver1 = new TeamLeader();
		IApprover approver2 = new ProjectManager();
		IApprover approver3 = new ResourceManager();

		handler.nextLeaveApprover(approver1);
		approver1.nextLeaveApprover(approver2);
		approver2.nextLeaveApprover(approver3);
		
		return handler;
	}
	

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			String name = sc.next();
			String gender = sc.next();
			int leaveDays = sc.nextInt();
			
			Employee employee = new Employee(name, gender, leaveDays);
			
			// first of All, need to create the chain of responsibility
			IApprover handler = createChain();
			Response response = handler.leaveApprover(employee); 
			
			
			if (Response.APPROVED == response) {
			    if (employee.getGender().equalsIgnoreCase(Constant.Gender.MALE.toString())) {
			        System.out.println("Request Granted Have A nice journey Mr: " + employee.getName());
			    } else {
			        System.out.println("Request Granted Have A nice journey Mrs/Miss: " + employee.getName());
			    }
			} else if (Response.DENIED == response) {
			    if (employee.getGender().equalsIgnoreCase(Constant.Gender.MALE.toString())) {
			        System.out.println("Sorry Your Request was not granted  Mr: " + employee.getName());
			    } else {
			        System.out.println("Sorry Your Request was not granted  Mrs/Miss: " + employee.getName());
			    }
			}
		}

	}

}
