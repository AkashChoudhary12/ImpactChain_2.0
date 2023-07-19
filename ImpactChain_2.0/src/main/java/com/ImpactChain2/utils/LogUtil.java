package com.ImpactChain2.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {
	
	// Initialize Log4j logs
	 
		 Logger Log = LogManager.getLogger(LogUtil.class);
		 
		 // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
		 
		 protected void startTestCase(String sTestCaseName){
		 
		 Log.info("****************************************************************************************");
		 
		 Log.info("****************************************************************************************");
		 
		 Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		 
		 Log.info("****************************************************************************************");
		 
		 Log.info("****************************************************************************************");
		 
		 }
		 
		 //This is to print log for the ending of the test case
		 
		 protected void endTestCase(String sTestCaseName){
		 
		 Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		 Log.info("X");
		 Log.info("X");
		 
		 }
		  
		 
		 protected void info(String message) {
		 
		 Log.info(message);
		 
		 }
		 
		 protected void warn(String message) {
		 
		    Log.warn(message);
		 
		 }
		 
		 protected void error(String message) {
		 
		    Log.error(message);
		 
		 }
		 
		 protected void fatal(String message) {
		 
		    Log.fatal(message);
		 
		 }
		 
		 protected void debug(String message) {
		 
		    Log.debug(message);
		 
		 }

}
