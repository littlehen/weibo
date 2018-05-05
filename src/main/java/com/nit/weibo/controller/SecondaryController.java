package com.nit.weibo.controller;

import com.nit.weibo.dto.AjaxMsgDto;
import com.nit.weibo.service.ISecondaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/wb_Secondary")
public class SecondaryController {

    @Resource
    private ISecondaryService secondaryService;
    /**
     * @Description: 对微博辅助账号的操作
     * @param @param userId
     * @param @param  username
     * @param @param  password
     * @param @param  drive
     * @param @param  flag 0 为保存 1 为修改 2 为删除
     * @return AjaxMsgDto
     * @author 冯广敬
     * @date
     */
    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsgDto saveAccount(Integer userId, String username, String password, String drive, Integer flag,Integer weiboId ){
        AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
        try {
            ajaxMsgDto.setIsSuccess(true);
            ajaxMsgDto.setData(secondaryService.saveSecondaryAccount(userId,username,password,drive,flag,weiboId));
        } catch (Exception e) {
            e.printStackTrace();
            ajaxMsgDto.setIsSuccess(false);
        }
        return ajaxMsgDto;
    }



}
