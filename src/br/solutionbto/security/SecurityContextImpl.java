package br.solutionbto.security;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.SecurityContext;

import br.solutionbto.model.Role;

public class SecurityContextImpl implements SecurityContext {

	private final ExternalUser user;

	public SecurityContextImpl(ExternalUser user) {
		this.user = user;
	}

	public Principal getUserPrincipal() {
		return user;
	}

	public boolean isUserInRole(String role) {
		if(role.equalsIgnoreCase(Role.anonymous.name())) {
			return true;
		}
		if(user == null) {
			throw new WebApplicationException(HttpServletResponse.SC_FORBIDDEN);
		}
		return user.getRole().equalsIgnoreCase(role);
	}

	public boolean isSecure() {
		return false;
	}

	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}
}
