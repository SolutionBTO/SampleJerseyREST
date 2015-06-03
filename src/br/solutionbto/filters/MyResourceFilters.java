package br.solutionbto.filters;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ext.Provider;

import com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory;
import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;

@Provider
public class MyResourceFilters extends RolesAllowedResourceFilterFactory{
	
	@Override
	public List<ResourceFilter> create(AbstractMethod am) {
		List<ResourceFilter> filters = super.create(am);  
        if (filters == null) {  
            filters = new ArrayList<ResourceFilter>();  
        }  
        List<ResourceFilter> securityFilters = new ArrayList<ResourceFilter>(filters);  
        //put the Security Filter first in line  
        securityFilters.add(0, new JerseyResourceFilter());  
        return securityFilters;  
	}
}
