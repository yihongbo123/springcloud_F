package com.tgw360.hystrixclient;

import com.tgw360.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;
import java.util.List;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 * @author eacdy
 */
@FeignClient(name = "cloud-service-user", fallback = UserFeignHystrixClient.UserHystrixClientFallback.class)
public interface UserFeignHystrixClient {
    @RequestMapping(value = "/user/users",method = RequestMethod.GET)
    public List<User> findUserAll();
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String getNum();
    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     *
     */

    @Component
    static class UserHystrixClientFallback implements UserFeignHystrixClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(UserHystrixClientFallback.class);

        /**
         * hystrix fallback方法
         * @param id id
         * @return 默认的用户
         */

        /**
         * hystrix fallback方法
         * @return 默认的用户
         */
        @Override
        public List<User> findUserAll() {
            UserHystrixClientFallback.LOGGER.info("异常发生，进入fallback方法");
            ArrayList<User> users = new ArrayList<User>();
            return users;
        }

        @Override
        public String getNum() {
            return null;
        }
    }
}
