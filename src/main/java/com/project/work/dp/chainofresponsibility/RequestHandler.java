package com.project.work.dp.chainofresponsibility;

import com.project.work.dp.chainofresponsibility.Constant.Response;
import com.project.work.model.Employee;

public class RequestHandler implements IApprover {
	
	private IApprover iApprover;

	@Override
	public IApprover nextLeaveApprover(IApprover nextApprover) {
		this.iApprover = nextApprover;
		return this;
	}

	/*
	 * This is the default condition check before assigning to the next Responsibility class 
	 */
	@Override
	public Response leaveApprover(Employee employee) {
		return iApprover.leaveApprover(employee);
	}
	
}
