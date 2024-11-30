package com.myproject.jpademo.commons.Utils;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
@Slf4j
public final class Util {

    public static String getHash(String name, String serialNumber){
        String content = name +serialNumber;
     String  hashcode = DigestUtils.md5Hex(content).toUpperCase();
        log.info("generated hashcode is : {}", hashcode);
        return  hashcode;
    }
}
