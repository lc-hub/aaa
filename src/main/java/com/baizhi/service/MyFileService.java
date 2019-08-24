package com.baizhi.service;

import com.baizhi.entity.MyFile;

import java.util.List;

/**
 * @author miion
 * @create 2019-07-21 15:45
 */
public interface MyFileService {
    //    查所有
    List<MyFile> findAll();
    //    删除
    void delete(String id);
    //    添加
    void save(MyFile myFile);
    //    id 查询
    MyFile fileById(String id);
}
