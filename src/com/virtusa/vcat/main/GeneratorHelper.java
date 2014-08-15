package com.virtusa.vcat.main;

import java.io.File;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.virtusa.vcat.templates.ConnectorComponentDescriptor;
import com.virtusa.vcat.templates.ConnectorDescriptor;

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
			File templateFolderPath, ConnectorDescriptor connector) {
		
		
	}
	public void buildProxyFile(VelocityContext velocityContext,
			File proxyFolderPath, ConnectorDescriptor connector) {

	}

	public void buildRequestFile(VelocityContext velocityContext,
			File requestFolderPath, ConnectorDescriptor connector) {

	}

	public void buildJavaClass(VelocityContext velocityContext,
			File javaClassFolderPath, ConnectorDescriptor connector) {

	}
	
	public void buildComponent(VelocityContext velocityContext, 
			File componentFolderPath, ConnectorComponentDescriptor component) {
		if (!componentFolderPath.exists()) {
			componentFolderPath.mkdirs();
		}
		velocityContext.put("component", component);
		
	}
}
