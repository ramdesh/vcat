package com.virtusa.vcat.templates;

import java.util.ArrayList;
/**
 * Descriptor class for velocity templating to describe components.
 * 
 *
 */
public class ConnectorComponentDescriptor {
	public ConnectorComponentDescriptor(final String name) {
		this.name = name;
		this.methods = new ArrayList<ConnectorMethodDescriptor>();
	}
	/**
	 * The name of the component.
	 */
	private String name;
	
	/**
	 * Adds a method to this component.
	 * @param method
	 */
	public void addMethod(final ConnectorMethodDescriptor method) {
		this.methods.add(method);
	}
	/**
	 * @return the methods
	 */
	public ArrayList<ConnectorMethodDescriptor> getMethods() {
		return methods;
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
	/**
	 * @param methods the methods to set
	 */
	public void setMethods(ArrayList<ConnectorMethodDescriptor> methods) {
		this.methods = methods;
	}
	private ArrayList<ConnectorMethodDescriptor> methods;
}
