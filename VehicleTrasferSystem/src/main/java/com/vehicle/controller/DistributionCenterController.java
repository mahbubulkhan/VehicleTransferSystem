package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.vehicle.domain.DomainObject;

import com.vehicle.domain.locations.DistributionCenter;
import com.vehicle.domain.services.vehicles.DistributionCenterService;

@Controller
public class DistributionCenterController {

	private DistributionCenterService distributionCenterService;

	/**
	 * @return the distributionCenterService
	 */
	public DistributionCenterService getDistributionCenterService() {
		return distributionCenterService;
	}

	/**
	 * @param distributionCenterService
	 *            the distributionCenterService to set
	 */
	@Autowired
	public void setDistributionCenterService(DistributionCenterService distributionCenterService) {
		this.distributionCenterService = distributionCenterService;
	}

	// Shows all the Branches
	public void listDistributionCenters() {
		List<DomainObject> list = distributionCenterService.listAll();
		for (DomainObject element : list) {
			DistributionCenter center = (DistributionCenter) element;
			System.out.println(center.getId());
		}
	}

	public void showDistributionCenter(Integer id) {
		DistributionCenter center = distributionCenterService.getById(id);
		System.out.println(center.getId());
	}

	public void deleteDistributionCenter(Integer id) {
		distributionCenterService.delete(id);
	}

	public void editDistributionCenter(DistributionCenter center) {
		distributionCenterService.saveOrUpdate(center);
	}

	public void addDistributionCenter(DistributionCenter center) {
		distributionCenterService.saveOrUpdate(center);
	}
	
	
}
