package cn.edu.scau.dao.sql_provider;

import cn.edu.scau.constent.Qr;
import cn.edu.scau.entities.dto.QrcodeCSDTO;
import cn.edu.scau.entities.pojo.Qrcode;
import cn.edu.scau.util.Transform;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class QrcodeProvider {
    public String insertQrcode(List<Qrcode> q){
        return new SQL(){
            {
                INSERT_INTO("qrcode");
                INTO_COLUMNS("qrcode_id");
                for(Qrcode qq:q){
                    //VALUES("qrcode_id",String.valueOf(qq.getQrcodeId()));
                    INTO_VALUES(String.valueOf(qq.getQrcodeId()));
                }

            }
        }.toString();
    }

    public String findLastQrcode(String dateAT){
        return new SQL(){
            {
                SELECT("max(qrcode_id)");
                FROM("qrcode");
                WHERE("qrcode_id like '"+dateAT+"%'");
            }
        }.toString();
    }

    public String deleteQrcode(List<String> qrcodeId){
        String ids = "(";
        for(String s: qrcodeId){
            ids+=s+',';
        }
        ids = ids.substring(0,ids.length()-1);
        ids+=')';
        String finalIds = ids;
        return new SQL(){
            {
                DELETE_FROM("qrcode");
                WHERE("qrcode_id in"+ finalIds);
            }
        }.toString();
    }

    public String findQrcodeIdsByCondition(QrcodeCSDTO qrcodeCSDTO){
        return new SQL(){
            {
                SELECT("qrcode_id");
                FROM("qrcode");
                if ((qrcodeCSDTO.getQrcodeId()!=null && qrcodeCSDTO.getQrcodeId()!="")){
                    WHERE("qrcode_id ="+qrcodeCSDTO.getQrcodeId());
                }
                if(qrcodeCSDTO.getAreaId()!=0){
                    String s = Qr.numTransFormat(String.valueOf(qrcodeCSDTO.getAreaId()),"00",0);
                    WHERE("qrcode_id like '________"+ s +"_____'");
                }
                if(qrcodeCSDTO.getTreeId()!=0){
                    String s = Qr.numTransFormat(String.valueOf(qrcodeCSDTO.getTreeId()),"00",0);
                    WHERE("qrcode_id like '__________"+s+"___'");
                }
                if(qrcodeCSDTO.getStartDate()!=null && qrcodeCSDTO.getStartDate()!=""){
                    WHERE(" create_time>=" + qrcodeCSDTO.getStartDateFormat());
                    if(qrcodeCSDTO.getEndDate()!=null && qrcodeCSDTO.getEndDateFormat()!="") {
                        WHERE("create_time<=" + qrcodeCSDTO.getEndDateFormat());
                    }
                }else{
                    if(qrcodeCSDTO.getEndDate()!=null && qrcodeCSDTO.getEndDate()!="")  {
                        WHERE("create_time<=" + qrcodeCSDTO.getEndDateFormat());
                    }
                }
            }
        }.toString();
    }
}
