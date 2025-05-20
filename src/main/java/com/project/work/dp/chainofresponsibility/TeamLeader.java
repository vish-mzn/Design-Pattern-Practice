package com.project.work.dp.chainofresponsibility;

import com.project.work.dp.chainofresponsibility.Constant.Response;
import com.project.work.model.Employee;

public class TeamLeader implements IApprover {

	
	private IApprover iApprover;
	
	
	@Override
	public IApprover nextLeaveApprover(IApprover nextApprover) {
		this.iApprover = nextApprover;
		return this;
	}

	@Override
	public Response leaveApprover(Employee employee) {
		if (employee.getDays() == 1) {
			return Response.APPROVED;
		}
		return iApprover.leaveApprover(employee);
	}

}
