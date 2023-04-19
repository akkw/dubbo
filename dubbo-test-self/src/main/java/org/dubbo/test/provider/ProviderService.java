package org.dubbo.test.provider;/* 
    create qiangzhiwei time 2023/4/15
 */

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ModuleModel;

import java.util.concurrent.CountDownLatch;

public class ProviderService {
    public static void main(String[] args) throws InterruptedException {
        ServiceConfig<GreetingsService> service = new ServiceConfig<>();
        final ApplicationModel applicationModel = FrameworkModel.defaultModel().newApplication();
        final ModuleModel moduleModel = applicationModel.newModule();
        service.setScopeModel(moduleModel);
        service.getApplicationModel().getApplicationConfigManager().setApplication(new ApplicationConfig("first-dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://192.168.31.97:2181"));
        service.setInterface(GreetingsService.class);
        service.setRef(new GreetingsServiceImpl());
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
