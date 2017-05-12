package com.stargis.service;

import com.stargis.domain.Girl;
import com.stargis.enums.ResultEnum;
import com.stargis.handle.GirlException;
import com.stargis.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Chen.YH
 * 2017-04-07 17:34
 */
@Service
public class GirlService {
   @Autowired
    private GirlRepository girlRepository;
   @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(20);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBBBB");
        girlB.setAge(21);
        girlRepository.save(girlB);
    }

    public Girl getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            //返回“你还在上小学吧” code=100

            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age >10 && age < 16){

            //返回“你可能还在上初中” code=101
            throw new GirlException(ResultEnum.MINDDLE_SCHOOL);
        }else{
            return girl;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public  Girl findeOne(Integer id){

        return girlRepository.getOne(id);
    }
}
