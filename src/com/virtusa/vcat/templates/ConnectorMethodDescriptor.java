package com.virtusa.vcat.templates;

import java.util.List;

/**
 * Method descriptor for Velocity. This is the $connector.Method var in the Velocity context.
 * 
 *
 */
public class ConnectorMethodDescriptor {
	/**
	 * The method name.
	 */
	private String name;
	/**
	 * The method description.
	 */
	private String description;
	
	public ConnectorMethodDescriptor(final String name, final String description) {
		this.name = name;
		this.description = description;
	}
	/**
	 * List of parameters corresponding to this method.
	 */
	private List<ConnectorMethodParameterDescriptor> parameters;
	
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
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the parameters
	 */
	public List<ConnectorMethodParameterDescriptor> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(
			List<ConnectorMethodParameterDescriptor> parameters) {
		this.parameters = parameters;
	}

	

}
