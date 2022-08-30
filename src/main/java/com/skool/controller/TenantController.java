package com.skool.controller;

import com.skool.models.DataSourceConfig;
import com.skool.services.TenantDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class TenantController {

    @Autowired
    TenantDataSource tenantDataSource;

    @PostMapping("createtenant")
    public ResponseEntity createTenant(@RequestBody Map<String,String> map){
        tenantDataSource.createNewDataSource(map.get("name"), map.get("password"));
        return ResponseEntity.accepted().build();
    }

}
