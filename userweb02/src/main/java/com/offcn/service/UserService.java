package com.offcn.service;

import com.offcn.po.User;

import java.util.Map;

public interface UserService {

    public Map getUserMap();
    public void createUser(User user);
    public User getUser(Long id);
    public void updateUser(Long id, User user);
    public void deleteUser(Long id);

}
