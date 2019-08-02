package com.file.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.file.uploadFile;
import com.file.entity.ShareFile;
import com.file.service.ShareFileService;

@Controller //声明为一个Restful的Controller
@RequestMapping("/shareFileController")
public class ShareFileController {
  @Autowired //自动连接到UserService Bean
  private ShareFileService shareFileService;

  @RequestMapping(value = "/file")
  public String show() {
    return "shareFile";
  }
  
  @ResponseBody
  @RequestMapping(value = "/fileList")
  public Object showFile() {
	  List<ShareFile> fileList = shareFileService.showAllFile();
	  Map<String,Object> map = new HashMap<>();
	  map.put("total", "10");
	  map.put("rows", fileList);
	  return map;
  }
  
 /**
  * 添加文件
  * @author liuhaiwan
  * @return
  */
  @RequestMapping(value="/onlineupload", method = RequestMethod.POST)
  @ResponseBody
  public Map<String,String> onlineupload(@RequestParam("fileName") MultipartFile file,HttpServletRequest request) {
//      String contentType = file.getContentType();
      Map<String,String> map=new HashMap<>();
      String fileName = file.getOriginalFilename();
      String content = request.getParameter("fileContent");
      String remark = request.getParameter("remark");
      ShareFile shareFile = new ShareFile();
      shareFile.setFileName(fileName);
      shareFile.setFileContent(content);
      shareFile.setRemark(remark);
	  shareFileService.insert(shareFile);
      fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
      String realPath = request.getSession().getServletContext().getRealPath("/");
//      System.out.println("fileName"+fileName);
//      String filePath="D:\\fileupload\\";
//      System.out.println("filePath"+filePath);
	 
      try {
    	  uploadFile.uploadFile(file.getBytes(), realPath, fileName);
      } catch (Exception e) {
          // TODO: handle exception
      }
      //返回json
//      System.out.println("file + success!");
      if(file==null){
          map.put("error","false");
      }
      map.put("success","true");  
      return map;
  }
  
  @ResponseBody
  @RequestMapping("/download")
  public void  downlodFile(@RequestParam(value = "ids") int[] ids,HttpServletRequest request,HttpServletResponse response) throws IOException{
//	  String downId = Arrays.toString(ids);
	  for(int i = 0; i<ids.length; i++)
	  {
		  ShareFile shareFile = shareFileService.showFileInfo(ids[i]);
		  String fileName = shareFile.getFileName();
		  uploadFile.downloadFile(fileName,request, response);
	  }
//	  ShareFile shareFile = shareFileService.showFileInfo(id);
//	  return shareFile;
  }
  
//  @ResponseBody
//  @RequestMapping(value="/updateFile")
//  public String  updateFile(ShareFile shareFile){
//	  shareFileService.updateFile(shareFile);
//	  return "sccess";
//  }
  
  @ResponseBody
  @RequestMapping(value="/delFile")
  public Map<String,String> delFile(@RequestParam(value = "ids") int[] ids) {
	  for(int i = 0; i<ids.length; i++)
	  {
		  shareFileService.delFile(ids[i]);
	  }
	   String result = "1";
	   Map<String,String> map = new HashMap<>();
	   map.put("success", result);
	   return map;
  }
  
}

