package com.trip.util;
import java.awt.AlphaComposite;   
import java.awt.Color;   
import java.awt.Font;   
import java.awt.Graphics2D;   
import java.awt.Image;   
import java.awt.geom.AffineTransform;   
import java.awt.image.AffineTransformOp;   
import java.awt.image.BufferedImage;   
import java.io.File;   
import java.io.IOException;   
  
import javax.imageio.ImageIO;   
  
/**  
* @author Eric Xu  
*  
*/  
public final class ImageUtils {   
    /**  
     * ͼƬˮӡ  
     * @param pressImg ˮӡͼƬ  
     * @param targetImg Ŀ��ͼƬ  
     * @param x ����ֵ Ĭ�����м�  
     * @param y ����ֵ Ĭ�����м�  
     * @param alpha ͸����  
     */  
    public final static void pressImage(String pressImg, String targetImg, int x, int y, float alpha) {   
        try {   
            File img = new File(targetImg);   
            Image src = ImageIO.read(img);   
            int wideth = src.getWidth(null);   
            int height = src.getHeight(null);   
            BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);   
            Graphics2D g = image.createGraphics();   
            g.drawImage(src, 0, 0, wideth, height, null);   
            //ˮӡ�ļ�   
            Image src_biao = ImageIO.read(new File(pressImg));   
            int wideth_biao = src_biao.getWidth(null);   
            int height_biao = src_biao.getHeight(null);   
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));   
            g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height - height_biao) / 2, wideth_biao, height_biao, null);   
            //ˮӡ�ļ�����   
            g.dispose();   
            ImageIO.write((BufferedImage) image, "jpg", img);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
  
    /**  
     * ����ˮӡ  
     * @param pressText ˮӡ����  
     * @param targetImg Ŀ��ͼƬ  
     * @param fontName ��������  
     * @param fontStyle ������ʽ  
     * @param color ������ɫ  
     * @param fontSize �����С  
     * @param x ����ֵ  
     * @param y ����ֵ  
     * @param alpha ͸����  
     */  
    public static void pressText(String pressText, String targetImg, String fontName, int fontStyle, Color color, int fontSize, int x, int y, float alpha) {   
        try {   
            File img = new File(targetImg);   
            Image src = ImageIO.read(img);   
            int width = src.getWidth(null);   
            int height = src.getHeight(null);   
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
            Graphics2D g = image.createGraphics();   
            g.drawImage(src, 0, 0, width, height, null);   
            g.setColor(color);   
            g.setFont(new Font(fontName, fontStyle, fontSize));   
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));   
            g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);   
            g.dispose();   
            ImageIO.write((BufferedImage) image, "jpg", img);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
  
    /**  
     * ����  
     * @param filePath ͼƬ·��  
     * @param height �߶�  
     * @param width ���  
     * @param bb ��������ʱ�Ƿ���Ҫ����  
     */  
    @SuppressWarnings("static-access")
	public static void resize(String filePath, int height, int width, boolean bb) {   
        try {   
            double ratio = 0.0; //���ű���    
            File f = new File(filePath);   
            BufferedImage bi = ImageIO.read(f);   
            Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);   
            //�������   
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {   
                if (bi.getHeight() > bi.getWidth()) {   
                    ratio = (new Integer(height)).doubleValue() / bi.getHeight();   
                } else {   
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();   
                }   
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);  
                itemp = op.filter(bi, null);   
            }   
            if (bb) {   
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
                Graphics2D g = image.createGraphics();   
                g.setColor(Color.white);   
                g.fillRect(0, 0, width, height);   
                if (width == itemp.getWidth(null))   
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
                else  
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
                g.dispose();   
                itemp = image;   
            }   
            ImageIO.write((BufferedImage) itemp, "jpg", f);   
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }   
  
    public static void main(String[] args) throws IOException {   
        //pressImage("G:\\imgtest\\sy.jpg", "G:\\imgtest\\test1.jpg", 0, 0, 0.5f);   
        pressText("Ѱ �� �� ��", "C:\\1.jpg", "����", 50, Color.gray, 80, 0, 0, 0.3f);   
        //resize("G:\\imgtest\\test1.jpg", 500, 500, true);   
    }   
  
    public static int getLength(String text) {   
        int length = 0;   
        for (int i = 0; i < text.length(); i++) {   
            if (new String(text.charAt(i) + "").getBytes().length > 1) {   
                length += 2;   
            } else {   
                length += 1;   
            }   
        }   
        return length / 2;   
    }   
}