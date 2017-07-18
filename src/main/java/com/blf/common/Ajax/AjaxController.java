package com.blf.common.Ajax;

import com.blf.common.controller.BaseController;
import com.blf.system.entities.BlfCity;
import com.blf.system.entities.BlfProvince;
import com.blf.system.entities.BlfProvinceCity;
import com.blf.system.service.IProvinceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * User: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:blf
 * Package:com.blf.common
 * DateTime: 2016/12/12  15:52
 * Description: Ajax Controller
 */
@Controller
@RequestMapping(value = "ajax")
public class AjaxController extends BaseController {

    @Autowired
    private IProvinceService provinceService;

    /**
     * 获取所有省份组装成Options
     * @param request
     * @param response
     */
    @RequestMapping(value = "getProvinceOptions",method = RequestMethod.GET)
    public void getProvincesHtml(HttpServletRequest request, HttpServletResponse response){
        StringBuffer options = new StringBuffer("<option value=\"\"> -- 请选择 -- </option>");
        try{
            List<BlfProvince> provinces = (List<BlfProvince>) provinceService.find(null);
            if (null != provinces && provinces.size() > 0){
                for (BlfProvince province:provinces){
                    options.append("<option value='").append(province.getId()).append("'>").append(province.getName()).append("</option>");
                }
            }
            writeString(response,options.toString());
        }catch (Exception e){
            e.printStackTrace();
            LOG.error("Error:" + e);
        }
    }

    /**
     * 通过省份ID获取省份相关城市信息，组装成options
     * @param request
     * @param response
     */
    @RequestMapping(value = "getCityOptions",method = RequestMethod.GET)
    public void getCitiesHtml(HttpServletRequest request, HttpServletResponse response){
        BlfCity city = null;
        String proinceId = request.getParameter("provinceId");
        StringBuffer options = new StringBuffer("<option value=\"\"> -- 请选择 -- </option>");
        try{
            if (StringUtils.isNoneBlank(proinceId)){
                BlfProvince province = (BlfProvince) provinceService.findById(Integer.valueOf(proinceId));
                if (null != province){
                    Iterator<BlfProvinceCity> it = province.getBlfProvinceCitiesById().iterator();
                    while (it.hasNext()){
                        city = it.next().getBlfCityByCityId();
                        options.append("<option value='").append(city.getId()).append("'>").append(city.getName()).append("</option>");
                    }
                }
            }
            writeString(response,options.toString());
        }catch (Exception e){
            e.printStackTrace();
            LOG.error("Error:" + e);
        }
    }

}
