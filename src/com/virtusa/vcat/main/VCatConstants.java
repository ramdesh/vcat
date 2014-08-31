package com.virtusa.vcat.main;

import java.io.File;

/**
 * Constants class.
 * 
 *
 */
public final class VCatConstants {
	/**
	 * Directory where vCat will be running.
	 */
	public static final String CONFIG_DIR = System.getProperty("user.dir");
	/**
	 * The name of the CSV file the connector description data is being read from.
	 */
	public static final String CONFIG_CSV_FILENAME = "methods.csv";
	/**
	 * Path to drop Java classes for connectors.
	 */
	public static final String JAVA_PACKAGE_PATH = "java" + File.separator + "org" + File.separator + "wso2" + File.separator + "carbon" 
			+ File.separator + "connector";
	/**
	 * Path to velocity templates.
	 */
	public static final String TEMPLATE_PATH = "com" + File.separator + "virtusa" + File.separator + "vcat" 
	 + File.separator + "templates" + File.separator;
	/**
	 * Velocity template for connector Proxy.
	 */
	public static final String PROXY_TEMPLATE_NAME = TEMPLATE_PATH + "connector_proxy.vm";
	/**
	 * Velocity template for connector JSON Request.
	 */
	public static final String JSON_REQUEST_TEMPLATE_NAME = TEMPLATE_PATH + "connector_json_request.vm";
	/**
	 * Velocity template for connector XML Request.
	 */
	public static final String XML_REQUEST_TEMPLATE_NAME = TEMPLATE_PATH + "connector_xml_request.vm";
	/**
	 * Velocity template for connector SOAP Request.
	 */
	public static final String SOAP_REQUEST_TEMPLATE_NAME = TEMPLATE_PATH + "connector_soap_request.vm";
	/**
	 * Velocity template for connector Synapse Template.
	 */
	public static final String SYNAPSE_TEMPLATE_NAME = TEMPLATE_PATH + "connector_template.vm";
	/**
	 * Velocity template for connector Java class for class mediator.
	 */
	public static final String JAVA_CLASS_TEMPLATE_NAME = TEMPLATE_PATH + "connector_java_class.vm";
	/**
	 * Velocity template for connector component.
	 */
	public static final String COMPONENT_TEMPLATE_NAME = TEMPLATE_PATH + "connector_component.vm";
	/**
	 * Redirects to the correct path for proxy and request folders.
	 */
	public static final String PATH_CORRECTOR = ".." + File.separator + ".." + File.separator + ".."
			+ File.separator + ".." + File.separator;
	/**
	 * Proxy folder name.
	 */
	public static final String PROXY_FOLDER_PATH = "proxy" + File.separator;
	/**
	 * Request folder name/path.
	 */
	public static final String REQUEST_FOLDER_PATH = "requests" + File.separator;
	

}
