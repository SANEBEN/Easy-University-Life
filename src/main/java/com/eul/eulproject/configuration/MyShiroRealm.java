package com.eul.eulproject.configuration;

import com.eul.eulproject.entity.information.login;
import com.eul.eulproject.entity.information.message;
import com.eul.eulproject.service.loginService;
import com.eul.eulproject.service.messageService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    loginService loginService;
    @Autowired
    messageService messageService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        login login = (login) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        message message = messageService.getMessage(login.getId());
        if(message.getRole() == 0){
            authorizationInfo.addRole("teacher");
        }else {
            authorizationInfo.addRole("student");
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String logInName = token.getUsername();
        login login = loginService.getByLogInName(logInName);
//        ByteSource source = ByteSource.Util.bytes(login.getID());
        AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(login, login.getPassword(), this.getName());
        super.clearCachedAuthorizationInfo(authcInfo.getPrincipals());
        return authcInfo;
    }
}
