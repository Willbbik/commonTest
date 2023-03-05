package com.example.commontest.enumlist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumConfig {

    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("commissionType", CommissionType.class);
        enumMapper.put("commissionCutting", CommissionCutting.class);

        return enumMapper;
    }

}
