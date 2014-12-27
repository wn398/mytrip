package test;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class testfile extends ActionSupport{
	
	
	
	@SuppressWarnings("deprecation")
	public static void main (String[] args) {
		
		String root=ServletActionContext.getRequest().getRealPath("/upload/image/");
		// root=
		String path= root;
		String filename ="wn398&20111007010452&76225.jpg";
		File file=new File(path+"/"+filename);
	       if(file.exists()&&file.isFile())
	       { file.delete();
	        System.out.println("success");
	       }
	
	}
	
}
