package com.blf.stages;

import com.blf.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf_sys
 * Package:com.blf.stages
 * DateTime: 2017/5/10  17:20
 * Description:手动添加
 */
@Controller
@RequestMapping("/stages")
public class MainController extends BaseController {

    @RequestMapping("/main")
    public String dashboard(){
        return "";
    }



}
