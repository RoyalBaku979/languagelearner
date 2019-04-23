package com.company.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;

@Configuration
public class MyConfig {

    @Bean("mynames")
    public HashMap<String, String> getNames(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1","sss");
        return hashMap;
    }

}
