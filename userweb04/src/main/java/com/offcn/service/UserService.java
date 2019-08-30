package com.offcn.service;

import com.offcn.config.FeignConfig;
import com.offcn.po.User;
import com.offcn.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//指定Feign日志配置文件
@FeignClient(value="USERPROVIDER",configuration= FeignConfig.class, fallback= UserServiceImpl.class)
public interface UserService {

    @GetMapping("/user/getall")
    public Map<String, Object> getUserMap();
    @PostMapping("/user/save")
    public void createUser(User user);
    @GetMapping("/user/get/{id}")
    public User getUser(@RequestParam("id") Long id);
    @PutMapping("/user/update/{id}")
    public void updateUser(@RequestParam("id") Long id, @RequestBody User user);
    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@RequestParam("id") Long id);

}
