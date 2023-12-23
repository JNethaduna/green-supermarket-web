package com.green.supermarketwebapp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sensitive.properties")
public class SensitiveDataConfig {

}
