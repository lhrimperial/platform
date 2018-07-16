package com.github.platform.back.controller;

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
}
