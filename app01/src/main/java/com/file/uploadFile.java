package com.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class uploadFile {

	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
	public static String downloadFile(String filename,HttpServletRequest request,HttpServletResponse response){
         String downloadFilePath = request.getSession().getServletContext().getRealPath("/files");//被下载的文件在服务器中的路径,
         String fileName = "模型.xlsx";//被下载文件的名称
         
         File file = new File(downloadFilePath + "\\" + fileName);
         if (file.exists()) {
             response.setContentType("application/force-download");// 设置强制下载不打开            
             response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
             byte[] buffer = new byte[1024];
             FileInputStream fis = null;
             BufferedInputStream bis = null;
             try {
                 fis = new FileInputStream(file);
                 bis = new BufferedInputStream(fis);
                 OutputStream outputStream = response.getOutputStream();
                 int i = bis.read(buffer);
                 while (i != -1) {
                     outputStream.write(buffer, 0, i);
                     i = bis.read(buffer);
                 }
               
                 return "下载成功";
             } catch (Exception e) {
                 e.printStackTrace();
             } finally {
                 if (bis != null) {
                     try {
                         bis.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
                 if (fis != null) {
                     try {
                         fis.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
        return "下载失败";    
     }
	
//    public static void downloadFile(String filename,HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	try {
//    			String fileName = "模型.xlsx";
//    			String fileSaveRootPath=request.getSession().getServletContext().getRealPath("/files");
//    			File file = new File(fileSaveRootPath + "\\" + fileName);
//    			if(!file.exists()){
//    	               System.out.println("message您要下载的资源已被删除！！");
//    	               return;
//    	           }
//    			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//    			InputStream fis = new BufferedInputStream(new FileInputStream(fileSaveRootPath + "\\" + fileName));
//    			byte[] buffer = new byte[fis.available()];
//    			fis.read(buffer);  //读取文件流
//    			fis.close();//关闭文件流
//	            response.reset();
//	            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
//	            response.addHeader("Content-Length", "" + file.length());  //返回头 文件大小 
//	            response.setContentType("application/octet-stream");
//	          ///获取返回体输出权           
//	            OutputStream os = new BufferedOutputStream(response.getOutputStream());
//	            // 输出文件           
//	            os.write(buffer);           
//	            os.flush();           
//	            os.close();       
//	            } 
//    			catch (IOException e) { 
//			    	e.printStackTrace();     
//			    	} 
//    			
//    }
}
