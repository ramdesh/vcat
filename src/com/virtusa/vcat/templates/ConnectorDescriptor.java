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
	 * Message type of the connector. 'xml', 'soap' or 'json.
	 */
	private String messageType;
	/**
	 * The current method that Velocity will be generating files for.
	 */
	private ConnectorMethodDescriptor method;
	/**
	 * Connector type; Java or REST.
	 */
	private String type;
	
	
    public String getType() {
    
        return type;
    }

    
    public void setType(String type) {
    
        this.type = type;
    }

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
	/**
	 * Sets the message type for the connector. 
	 * @param messageType The message type to set. 
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	/**
	 * Return connector message type.
	 * @return The message type.
	 */
	public String getMessageType() {
		return this.messageType;
	}

	
}
