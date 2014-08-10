package com.virtusa.vcat.templates;


/**
 * Connector descriptor class for Velocity. This is the $connector variable in the Velocity context.
 * 
 *
 */
public class ConnectorDescriptor {
	
	public ConnectorDescriptor(final String name) {
		this.name = name;
	}
	/**
	 * The name of the connector.
	 */
	private String name;
	/**
	 * The current method that Velocity will be generating files for.
	 */
	private ConnectorMethodDescriptor method;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConnectorMethodDescriptor getMethod() {
		return method;
	}

	public void setMethod(ConnectorMethodDescriptor method) {
		this.method = method;
	}

	
}
