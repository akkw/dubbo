package org.dubbo.test.provider;/* 
    create qiangzhiwei time 2023/4/15
 */

public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHi(String name) {
        return "hi," + name;
    }
}
