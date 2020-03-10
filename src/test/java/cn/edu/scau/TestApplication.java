package cn.edu.scau;

import cn.edu.scau.entities.pojo.Farmop;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplication {
    @Test
    void test1(){
        Farmop f = new Farmop();
        //System.out.println(Farmop);
        System.out.println(f.getClass());
    }
}
