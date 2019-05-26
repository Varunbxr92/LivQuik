package com.weather.livquik.Utility;


public class Assert {
    public static void notNull(Object obj, String message){
        if(obj == null) throw new IllegalArgumentException(message);
    }

    public static void notBlank(String str, String message){
        notNull(str, message);

        int strLength = str.length();
        int blankCtr = 0;
        for(int i = 0; i < strLength; i++){
            Character strChar = Character.valueOf(str.charAt(i));
            if(!strChar.equals(' ')) break;

            blankCtr ++;
        }
        if(blankCtr == strLength) throw new IllegalArgumentException(message);
    }

    public static void isTrue(boolean bool, String message){
        if(!bool) throw new IllegalArgumentException(message);
    }
}
