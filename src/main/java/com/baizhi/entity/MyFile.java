package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author miion
 * @create 2019-07-18 23:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFile {

    private String id;
    @Value("#{user_id}")
    private  String user_id;
    @Value("#{primeval_name}")
    private  String primeval_name;//原始文件名称
    @Value("#{new_name}")
    private  String new_name ;//新文件名
    private  String suffix; //文件后缀
    private  String path ;//存储路径
    private  String size; //文件大小
    private   String type;//文件类型
    @Value("#{whether_img}")
    private  String whether_img;//是否是图片
    @Value("#{downlad_number}")
    private   Integer download_number;//下载次数；
}
