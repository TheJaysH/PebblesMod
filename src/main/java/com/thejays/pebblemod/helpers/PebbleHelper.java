package com.thejays.pebblemod.helpers;

import net.minecraft.resources.ResourceLocation;

import java.text.MessageFormat;


public class PebbleHelper {


    public static String getResourcePath(String modId, String folder, String resource){
        return MessageFormat.format("{0}:{1}/{2}", modId, folder, resource);
    }

    public static String getResourcePath(String folder, String resource){
        return MessageFormat.format("{0}/{1}", folder, resource);
    }


    public static ResourceLocation getResourceLocation(String resourcePath){
        return new ResourceLocation(resourcePath);
    }

    public static String getSuffix(int i){
        return i == 0 ? "" : "_" + (i + 1);
    }

    public static Integer getInteger(int value, int addition){
        return Integer.valueOf(value + addition);
    }

    public static Integer getInteger(int value){
        return getInteger(value, 1);
    }

}
