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
}
