package com.example.administrator.xiaoxiong.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/11/26 0026.
 */
public class FileUtil {

    public static String inputToString(InputStream localInputStream) throws IOException {
        byte[] buf = new byte[localInputStream.available()];
        localInputStream.read(buf);
        return new String(buf);
    }
}
