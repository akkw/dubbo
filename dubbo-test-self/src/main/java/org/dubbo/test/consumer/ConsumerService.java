package org.dubbo.test.consumer;/*
    create qiangzhiwei time 2023/4/15
 */

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.dubbo.test.provider.GreetingsService;

public class ConsumerService {
    public static void main(String[] args) {
        ReferenceConfig<GreetingsService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://192.168.31.97:2181"));
        reference.setInterface(GreetingsService.class);

        final GreetingsService service = reference.get();
        final String message = service.sayHi("sadfasdf");
        System.out.println(message);
    }
}
