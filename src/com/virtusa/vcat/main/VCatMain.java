package com.virtusa.vcat.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.virtusa.vcat.templates.ConnectorComponentDescriptor;
import com.virtusa.vcat.templates.ConnectorDescriptor;
import com.virtusa.vcat.templates.ConnectorMethodDescriptor;
import com.virtusa.vcat.templates.ConnectorMethodParameterDescriptor;
import com.virtusa.vcat.templates.GeneratorUtility;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Main class for vCat.
 * 
 * 
 */
public class VCatMain {

	public static VelocityEngine velocityEngine;

	public static void main(String[] args) {
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(VCatConstants.CONFIG_DIR
					+ File.separator + VCatConstants.CONFIG_CSV_FILENAME));
			// Read in CSV file contents.
			List<String[]> content = csvReader.readAll();
			Scanner userInput = new Scanner(System.in);
			System.out.print("Enter the name of the connector... ");
			String connectorName = userInput.nextLine();
			System.out.print("Select Technology - Java(J)/Rest(R)?... ");
			String connectorTech = userInput.next();

			System.out
					.print("Select Message Type - XML(X)/JSON(J)/SOAP(S)?... ");
			String messageType = userInput.next();
			userInput.close();
			ConnectorDescriptor connectorDescriptor = new ConnectorDescriptor(
					connectorName);
			connectorDescriptor.setMessageType(messageType.toLowerCase());
			Map<String, ConnectorComponentDescriptor> components = new HashMap<String, ConnectorComponentDescriptor>();

			velocityEngine = new VelocityEngine();
			velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER,
					"classpath");
			velocityEngine.setProperty("classpath.resource.loader.class",
					ClasspathResourceLoader.class.getName());
			velocityEngine.init();

			VelocityContext velocityContext = new VelocityContext();
			
			GeneratorUtility generatorUtility = new GeneratorUtility();
			
			GeneratorHelper generatorHelper = new GeneratorHelper();

			// creating relevant folders
			File proxyFolder = new File(VCatConstants.CONFIG_DIR
					+ File.separator + VCatConstants.PROXY_FOLDER_PATH);
			File requestFolder = new File(VCatConstants.CONFIG_DIR
					+ File.separator + VCatConstants.REQUEST_FOLDER_PATH);

			for (int i = 0; i < content.size(); i++) {
				String[] currentRow = content.get(i);
				String currentComponentName = currentRow[0];
				if (!components.containsKey(currentComponentName)) {
					components.put(currentComponentName,
							new ConnectorComponentDescriptor(
									currentComponentName));
				}
				ConnectorComponentDescriptor currentComponent = components
						.get(currentComponentName);
				ConnectorMethodDescriptor currentMethod = new ConnectorMethodDescriptor(
						currentRow[1], currentRow[3]);
				List<ConnectorMethodParameterDescriptor> paramList = new ArrayList<ConnectorMethodParameterDescriptor>();
				String[] currentMethodParams = currentRow[2].split(":");
				for (int j = 0; j < currentMethodParams.length; j++) {
					paramList.add(new ConnectorMethodParameterDescriptor(
							currentMethodParams[j]));
				}
				currentMethod.setParameters(paramList);
				currentComponent.addMethod(currentMethod);

				connectorDescriptor.setMethod(currentMethod);

			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(VCatMain.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IOException ioe) {
			Logger.getLogger(VCatMain.class.getName()).log(Level.SEVERE, null,
					ioe);
		}

	}
	
	

}
