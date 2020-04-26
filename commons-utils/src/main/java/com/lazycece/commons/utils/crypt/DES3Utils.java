package com.lazycece.commons.utils.crypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * DES3 ECB encrypt and decrypt
 *
 * @author lazycece
 * @date 2019/11/20
 */
public class DES3Utils {

    public static byte[] encrypt(final String secret, String data) throws Exception {
        return crypto(secret, Cipher.ENCRYPT_MODE, data.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] decrypt(final String secret, byte[] data) throws Exception {
        return crypto(secret, Cipher.DECRYPT_MODE, data);
    }

    private static byte[] crypto(String secret, int mode, byte[] data) throws Exception {
        DESedeKeySpec spec = new DESedeKeySpec(secret.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("desede");
        SecretKey desKey = keyFactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");
        cipher.init(mode, desKey);
        return cipher.doFinal(data);
    }
}
