package com.stargis.service;

import com.stargis.GirlApplicationTests;
import com.stargis.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Chen.YH
 * 2017-04-18 16:03
 */
public class GirlServiceTest extends GirlApplicationTests {
    @Autowired
    private GirlService girlService;
    @Test
    @Transactional
    public void findeOne() throws Exception {
        Girl girl = girlService.findeOne(1);
        System.out.println(girl.getAge());
        Assert.assertEquals(new Integer(8), girl.getAge());
    }

}