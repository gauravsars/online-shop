package net.kzn.onlineshoppping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH ="C:/Users/Gaurabh/gitNew/online-shop/onlineshopping/src/main/webapp/assets/image";
	private static String REAL_PATH="";
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images");
		//make sure all the directories exists.
		//if it does not exists then please create the directory for me..
		
		if(!new File(ABS_PATH).exists()){
			//create the directories
			new File(ABS_PATH).mkdirs();
		}
		if(!new File(REAL_PATH).exists()){
			//create the directories
			new File(REAL_PATH).mkdirs();
		}
		
		try{
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			file.transferTo(new File(ABS_PATH+code+".jpg"));
		}
		catch(IOException e){
			
		}
		
		
		
				
		
	}

}
