package com.arka99.AB_Bank_Backend.constants;

public class KeyGenerator {
    public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    public static final String JWT_HEADER = "Authorization";
    private static String key = generateKey();
    private static String generateKey() {
        String myChars ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<myChars.length();i++) {
            int index = (int) (myChars.length() * Math.random());
            builder.append(myChars.charAt(index));
        }
        return builder.toString();
    }
    public static String getKey() {
        return key;
    }
}
