package com.vignesh.MoveFiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.jni.Directory;



public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletFileUpload sr = new ServletFileUpload(new DiskFileItemFactory());
		try {
			
			List<FileItem> mulFiles=sr.parseRequest(request);
			
			
			for(FileItem item:mulFiles) {
				item.write(new File("your path"+item.getName()));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
