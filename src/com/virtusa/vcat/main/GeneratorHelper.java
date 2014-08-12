package com.virtusa.vcat.main;

import java.io.File;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.virtusa.vcat.templates.ConnectorComponentDescriptor;
import com.virtusa.vcat.templates.ConnectorDescriptor;

public class GeneratorHelper {
	public void buildSynapseTemplate(VelocityContext velocityContext,
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
	
	public void buildComponentFile(VelocityContext velocityContext, 
			File componentFolderPath, Map<String, ConnectorComponentDescriptor> components) {
		
	}
}
