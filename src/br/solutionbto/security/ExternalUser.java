package br.solutionbto.security;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
public class ExternalUser implements Principal {

	private String id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private boolean isVerified;
	private Map<String, Object> attributes=new HashMap<String, Object>();	
	
	@JsonIgnore
	private String role;
	
	public ExternalUser() {}

	public ExternalUser(String userId) {
		this.id = userId;
	}

	public ExternalUser(ExternalUser user) {
		this.id = user.getId();
		this.emailAddress = user.getEmailAddress();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.isVerified = user.isVerified();
		this.role = user.getRole();
		this.attributes = user.getAttributes();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getId() {
		return id;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public String getName() {
		return emailAddress;
	}

	public String getRole() {
		return role;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param isVerified the isVerified to set
	 */
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExternalUser [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", isVerified=" + isVerified + ", attributes=" + attributes
				+ ", role=" + role + "]";
	}
}
