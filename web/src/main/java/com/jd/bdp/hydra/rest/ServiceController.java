package com.jd.bdp.hydra.rest;

import com.alibaba.fastjson.JSONArray;
import com.jd.bdp.hydra.mysql.persistent.service.AppService;
import com.jd.bdp.hydra.mysql.persistent.service.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: biandi
 * Date: 13-3-20
 * Time: 下午1:51
 */
@Controller
@RequestMapping("/rest/service")
public class ServiceController {

    @Autowired
    private AppService appService;
    @Autowired
    private ServiceService serviceService;

    @RequestMapping("/appList")
    @ResponseBody
    public JSONArray getAllApp() {
        return (JSONArray) JSONArray.toJSON(appService.getAll());
    }

    @RequestMapping("/{appId}")
    @ResponseBody
    public JSONArray testAjax(@PathVariable int appId) {
        return (JSONArray) JSONArray.toJSON(serviceService.get(appId));
    }
}
