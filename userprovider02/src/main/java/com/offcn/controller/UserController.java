package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /***
     * 获取全部用户信息
     *
     * @return
     */
    @GetMapping("/getall")
    public Map<String,Object> getUsers() {
        Map<String,Object> map=new HashMap<>();
        List<User> list = userService.getUserList();
        map.put("list", list);
        String ProviderVersion="用户服务UserProvdier002:0.01V";
        map.put("ProviderVersion", ProviderVersion);

        try {
            //让主线程随机睡眠0--1200毫秒，模拟发生熔断
            Thread.sleep(new Random().nextInt(6000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }

    /***
     * 保存新增用户接口
     *
     * @param user
     * @return
     */
    @PostMapping("/save")
    public String createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /***
     * 获取指定id用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public User findUser(@PathVariable("id") Long id) {
        User user =null;
        try {
            user= userService.getUser(id);
            System.out.println("返回user:"+user);
        } catch (Exception e) {

            //e.printStackTrace();
            System.out.println("数据查询失败:");
            return user;
        }
        return user;
    }

    /***
     * 编辑指定id用户信息
     *
     * @param user
     * @param id
     * @return
     */
    @PutMapping("/update/{id}")
    public String editUser(@RequestBody User user, @PathVariable("id") Long id) {
        try {
            userService.updateUser(user.getId(), user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /***
     * 删除指定id用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";

    }

    /***
     * 获取服务名称
     *
     * @return
     */
    @GetMapping("/getversion")
    public String getVersion() {

        return "用户服务UserProvdier001:0.01V";
    }

}
