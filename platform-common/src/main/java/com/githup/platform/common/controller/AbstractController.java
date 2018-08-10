package com.githup.platform.common.controller;

import com.githup.platform.common.domain.dto.ResponseDTO;

/**
 *
 */
public class AbstractController {

    public ResponseDTO returnSuccess() {
        ResponseDTO responseDTO = new ResponseDTO(true,"10000", "成功");
        return responseDTO;
    }

    public ResponseDTO returnError() {
        ResponseDTO responseDTO = new ResponseDTO(false,"10001", "系统错误");
        return responseDTO;
    }

    public ResponseDTO returnError(String message) {
        ResponseDTO responseDTO = new ResponseDTO(false,"10002", message);
        return responseDTO;
    }
}
