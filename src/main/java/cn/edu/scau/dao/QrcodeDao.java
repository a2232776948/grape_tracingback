package cn.edu.scau.dao;

import cn.edu.scau.dao.sql_provider.QrcodeProvider;
import cn.edu.scau.entities.dto.QrcodeCSDTO;
import cn.edu.scau.entities.dto.QrcodeDTO;
import cn.edu.scau.entities.pojo.Qrcode;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QrcodeDao {
    @InsertProvider(type = QrcodeProvider.class,method = "insertQrcode")
    public void insertQrcodes(@Param("q") List<Qrcode> q);

    @Insert("insert into qrcode(qrcode_id) value(#{qrcodeId})")
    public void insertOneQrcode(Qrcode q);

    @SelectProvider(type = QrcodeProvider.class,method = "findLastQrcode")
    public String findLastQrcode(String dateAT);

    @SelectProvider(type = QrcodeProvider.class,method = "deleteQrcode")
    public void deleteQrcode(@Param("qrcodeId") List<String> qrcodeId);


    public List<QrcodeDTO> findAllQrcodeDTO();

    @Select("select qrcode_id from qrcode")
    public List<String>  findAllQrcodeId();

    @SelectProvider(type = QrcodeProvider.class,method = "findQrcodeIdsByCondition")
    public List<String> findQrcodeIdsByCondition(@Param("qrcodeCSDTO") QrcodeCSDTO qrcodeCSDTO);

    @Select("select * from qrcode")
    public List<QrcodeDTO> getAllQrcode();
}
