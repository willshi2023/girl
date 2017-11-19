package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private  GirlRepository girlRepository;
    @Transactional
    public  void  insertTow(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("d");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(18);
        girlB.setCupSize("dbb");
        girlRepository.save(girlB);
    }
}
