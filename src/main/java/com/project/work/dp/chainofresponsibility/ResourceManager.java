package com.project.work.dp.chainofresponsibility;

import com.project.work.dp.chainofresponsibility.Constant.Response;
import com.project.work.model.Employee;

public class ResourceManager implements IApprover {
	
	private IApprover iApprover;

	
	@Override
	public IApprover nextLeaveApprover(IApprover nextApprover) {
		this.iApprover = nextApprover;
		return iApprover;
	}

	@Override
	public Response leaveApprover(Employee employee) {
		if (employee.getDays() > 3 &&  employee.getDays() <= 7) {
			return Response.APPROVED;
		}
		return Response.DENIED;
	}

}
