package cn.edu.scau.constent;

import java.text.DecimalFormat;

public class Qr {
    public static String baseQrUri = "";
    public static String baseImageURL="";
    public static String treeImagePath="/tree";
    public static String areaImagePath="/area";
    public static String qrcodeImagePath="/qrcode";

    public static int symbolOnlyTreeFarmOp = 10000;


    public static String numTransFormat(String lastOrder,String patter,int shift){
        DecimalFormat df3=new DecimalFormat(patter);
        lastOrder = String.valueOf(df3.format(Integer.parseInt(lastOrder)+shift));
        return lastOrder;
    }

    public static String longToStringFormat(long num,String patter){
        DecimalFormat df3=new DecimalFormat(patter);
        String s = String.valueOf(df3.format(num));
        return s;
    }
}
