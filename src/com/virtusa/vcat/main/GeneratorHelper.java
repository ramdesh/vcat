package com.virtusa.vcat.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.virtusa.vcat.templates.ConnectorComponentDescriptor;
import com.virtusa.vcat.templates.ConnectorDescriptor;
import com.virtusa.vcat.templates.ConnectorMethodDescriptor;
import com.virtusa.vcat.templates.GeneratorUtility;

public class GeneratorHelper {

	private static VelocityEngine velocityEngine;
	private Logger log;

	public GeneratorHelper() {
		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,
				"classpath");
		velocityEngine.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		log = Logger.getLogger("VCAT");
	}

	private void buildSynapseTemplate(VelocityContext velocityContext,
			File templateFolderPath, ConnectorMethodDescriptor method) throws IOException {
		log.info("Building Synapse Template for " + method.getName());
		velocityContext.put("method", method);
		Template methodVelocityTemplate = velocityEngine.getTemplate(VCatConstants.SYNAPSE_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				templateFolderPath.getAbsoluteFile() + File.separator + method.getName() + ".xml"));
		methodVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
		log.info("...Done");

	}

	public void buildProxyFile(VelocityContext velocityContext,
			File proxyFolderPath, ConnectorDescriptor connector) throws IOException {
		if (!proxyFolderPath.exists()) {
			proxyFolderPath.mkdirs();
		}
		log.info("Building proxy for " + connector.getMethod().getName());
		Template proxyVelocityTemplate = velocityEngine.getTemplate(VCatConstants.PROXY_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				proxyFolderPath.getAbsoluteFile() + File.separator + 
				connector.getName() + "_" + connector.getMethod().getName() + ".xml"));
		proxyVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
		log.info("...Done");
	}

	public void buildRequestFile(VelocityContext velocityContext,
			File requestFolderPath, ConnectorDescriptor connector) throws IOException {
		if (!requestFolderPath.exists()) {
			requestFolderPath.mkdirs();
		}
		log.info("Building request file for " + connector.getMethod().getName());
		Template requestVelocityTemplate = null;
		String fileExtension = ".xml";
		if (connector.getMessageType().equalsIgnoreCase("j")) {
			requestVelocityTemplate = velocityEngine.getTemplate(VCatConstants.JSON_REQUEST_TEMPLATE_NAME);
			fileExtension = ".json";
		} else if (connector.getMessageType().equalsIgnoreCase("x")) {
			requestVelocityTemplate = velocityEngine.getTemplate(VCatConstants.XML_REQUEST_TEMPLATE_NAME);
		} else {
			requestVelocityTemplate = velocityEngine.getTemplate(VCatConstants.SOAP_REQUEST_TEMPLATE_NAME);
		}
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				requestFolderPath.getAbsoluteFile() + File.separator + connector.getMethod().getName() + 
				fileExtension));
		requestVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
		log.info("...Done");
	}

	public void buildJavaClass(VelocityContext velocityContext,
			File javaClassFolderPath, ConnectorDescriptor connector, GeneratorUtility utility) throws IOException {
		if (!javaClassFolderPath.exists()) {
			javaClassFolderPath.mkdirs();
		}
		log.info("Building Java Class for " + connector.getMethod().getName());
		Template javaClassVelocityTemplate = velocityEngine.getTemplate(VCatConstants.JAVA_CLASS_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				javaClassFolderPath.getAbsoluteFile() + File.separator + 
				utility.firstToUpperCase(connector.getMethod().getName()) + ".java"));
		javaClassVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
		log.info("...Done");
	}

	public void buildComponent(VelocityContext velocityContext,
			File componentFolderPath, ConnectorComponentDescriptor component) throws IOException {
		if (!componentFolderPath.exists()) {
			componentFolderPath.mkdirs();
		}
		log.info("Building component " + component.getName());
		velocityContext.put("component", component);
		Template componentVelocityTemplate = velocityEngine.getTemplate(VCatConstants.COMPONENT_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				componentFolderPath.getAbsoluteFile() + File.separator + "component.xml"));
		componentVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
		log.info("...Done");
		for (int i = 0; i < component.getMethods().size(); i++) {
			buildSynapseTemplate(velocityContext, componentFolderPath, component.getMethods().get(i));
		}
		

	}
}
