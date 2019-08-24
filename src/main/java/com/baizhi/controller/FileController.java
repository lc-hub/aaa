package com.baizhi.controller;

import com.baizhi.entity.MyFile;
import com.baizhi.entity.User;
import com.baizhi.service.MyFileService;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author miion
 * @create 2019-07-21 16:05
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private MyFileService myFileService;

    private  static Logger logger = Logger.getLogger(FileController.class);




    // 查看所有
    @RequestMapping("/findAll")
    public String findAll(Model model){


        List<MyFile> all = myFileService.findAll();
        model.addAttribute("files",all);

        return "main";
    }


    //    文件上传
    @RequestMapping("/upload")
    public String upload(MultipartFile fileName, HttpServletResponse response, HttpServletRequest request)throws IOException {

        //        根据文件的相对路径获取文件的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("files");
//        创建当前日期，命名日期文件夹
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//        创建文件夹对象 路径放在realPath  名称 为format
        File file = new File(realPath, format);

//        判断是否是当天第一次上传  如果是侧创建新的文件夹  如果不是侧不创建
        if(!file.exists()){//判断文件夹是否存在  取反
            file.mkdirs();
        }



//          创建文件id
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
//          获取文件用户的id
        User user = (User)request.getSession().getAttribute("user");
        String uid = user.getId();

        //         获取文件的原始名称  fileName
        String name = fileName.getOriginalFilename();
//           获取文件的新名称
        UUID newUuid = UUID.randomUUID();
        String newID = newUuid.toString();
//           获取文件的后缀
        String ext = FilenameUtils.getExtension(fileName.toString());

        System.out.println(ext+"-----------------=========="+fileName);

        String mimeType = request.getSession().getServletContext().getMimeType("."+ext);
        System.out.println(mimeType+"文件后缀-----------------==========");
//            获取文件的路径
        String path = "files/"+format;

//            获取文件大小
        long size = fileName.getSize();
        Long si = size;
        String s = si.toString();

//           文件类型
        String type = fileName.getContentType();
//            是否是图片
        List<String> list = new ArrayList<>();
        list.add("image/png");
        list.add("image/jpeg");
        list.add("image/jpg");
        String img ="否";
        for (String s1 : list) {
            if(s1.equals(type)){
                img ="是";
            }
        }



//              下载次数
        Integer number = 0;
        MyFile myFile = new MyFile(id, uid, name, newID, mimeType, path, s, type, img, number);
//         将上传的文件存到数据库
        myFileService.save(myFile);



//         上传文件
        fileName.transferTo(new File(file,newID));

        logger.debug(fileName);
        logger.debug(realPath);
        logger.debug(format);
        logger.debug(myFile);

        return "forward:/file/findAll";
    }


//    w文件下载


}
