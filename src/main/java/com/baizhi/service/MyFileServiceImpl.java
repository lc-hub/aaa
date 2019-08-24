package com.baizhi.service;

import com.baizhi.dao.MyFileDAO1;
import com.baizhi.entity.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author miion
 * @create 2019-07-21 15:47
 */
@Service
@Transactional
public class MyFileServiceImpl implements MyFileService {

    @Autowired
    private MyFileDAO1 myFileService;

    @Override
    public List<MyFile> findAll() {
        List<MyFile> all = myFileService.findAll();

        return all;
    }

    @Override
    public void delete(String id) {
        myFileService.delete(id);
    }

    @Override
    public void save(MyFile myFile) {
        myFileService.save(myFile);
    }

    @Override
    public MyFile fileById(String id) {
        MyFile myFile = myFileService.fileById(id);
        return myFile;
    }
}
