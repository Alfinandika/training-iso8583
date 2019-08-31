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

        AplikasiClient aplikasiClient = new AplikasiClient();
        BigInteger bitmapRequest = aplikasiClient.hitungBitmap(logonRequest);

        String strBitmap = bitmapRequest.toString(2);
        System.out.println("bitmap binary : ["+strBitmap+"]");

        String bitmapHex = bitmapRequest.toString(16);
        System.out.println("bitmap hex : ["+bitmapHex+"]");

        Map<Integer, String> logonResponse = new LinkedHashMap<Integer, String>();
        logonResponse.put(7, formatterBit7.format(new Date()));
        logonResponse.put(11, "834624");
        logonResponse.put(39, "00");
        logonResponse.put(70, "001");

        BigInteger bitmapResponse = aplikasiClient.hitungBitmap(logonResponse);
        System.out.println("bitmap binary response : ["+bitmapResponse.toString(2)+"]");
        System.out.println("bitmap hex response : ["+bitmapResponse.toString(16)+"]");

    }

    public BigInteger hitungBitmap(Map<Integer, String> message){
        BigInteger bitmap = BigInteger.ZERO;

        for(Integer de : message.keySet()){
            if (de > 64) {
                bitmap = bitmap.setBit(128-1);
            }
            bitmap = bitmap.setBit(128-de);
        }

        return bitmap;
    }
}
