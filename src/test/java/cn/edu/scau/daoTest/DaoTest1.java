package cn.edu.scau.daoTest;

import cn.edu.scau.TestApplication;
import cn.edu.scau.dao.*;
import cn.edu.scau.dao.sql_provider.QuaInfProvoder;
import cn.edu.scau.entities.dto.FarmopDTO;
import cn.edu.scau.entities.pojo.*;
import cn.edu.scau.entities.vo.AmountConditionVO;
import cn.edu.scau.entities.vo.FarmopConditionVO;
import cn.edu.scau.exception.GlobalException;
import cn.edu.scau.service.impl.FarmopServiceImpl;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoTest1 extends TestApplication{
    @Autowired
    AreaDao areaDao;
    @Autowired
    FarmopDao farmopDao;
    @Autowired
    FarmopServiceImpl farmopService;
    @Autowired
    QrcodeDao qrcodeDao;
    @Autowired
    QuaInfDao quaInfDao;
    @Autowired
    AmountDao amountDao;
    @Autowired
    UserDao userDao;

    @Ignore
    @Test
    void areaTest(){
        Area oneArea = areaDao.findOneArea(1);
        System.out.println(oneArea);
        System.out.println(oneArea.getAreaName());
    }

    @Ignore
    @Test
    void findFarmopById(){
        System.out.println(farmopDao.findOneFarmopById(1));
    }

    @Ignore
    @Test
    void insertOneFarmop(){
        //FarmopDTO farmopDTO = new FarmopDTO(1,2,"施肥1千克","2019-2-3","施肥","李四");
        //farmopService.insertOneFarmop(farmopDTO);
    }

    @Ignore
    @Test
    void findFarmopByCondition() throws GlobalException {
        //FarmopConditionVO farmopConditionVO = new FarmopConditionVO(1,2,"施肥3千克",new Date("2012-2-2"),new Date("2020-5-2"),null,null);
        FarmopConditionVO farmopConditionVO = new FarmopConditionVO(1,2,"施肥","2010-2-3",null,null,null);
        List<FarmopDTO> farmopByCondition = farmopService.getFarmopByCondition(farmopConditionVO);
        System.out.println(farmopByCondition);
    }

    @Ignore
    @Test
    void utilTest(){
        System.out.println(new Date(2020-1900,2,3));
    }

    @Ignore
    @Test
    void addFarmops(){
        List<Farmop> farmops = new ArrayList<>();
        farmops.add(new Farmop());
        farmops.add(new Farmop(1,2,3,"打药",2,"2010-2-3","李四"));
        farmopDao.addFarmops(farmops);
    }

    @Test
    void updateOneFarmop(){
        Farmop farmop = new Farmop(1, 2, 3, "打药", 2, "2010-2-3", "王五");
        farmopDao.updateOneFarmop(farmop);
    }

    @Test
    void deleteOneFarmop(){
        List<Integer> ids = new ArrayList<Integer>();
        farmopService.deleteFarmop(ids);
    }

    @Test
    void findQr(){
        System.out.println(qrcodeDao.findLastQrcode("2019"));
    }

    @Test
    void quaInfTest1(){
        QuaInf quaInf = new QuaInf(0,1,"","qwer!","imageName");
        quaInfDao.insertQuaInf(quaInf);
        //QuaInfProvoder quaInfProvoder = new QuaInfProvoder();
        //quaInfProvoder.insertQuaInf(quaInf);
    }

    @Test
    void amountTest(){
        AmountConditionVO amountConditionVO = new AmountConditionVO(2L ,0L,0L);
        List<Amount> amountsByCondition = amountDao.getAmountsByCondition(amountConditionVO);
        System.out.println(amountsByCondition);
    }

    @Test
    void getUserByName(){
        User sd = userDao.selectOne("sd");
        System.out.println(sd);
    }
}
