package com.alfinandika.iso8583.hitungbitmap;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class AplikasiClient {
    public static void main(String[] args){
        DateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");

        Map<Integer, String> logonRequest = new LinkedHashMap<Integer, String>();
        logonRequest.put(7, formatterBit7.format(new Date()));
        logonRequest.put(11, "834624");
        logonRequest.put(70, "001");

        BigInteger bitmap = BigInteger.ZERO.setBit(128-0);
        bitmap = bitmap.setBit(128-7);
        bitmap = bitmap.setBit(128-11);
        bitmap = bitmap.setBit(128-70);

        String strBitmap = bitmap.toString(2);
        System.out.println("bitmap : ["+strBitmap+"]");
    }
}
