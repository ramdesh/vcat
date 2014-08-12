package com.virtusa.vcat.templates;

/**
 * Descriptor class for Connector method parameters for Velocity templating. 
 * Corresponds to $connector.Method.Parameter within the Velocity context.
 * 
 *
 */
public class ConnectorMethodParameterDescriptor {
	/**
	 * Parameter name.
	 */
	private String name;
	
	public ConnectorMethodParameterDescriptor(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
