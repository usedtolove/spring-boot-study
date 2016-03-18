package com.tz

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 *
 * @author hu jing ling
 * @since 2016-03-18
 */
//@SpringBootApplication
@Configuration@ComponentScan@EnableAutoConfiguration
class DemoApplication {

    static void main(String[] args) {
        SpringApplication.run DemoApplication, args
    }

}
