//import java.io.Serializable;
package com.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

public class EmployeeClass {
    // public static void  main(String[] args) {
    //     System.out.print("Hello World");
    // }
    private String emplName;
    public EmployeeClass(){

    }
    public EmployeeClass(String prmName) {
        emplName = prmName;
   
     } 

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String prmEmplName) {
        emplName = prmEmplName;
    }
    
    //ServletContext context
    public void readJson(String filePath, HttpServletRequest request) throws IOException, ServletException {
    	try {
    		

    		System.out.println("List Header ...");
			for (Enumeration<?> names = request.getHeaderNames(); names.hasMoreElements(); ) {
				String name = (String) names.nextElement();
				System.out.println("Header name = " + name);
				for (Enumeration<?> values = request.getHeaders(name); values.hasMoreElements(); ) {
				System.out.println((String) values.nextElement());
				}
			}

//    		System.out.println("Process Parts ...");
//    		Collection<Part> parts = request.getParts();
//    		Iterator<Part> itr = parts.iterator();
//			while (itr.hasNext()) {
//				Part part = itr.next();
//				System.out.println("part name = " + part);
//			}

    	      File myObj = new File(".\\fileName.txt");
    	      if (myObj.createNewFile()) {
    	        System.out.println("File created: " + myObj.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
//    	try (BufferedReader br = new BufferedReader(
//                new FileReader("C:\\Projects\\JavaBeanProj\\JavaBeanExample2\\jsonfile.json"))) {
    	try (BufferedReader br = new BufferedReader(
                new FileReader(filePath))) {
    		StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
         	System.out.println(sb.toString());
         	JSONObject json = new JSONObject(sb.toString());
         	System.out.println("Now printing JSON as String:");
         	System.out.println(json.toString());
    	}
    }
    
    public void readJsonFromRequest(HttpServletRequest request) throws IOException {
    	String baseUrl = 
    			request.getScheme() + "://" + 
    			request.getServerName() + ":" + 
    			request.getServerPort() + 
    			request.getContextPath();
    	readFileFromURL(baseUrl);
    }
    
    public String getRequestBaseUrl(HttpServletRequest request) throws MalformedURLException {
    	String baseUrl = 
    			request.getScheme() + "://" + 
    			request.getServerName() + ":" + 
    			request.getServerPort() + 
    			request.getContextPath();
    	return baseUrl;
    }
    public void readFileFromURL(String baseUrl) throws IOException {
    	String jsonFile = "/data/list.json";
    	URL url = new URL(baseUrl + jsonFile);
    	Scanner s = new Scanner(url.openStream());
    	StringBuilder sb = new StringBuilder();
    	String line;
    	while (s.hasNextLine()) {
    		line = s.nextLine();
    		sb.append(line);
    	}
    	System.out.println(sb.toString());
    }
    
    public String readFileFromStream(HttpServletRequest request) throws IOException {
    	InputStream is = request.getServletContext().getResourceAsStream("/data/list.json");
    	StringBuilder sb = new StringBuilder();
    	String line;
    	if (is != null) {
    		BufferedReader br = new BufferedReader(new InputStreamReader(is));
    		while ((line = br.readLine())!= null) {
    			sb.append(line);
    		}
    		System.out.println("Json file output using Input Stream:");
    		System.out.println(sb.toString());
    		return "Read from Stream was successful!";
    	}
		return "Read from Stream was NOT successful!";
    }
    
}
