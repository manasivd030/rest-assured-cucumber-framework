/*
📁 package config;
Declares that this interface is part of the config package.

        📦 import org.aeonbits.owner.Config;
Imports the Config interface from the Owner library, which is a Java framework for managing configuration properties.

🔧 @Config.Sources("classpath:config.properties")
This annotation tells the Owner library to load properties from the config.properties file located in the classpath (typically in src/main/resources or resources/).

        🔑 public interface PropertyConfig extends Config { ... }
This creates a configuration interface that extends Owner's Config interface. The methods inside this interface will correspond to keys in your .properties file.

        🧩 @Key("baseUrl")
This annotation binds the baseUrl() method to the property key baseUrl in the config.properties file.

properties
        Copy
Edit
# config.properties
        baseUrl=https://example.com/api
        🎯 String baseUrl();
When called, this method will return the value of baseUrl from the properties file, e.g., https://example.com/api.

*/
package config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:config.properties")
public interface PropertyConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("connection.timeout")
    Integer connectionTimeout();

    @Key("socket.timeout")
    Integer socketTimeout();


}
