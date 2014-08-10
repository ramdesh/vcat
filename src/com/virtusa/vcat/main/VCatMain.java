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

import com.virtusa.vcat.templates.ConnectorComponentDescriptor;
import com.virtusa.vcat.templates.ConnectorDescriptor;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Main class for vCat.
 * 
 *
 */
public class VCatMain {

	private final HashMap<String, ArrayList<String>> methodsAndParams = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(VCatConstants.CONFIG_DIR
					+ File.separator + VCatConstants.CONFIG_CSV_FILENAME));
			//Read in CSV file contents.
			List content = csvReader.readAll();
			Scanner userInput = new Scanner(System.in);
			System.out.print("Enter the name of the connector... ");
			String connectorName = userInput.nextLine();
			System.out.print("Select Technology - Java(J)/Rest(R)?... ");
			String connectorTech = userInput.next();

			System.out.print("Select Message Type - XML(X)/JSON(J)/SOAP(S)?... ");
			String messageType = userInput.next();
			
			ConnectorDescriptor connectorDescriptor = new ConnectorDescriptor(connectorName);
			Map<String, ConnectorComponentDescriptor> components = new HashMap<String, ConnectorComponentDescriptor>();
			
			for (int i = 0; i < content.size(); i++) {
				String[] currentRow = (String[])content.get(i);
				String currentComponent = currentRow[0];
				if (!components.containsKey(currentComponent)) {
				}
				
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
