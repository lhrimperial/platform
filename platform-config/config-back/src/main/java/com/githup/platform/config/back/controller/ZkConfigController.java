package com.githup.platform.config.back.controller;

import com.githup.platform.common.controller.AbstractController;
import com.githup.platform.common.domain.dto.RequestDTO;
import com.githup.platform.common.domain.dto.ResponseDTO;
import com.githup.platform.config.back.domain.entity.ApplicationEntity;
import com.githup.platform.config.back.domain.entity.EnvironmentEntity;
import com.githup.platform.config.back.service.IZkConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/zookeeper")
public class ZkConfigController extends AbstractController {

    @Autowired
    private IZkConfigService zkConfigService;

    @RequestMapping("/remoteMethodEnv")
    public ResponseDTO remoteMethodEnv(String environmentName) {
        ResponseDTO responseDTO = returnSuccess();
        responseDTO.setResult(zkConfigService.remoteMethodEnv(environmentName));
        return responseDTO;
    }

    @RequestMapping("/remoteMethodApp")
    public ResponseDTO remoteMethodApp(String environmentCode, String applicationName) {
        ResponseDTO responseDTO = returnSuccess();
        responseDTO.setResult(zkConfigService.remoteMethodApp(environmentCode,applicationName));
        return responseDTO;
    }

    @RequestMapping("/findEnvByPage")
    public ResponseDTO findEnvByPage(@RequestBody RequestDTO<EnvironmentEntity> requestDTO) {
        ResponseDTO responseDTO = returnSuccess();
        Pageable pageable = new PageRequest(requestDTO.getPageNo(), requestDTO.getPageSize());
        Page<EnvironmentEntity> result =  zkConfigService.findEnvByPage(requestDTO.getRequest(), pageable);
        responseDTO.setResult(result.getContent());
        responseDTO.setTotalCount(result.getTotalElements());
        return responseDTO;
    }

    @RequestMapping("/saveOrUpdateEnv")
    public ResponseDTO saveOrUpdateEnv(@RequestBody RequestDTO<EnvironmentEntity> requestDTO) {
        ResponseDTO responseDTO = returnSuccess();
        zkConfigService.saveOrUpdateEnv(requestDTO.getRequest());
        return responseDTO;
    }

    @RequestMapping("/deleteEnv")
    public ResponseDTO deleteEnv(Integer envId) {
        ResponseDTO responseDTO = returnSuccess();
        zkConfigService.deleteEnv(envId);
        return responseDTO;
    }

    @RequestMapping("/findAppByPage")
    public ResponseDTO findAppByPage(@RequestBody RequestDTO<ApplicationEntity> requestDTO) {
        ResponseDTO responseDTO = returnSuccess();
        Pageable pageable = new PageRequest(requestDTO.getPageNo(), requestDTO.getPageSize());
        Page<ApplicationEntity> result =  zkConfigService.findAppByPage(requestDTO.getRequest(), pageable);
        responseDTO.setResult(result.getContent());
        responseDTO.setTotalCount(result.getTotalElements());
        return responseDTO;
    }

    @RequestMapping("/saveOrUpdateApp")
    public ResponseDTO saveOrUpdateApp(@RequestBody RequestDTO<ApplicationEntity> requestDTO) {
        ResponseDTO responseDTO = returnSuccess();
        zkConfigService.saveOrUpdateApp(requestDTO.getRequest());
        return responseDTO;
    }

    @RequestMapping("/deleteApp")
    public ResponseDTO deleteApp(Integer appId) {
        ResponseDTO responseDTO = returnSuccess();
        zkConfigService.deleteApp(appId);
        return responseDTO;
    }
}
