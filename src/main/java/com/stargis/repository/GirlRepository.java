package com.stargis.repository;

import com.stargis.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Chen.YH on 2017-04-07.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
