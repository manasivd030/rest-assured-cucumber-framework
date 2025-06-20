package config;

import org.aeonbits.owner.ConfigCache;

public class PropertyUtil {
    public static PropertyConfig getConfig()
    {
        return ConfigCache.getOrCreate(PropertyConfig.class);
    }

    public static void main(String[] args)
    {
        System.out.println(getConfig().baseUrl());
    }
}
