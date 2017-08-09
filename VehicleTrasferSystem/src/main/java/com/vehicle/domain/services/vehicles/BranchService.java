package com.vehicle.domain.services.vehicles;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vehicle.domain.DomainObject;
import com.vehicle.domain.locations.Branch;
import com.vehicle.domain.services.AbstractMapService;

@Service
public class BranchService extends AbstractMapService {

	@Override
	public List<DomainObject> listAll() {
		return super.listAll();
	}

	@Override
	public Branch getById(Integer id) {
		return (Branch) super.getById(id);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}

	public Branch saveOrUpdate(Branch domainObject) {
		return (Branch) super.saveOrUpdate(domainObject);
	}

	@Override
	protected void loadDomainObjects() {
		// TODO Auto-generated method stub
		domainMap = new HashMap<>();

		Branch branch1 = new Branch();
		branch1.setId(1);
		domainMap.put(1, branch1);

		Branch branch2 = new Branch();
		branch2.setId(2);
		domainMap.put(2, branch2);

		Branch branch3 = new Branch();
		branch3.setId(3);
		domainMap.put(3, branch3);

	}

}
