package com.trip.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.User;
import com.trip.service.User_service;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
	
    private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User_service getUser_service() {
		return user_service;
	}

	public void setUser_service(User_service userService) {
		user_service = userService;
	}

	private User_service user_service;
	
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

	public void upload() throws Exception {
		
        //HttpServletRequest request = ServletActionContext.getRequest(); 
        
		//HttpSession session = request.getSession();
        
		//User user1 = (User)session.getAttribute("user");
		System.out.println(file.size());
		
		for(int i=0;i<file.size();i++)
		{
			//String rename = user1.getUsername();
			
			//int j = fileFileName.get(i).lastIndexOf(".");
			
			//String type=fileFileName.get(i).substring(j);
			  		   
			InputStream is=new FileInputStream(file.get(i));
			
			String root=ServletActionContext.getRequest().getRealPath("/upload/article");
			
			//File destFile = new File(root,rename+i+type);
			File destFile = new File (root,fileFileName.get(i));
			
			OutputStream os=new FileOutputStream(destFile);
			
			byte[] buffer = new byte[1024];
			
			int length = 0;
			
			while(-1 != (length = is.read(buffer)))
			{
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			
			PrintWriter out = ServletActionContext.getResponse().getWriter(); 
			
			out.println(fileFileName+"上传成功");
			
			//int id=user1.getId();
			
			//System.out.println(id);
			
			//User user2=this.user_service.findUserById(id);
			
			//user2.setAvatar(rename+type);
			
			//this.user_service.updateUser(user2);
			
			//ActionContext.getContext().getSession().put("user", user2);
			
		}
		
		return ;
		
		
	}

}
