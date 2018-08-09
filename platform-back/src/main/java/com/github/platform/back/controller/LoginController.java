package com.github.platform.back.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.githup.platform.common.controller.AbstractController;
import com.githup.platform.common.domain.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class LoginController extends AbstractController{

    @RequestMapping("/login")
    public ResponseDTO login(String userName, String password) {

        return returnSuccess();
    }

    @RequestMapping("/menus")
    public ResponseDTO menus() {
        ResponseDTO responseDTO = returnSuccess();
        JSONArray array = JSON.parseArray(data);
        responseDTO.setResult(array);
        return responseDTO;
    }

    String data = "[{\n" +
            "                icon: 'el-icon-menu',\n" +
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
            "                icon: 'el-icon-date',\n" +
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
