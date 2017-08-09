package com.vehicle.domain.services.vehicles;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.domain.DomainObject;

import com.vehicle.domain.locations.DistributionCenter;
import com.vehicle.domain.services.AbstractMapService;


@Service
public class DistributionCenterService  extends AbstractMapService {
	
	
	@Override
	public List<DomainObject> listAll() {
		return super.listAll();
	}

	
	@Override
	public DistributionCenter getById(Integer id) {
		return (DistributionCenter) super.getById(id);
	}
	
	public DistributionCenter saveOrUpdate(DistributionCenter domainObject) 
	{
        return (DistributionCenter) super.saveOrUpdate(domainObject);
    }
	
	@Override
	public void delete(Integer id) 
	{
	        super.delete(id);
	}
	
	
	@Override
	protected void loadDomainObjects() {
		// TODO Auto-generated method stub
		domainMap = new HashMap<>();
		
		DistributionCenter center1 = new DistributionCenter();
		center1.setId(1);
		domainMap.put(1, center1);
		
		DistributionCenter center2 = new DistributionCenter();
		center2.setId(2);
		domainMap.put(2, center2);
		
		DistributionCenter center3 = new DistributionCenter();
		center3.setId(3);
		domainMap.put(3, center3);
	}


}
