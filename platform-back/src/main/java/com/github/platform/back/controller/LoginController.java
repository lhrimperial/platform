package com.github.platform.back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.platform.back.domain.dto.UserDTO;
import com.githup.platform.common.controller.AbstractController;
import com.githup.platform.common.domain.dto.ResponseDTO;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *
 */
@RestController
public class LoginController extends AbstractController{

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/asyncLogin")
    public ResponseDTO asyncLogin(@RequestBody UserDTO userDTO, HttpSession session) {
        ResponseDTO responseDTO = null;
        UsernamePasswordToken token = new UsernamePasswordToken(userDTO.getUserName(), userDTO.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);

            Map<String, Object> resultMap = new HashedMap();
            resultMap.put("Authorization", session.getId());
            responseDTO = returnSuccess();
            responseDTO.setResult(resultMap);
            return responseDTO;
        } catch (IncorrectCredentialsException e) {
            //密码错误
            logger.error("用户名/密码错误", e);
            responseDTO = returnError("用户名/密码错误");
        } catch (LockedAccountException e) {
            //该用户已被冻结
            logger.error("该用户已被冻结", e);
            responseDTO = returnError("该用户已被冻结");
        } catch (ExcessiveAttemptsException e){
            //尝试次数过多
            logger.error("尝试次数过多", e);
            responseDTO = returnError("尝试次数过多");
        } catch (AuthenticationException e) {
            //该用户不存在
            logger.error("该用户不存在", e);
            responseDTO = returnError("该用户不存在");
        } catch (Exception e) {
            logger.error("", e);
            responseDTO = returnError();
        }
        return responseDTO;
    }

    @RequestMapping("/menus")
    public ResponseDTO menus() {
        ResponseDTO responseDTO = returnSuccess();
        JSONArray array = JSON.parseArray(data);
        responseDTO.setResult(array);
        return responseDTO;
    }

    @RequestMapping("/logout")
    public ResponseDTO logout() {
        return returnSuccess();
    }



    String data = "[{\n" +
            "                icon: 'el-icon-document',\n" +
            "                index: '2',\n" +
            "                title: '基础数据',\n" +
            "                subs: [\n" +
            "                    {\n" +
            "                        index: 'wordManagement',\n" +
            "                        title: '词条管理',\n" +
            "                        path: 'http://localhost:9101/list.html'\n" +
            "                    }\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                icon: 'el-icon-setting',\n" +
            "                index: '3',\n" +
            "                title: '系统设置',\n" +
            "                subs: [\n" +
            "                    {\n" +
            "                        index: 'userManagement',\n" +
            "                        title: '用户管理',\n" +
            "                        path:'http://10.200.6.188:8080/tnt-bms-admin/main/dashboard'\n   "+
            "                    },\n" +
            "                    {\n" +
            "                        index: 'roleManagement',\n" +
            "                        title: '角色管理'\n" +
            "                    },\n" +
            "                    {\n" +
            "                        index: 'resourceManagement',\n" +
            "                        title: '资源管理'\n" +
            "                    }\n" +
            "                ]\n" +
            "            }]";
}
