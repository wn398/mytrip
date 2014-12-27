package com.trip.Servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ValidationCode extends HttpServlet {
	
	 // ͼ����֤����ַ����ϣ�ϵͳ�����������ַ�����ѡ��һЩ�ַ���Ϊ��֤�� 
	private static String codeChars = "%#23456789abcdefghkmnpqrstuvwxyzABCDEFGHKLMNPQRSTUVWXYZ";

	// ����һ�������ɫ��Color����	
	private static Color getRandomColor(int minColor, int maxColor)
	{
		Random random = new Random();
		// ����minColor��󲻻ᳬ��255
		if (minColor > 255)
			minColor = 255;
		//  ����minColor��󲻻ᳬ��255
		if (maxColor > 255)
			maxColor = 255;
		//  ��ú�ɫ�������ɫֵ
		int red = minColor + random.nextInt(maxColor - minColor);
		//  �����ɫ�������ɫֵ
		int green = minColor + random.nextInt(maxColor - minColor);
		//  �����ɫ�������ɫֵ
		int blue = minColor + random.nextInt(maxColor - minColor);
		return new Color(red, green, blue);
	}
	

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//  �����֤�뼯�ϵĳ���
		int charsLength = codeChars.length();

		//  ����������¼�ǹرտͻ���������Ļ�����
		//  ��������䶼���Թر�������Ļ���������������������İ汾��ͬ��������������֧��Ҳ��ͬ
		//  ��ˣ�Ϊ�˱������������ͬʱʹ��������������ر�������Ļ�����
		response.setHeader("ragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		//  ����ͼ����֤��ĳ��Ϳ�ͼ�εĴ�С��
		int width = 90, height = 20;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);		
		Graphics g = image.getGraphics();//  �������������ֵ�Graphics����
		Random random = new Random();
		g.setColor(getRandomColor(180, 250));// �������Ҫ������ɫ
		g.fillRect(0, 0, width, height);//  ���ͼ�α���
		//  ���ó�ʼ����
		g.setFont(new Font("Times New Roman", Font.ITALIC, height));
		
		g.setColor(getRandomColor(120, 180));// �������������ɫ
	    //  ���ڱ������������ɵ���֤��
		StringBuilder validationCode = new StringBuilder();
		//  ��֤����������
		String[] fontNames = { "Times New Roman", "Book antiqua",  "Arial" };
        //  �������3����5����֤��
		for (int i = 0; i < 3 + random.nextInt(3); i++)
		{
			//  ������õ�ǰ��֤����ַ�������
			g.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC,
					height)); 
			//  �����õ�ǰ��֤����ַ�
			char codeChar = codeChars.charAt(random.nextInt(charsLength));
			validationCode.append(codeChar);			
			//  ������õ�ǰ��֤���ַ�����ɫ
			g.setColor(getRandomColor(10, 100));
			//  ��ͼ���������֤���ַ���x��y����������ɵ�			
			g.drawString(String.valueOf(codeChar), 16 * i + random.nextInt(7),
					height - random.nextInt(6));


		}
		//  ���HttpSession����
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(5 * 60);  // ����session����5����ʧЧ
		//  ����֤�뱣����session�����У�keyΪvalidation_code
		session.setAttribute("validation_code", validationCode.toString());
		
		g.dispose();//  �ر�Graphics����
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "JPEG", os);// ��JPEG��ʽ��ͻ��˷���ͼ����֤��
	}
	 
	
	//  �˶��û��������֤���Ƿ�Ϸ�
	
	
	public static boolean checkValidationCode(HttpServletRequest request, String validationCode)
	{
		//  ��HttpSession�����л��ϵͳ������ɵ���֤��
		String validationCodeSession = (String)request.getSession().getAttribute("validation_code");
		
		//  �����õ���֤��Ϊnull��˵����֤����ڣ��û�����ˢ�¿ͻ���ҳ�棬�����»���µ���֤��
		if(validationCodeSession == null)
		{			
			request.setAttribute("info", "��֤�����");//  ����result.jsp��Ҫ�Ľ����Ϣ
			request.setAttribute("codeError", "��֤�����");//  ����login.jsp��Ҫ�Ҵ�����Ϣ	
			return false;
		}
		//  ���û��������֤���ϵͳ������ɵ���֤����бȽ�
		if(!validationCode.equalsIgnoreCase(validationCodeSession))
		{
			request.setAttribute("info", "��֤�벻��ȷ");//  ����result.jsp��Ҫ�Ľ����Ϣ
			request.setAttribute("codeError", "��֤�벻��ȷ");//  ����login.jsp��Ҫ�Ҵ�����Ϣ
			return false;
		}
		return true;
	}
}
