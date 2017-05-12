package com.stargis;

import com.stargis.domain.Girl;
import com.stargis.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by Chen.YH
 * 2017-04-18 15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    @Transactional
    public void findOneTest(){
        Girl girl = girlService.findeOne(1);
        System.out.println(girl.getAge());
        Assert.assertEquals(new Integer(8), girl.getAge());
    }
}
