package com.eul.eulproject.service;

import com.eul.eulproject.entity.information.login;

import java.util.List;

public interface loginService {
     login getByLogInName(String logInName);

     List<login> getAll();

     boolean update(String ID ,String password);
}
