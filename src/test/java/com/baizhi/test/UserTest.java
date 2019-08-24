package com.baizhi.test;

import com.baizhi.Application;
import com.baizhi.dao.MyFileDAO1;
import com.baizhi.dao.UserDaO;
import com.baizhi.entity.MyFile;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author miion
 * @create 2019-07-21 14:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Autowired
    private UserDaO userDaO;
    @Autowired
    private MyFileDAO1 myFile;
    @Test
    public void  testLogiun(){
        User lc = userDaO.login("lc", "123456");
        System.out.println(lc);


    }

    @Test
    public void testALl(){
        MyFile mFile1 = new MyFile(
                UUID.randomUUID().toString(),
                "1",
                "1.txt",
                UUID.randomUUID().toString(),
                ".txt",
                "/files/",
                "1024",
                "txt",
                "f否",
                2
        );
        myFile.save(mFile1);
    }


    @Test
    public  void testFindAll(){
        List<MyFile> all = myFile.findAll();
        for (MyFile file : all) {
            System.out.println(file );

        }

    }
}
