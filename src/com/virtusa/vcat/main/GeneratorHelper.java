package com.virtusa.vcat.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

	public GeneratorHelper() {
		velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,
				"classpath");
		velocityEngine.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());
		velocityEngine.init();
	}

	private void buildSynapseTemplate(VelocityContext velocityContext,
			File templateFolderPath, ConnectorMethodDescriptor method) throws IOException {
		velocityContext.put("method", method);
		Template methodVelocityTemplate = velocityEngine.getTemplate(VCatConstants.SYNAPSE_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				templateFolderPath.getAbsoluteFile() + File.separator + method.getName() + ".xml"));
		methodVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();

	}

	public void buildProxyFile(VelocityContext velocityContext,
			File proxyFolderPath, ConnectorDescriptor connector) throws IOException {
		if (!proxyFolderPath.exists()) {
			proxyFolderPath.mkdirs();
		}
		Template proxyVelocityTemplate = velocityEngine.getTemplate(VCatConstants.PROXY_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				proxyFolderPath.getAbsoluteFile() + File.separator + connector.getMethod().getName() + ".xml"));
		proxyVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
	}

	public void buildRequestFile(VelocityContext velocityContext,
			File requestFolderPath, ConnectorDescriptor connector) throws IOException {
		if (!requestFolderPath.exists()) {
			requestFolderPath.mkdirs();
		}
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

	}

	public void buildJavaClass(VelocityContext velocityContext,
			File javaClassFolderPath, ConnectorDescriptor connector, GeneratorUtility utility) throws IOException {
		if (!javaClassFolderPath.exists()) {
			javaClassFolderPath.mkdirs();
		}
		Template javaClassVelocityTemplate = velocityEngine.getTemplate(VCatConstants.JAVA_CLASS_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				javaClassFolderPath.getAbsoluteFile() + File.separator + 
				utility.firstToUpperCase(connector.getMethod().getName()) + ".java"));
		javaClassVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
	}

	public void buildComponent(VelocityContext velocityContext,
			File componentFolderPath, ConnectorComponentDescriptor component) throws IOException {
		if (!componentFolderPath.exists()) {
			componentFolderPath.mkdirs();
		}
		velocityContext.put("component", component);
		Template componentVelocityTemplate = velocityEngine.getTemplate(VCatConstants.COMPONENT_TEMPLATE_NAME);
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				componentFolderPath.getAbsoluteFile() + File.separator + "component.xml"));
		componentVelocityTemplate.merge(velocityContext, writer);
		writer.flush();
		writer.close();
		
		for (int i = 0; i < component.getMethods().size(); i++) {
			buildSynapseTemplate(velocityContext, componentFolderPath, component.getMethods().get(i));
		}

	}
}
