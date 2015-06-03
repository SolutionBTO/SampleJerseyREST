package br.solutionbto.filters;

import java.util.UUID;
import java.util.logging.Logger;

import javax.ws.rs.ext.Provider;

import br.solutionbto.model.Role;
import br.solutionbto.security.ExternalUser;
import br.solutionbto.security.SecurityContextImpl;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;

/**
 * 
 * @author Solutionbto
 *
 */
@Provider
public class JerseyResourceFilter implements 
											ResourceFilter, 
											ContainerRequestFilter, 
											ContainerResponseFilter {

	private Logger logger=Logger.getLogger(JerseyResourceFilter.class.getSimpleName());
	
	/**
	 * for the response intercept
	 */
	@Override
	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {
		logger.info("RESPONSE: "+response.getResponse().getEntity().toString());
		return response;
	}

	/**
	 * for the request intercept
	 */
	@Override
	public ContainerRequest filter(ContainerRequest request) {
		logger.info("REQUEST: "+request.getMethod()+" "+request.getPath());
		ExternalUser extUser=new ExternalUser(UUID.randomUUID().toString());
		extUser.setRole(Role.anonymous.toString());
		request.setSecurityContext(new SecurityContextImpl(extUser));
		return request;
	}

	@Override
	public ContainerRequestFilter getRequestFilter() {
		return this;
	}

	@Override
	public ContainerResponseFilter getResponseFilter() {
		return this;
	}

}
