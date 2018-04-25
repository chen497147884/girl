package com.stargis.controller;

import com.stargis.domain.Girl;
import com.stargis.domain.Result;
import com.stargis.repository.GirlRepository;
import com.stargis.service.GirlService;
import com.stargis.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Chen.YH on 2017-04-07.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    private final Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * 查询所有女生列表
     * @return
     */
    //@PostMapping(value = "/girls")
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("---------------girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                     @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls2")
    public Girl girlAdd2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }
    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls3")
    public Result<Girl> girlAdd3(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            Result result = new Result();
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            return result;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

//        girl.setCupSize(girl.getCupSize());
//        girl.setAge(girl.getAge());

//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("成功");
//        result.setData(girlRepository.save(girl));
        return ResultUtil.success(girlRepository.save(girl));
    }
    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新一个女生
     * @param id
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        System.out.println("========================");
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @GetMapping(value = "girls/getAge/{id}")
    public Girl getAge(@PathVariable("id") Integer id) throws Exception{
       return girlService.getAge(id);
    }

}
