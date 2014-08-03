package com.virtusa.vcat.templates;

import java.util.ArrayList;

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
	 * List of parameters corresponding to this method.
	 */
	private ArrayList<ConnectorMethodParameterDescriptor> parameters;
	
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
	 * @return the parameters
	 */
	public ArrayList<ConnectorMethodParameterDescriptor> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(
			ArrayList<ConnectorMethodParameterDescriptor> parameters) {
		this.parameters = parameters;
	}

	

}
