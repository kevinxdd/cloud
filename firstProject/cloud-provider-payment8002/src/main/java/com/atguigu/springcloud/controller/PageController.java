package com.atguigu.springcloud.controller;/**
 * Create by xdd on 2020/3/12.
 */

import com.atguigu.springcloud.entity.ModelEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xdd
 */
@Controller
@RequestMapping
@Slf4j
public class PageController
{
    @RequestMapping(value = "/index",method = RequestMethod.GET)

    public String index(Model model){
        model.addAttribute("greeting", new ModelEntity());
        return "index";

    }


    @RequestMapping(value = "/sum",method = RequestMethod.POST)
    @ResponseBody
    public String sum(@RequestBody ModelEntity model){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date parse  = simpleDateFormat.parse(model.getTime());
            long time = parse.getTime();

            if(StringUtils.isEmpty(model.getNum())){
                long l = time + Integer.valueOf(model.getHour()) * 60 * 60 * 1000;
                String format = simpleDateFormat.format(l);
                return format;
            }else{
                long l1 = time + (Integer.valueOf(model.getHour())-Integer.valueOf(model.getNum())) * 60 * 60 * 1000;
                String format1 = simpleDateFormat.format(l1);

                long l2 = time + (Integer.valueOf(model.getHour())+Integer.valueOf(model.getNum())) * 60 * 60 * 1000;
                String format2 = simpleDateFormat.format(l2);
                return format1+"-"+format2;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return "时间格式有误";
        }
    }


}
