package com.project.work.dp.chainofresponsibility;

import com.project.work.dp.chainofresponsibility.Constant.Response;
import com.project.work.model.Employee;

public interface IApprover {
	
	public IApprover nextLeaveApprover(IApprover nextApprover);
	
	public Response leaveApprover(Employee employee);

}
