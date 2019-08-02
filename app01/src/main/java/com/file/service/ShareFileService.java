package com.file.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.file.entity.ShareFile;
import com.file.mapper.ShareFileMapper;
 
@Service //声明成一个spring bean
public class ShareFileService {
 
  @Autowired //连接到UserDao Bean
  private ShareFileMapper shareFileMapper;
 
 
  public List<ShareFile> showAllFile() {
	    return shareFileMapper.getAllFile();
	  }
  
  public ShareFile showFileInfo(int id) {
    return shareFileMapper.getFileInfo(id);
  }
  
  public String updateFile(ShareFile shareFile) {
	  shareFileMapper.updateFile(shareFile);
	   return null;
  }
 
  public String insert(ShareFile shareFile) {
    
    shareFileMapper.insert(shareFile);
    return "";
  }
  
  public String delFile(int id) {
	  return shareFileMapper.delFile(id);
  }
  
//  public String update(User user) {
//	   userDao.update(user);
//	   return "success";
//  }
  
//  public User selectByPhone(String memPhone) {
//	    return userDao.getPhon(memPhone);
//	  }
  
}