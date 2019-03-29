package com.eul.eulproject.service.Imp;

import com.eul.eulproject.entity.information.login;
import com.eul.eulproject.mapper.LoginMapper;
import com.eul.eulproject.service.loginService;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImp implements loginService {

    private LoginMapper loginMapper;

    @Autowired
    LoginServiceImp(LoginMapper loginMapper){
        this.loginMapper = loginMapper;
    }

    @Override
    public login getByLogInName(String logInName){
        login login = loginMapper.getByName(logInName);
        if(login == null){
            throw new AuthenticationException("用户不存在");
        }
        return login;
    }

    @Override
    public List<login> getAll() {
        return loginMapper.getAll();
    }

    @Override
    public boolean update(String ID, String password) {
        return loginMapper.update(ID ,password);
    }
}
