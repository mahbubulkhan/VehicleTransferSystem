package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.locations.Branch;
import com.vehicle.domain.services.vehicles.BranchService;



@Controller
public class BranchController {

	private BranchService branchService;

	

	/**
	 * @param branchService
	 *            the branchService to set
	 */
	@Autowired
	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}

	// Shows all the Branches
	public void listBranches() {
		List<DomainObject> list = branchService.listAll();
		for (DomainObject element : list) 
		{
			Branch branch = (Branch) element;
			System.out.println(branch.getId());
		}
	}
	
	public void showBranch(Integer id)
	{
		Branch branch = branchService.getById(id);
		System.out.println(branch.getId());
	}
	
	
	public void deleteBranch(Integer id)
	{
		branchService.delete(id);
	}
	
	
	public void editBranc(Branch branch)
	{
		branchService.saveOrUpdate(branch);
	}
	
	public void addNewBranch(Branch branch)
	{
		branchService.saveOrUpdate(branch);
	}

}
