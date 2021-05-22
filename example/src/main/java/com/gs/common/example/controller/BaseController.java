package com.gs.common.example.controller;

import com.gs.common.example.entity.ResponseData;

public class BaseController {

    public ResponseData successResponse(Object data){
        ResponseData result = new ResponseData();
        result.setCode(200);
        result.setMsg("");
        result.setDate(data);
        return  result;
    }
}
