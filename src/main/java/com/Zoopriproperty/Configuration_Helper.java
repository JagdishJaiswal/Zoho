package com.Zoopriproperty;

import java.io.IOException;

public class Configuration_Helper {
	


	
		
		private Configuration_Helper() {
			
		}
		
		public static Configuration_Read getInstance() throws IOException {
			
			Configuration_Read coreader = new Configuration_Read();
			
			return coreader;
			
		}
		

	}


