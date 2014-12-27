package com.trip.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Upload_avatar extends ActionSupport {

	
private List<File> file;
	
    private List<String> fileFileName;
	
	private List<String> fileContentType;
	
	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String execute() throws Exception {
		for(int i=0;i<file.size();i++)
		{
			InputStream is=new FileInputStream(file.get(i));
			
			String root=ServletActionContext.getRequest().getRealPath("/upload/avatar");
			
			File destFile = new File(root,fileFileName.get(i));
			
			OutputStream os=new FileOutputStream(destFile);
			
			byte[] buffer = new byte[1024];
			
			int length = 0;
			
			while(-1 != (length = is.read(buffer)))
			{
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		}
		
		
		
		return "upload_success";
	}
}
