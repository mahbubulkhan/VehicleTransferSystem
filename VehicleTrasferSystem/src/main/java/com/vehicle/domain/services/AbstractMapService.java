package com.vehicle.domain.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vehicle.domain.DomainObject;

public abstract class AbstractMapService  
{
    protected Map<Integer, DomainObject> domainMap;

    public AbstractMapService() {
        domainMap = new HashMap<>();
        loadDomainObjects();
    }

    public List<DomainObject> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    public DomainObject getById(Integer id) {
        if(id <= domainMap.size())
        	return domainMap.get(id);
        else
        	throw new RuntimeException("Doesnt exist any object with id "+id);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if (domainObject != null){

            if (domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);

            return domainObject;
        } else {
            throw new RuntimeException("Object Can't be null");
        }
    }

    public void delete(Integer id) {
    	if(id <= domainMap.size())
    		domainMap.remove(id);
    	else
    		throw new RuntimeException("Object doesnt exist  id :"+id);
    }

    private Integer getNextKey(){
        return Collections.max(domainMap.keySet()) + 1;
    }

    protected abstract void loadDomainObjects();

	
}