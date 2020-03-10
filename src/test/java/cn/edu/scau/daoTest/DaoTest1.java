package cn.edu.scau.daoTest;

import cn.edu.scau.TestApplication;
import cn.edu.scau.dao.AreaDao;
import cn.edu.scau.dao.FarmopDao;
import cn.edu.scau.entities.pojo.Area;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoTest1 extends TestApplication{
    @Autowired
    AreaDao areaDao;
    @Autowired
    FarmopDao farmopDao;

    @Ignore
    @Test
    void areaTest(){
        Area oneArea = areaDao.findOneArea(1);
        System.out.println(oneArea);
        System.out.println(oneArea.getAreaName());
    }

    @Test
    void findFarmopById(){
        System.out.println(farmopDao.findOneFarmopById(1));
    }
}
