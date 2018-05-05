package com.nit.weibo.controller;


import com.nit.weibo.dto.AjaxMsgDto;
import com.nit.weibo.dto.ContentKeyDto;
import com.nit.weibo.service.ICommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/wb_comment")
public class CommentController {

    @Resource
    private ICommentService commentService;
    /**
    	 * @Description: 对微博主账号的操作
    	 * @param @param userId
    	 * @param @param  username
    	 * @param @param  password
         * @param @param  drive
         * @param @param  flag 0 为保存 1 为修改
    	 * @return AjaxMsgDto 
    	 * @author 冯广敬
    	 * @date  
    	*/
    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsgDto saveAccount(Integer userId, String username, String password, String drive,Integer flag) {
        AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
        try {
            ajaxMsgDto.setIsSuccess(true);
            ajaxMsgDto.setData(commentService.saveWBAccount(userId,username,password,drive,flag));
        } catch (Exception e) {
            e.printStackTrace();
            ajaxMsgDto.setIsSuccess(false);
        }
        return ajaxMsgDto;
    }

    @RequestMapping(value = "/saveContent", method = RequestMethod.POST)
    @ResponseBody
    public AjaxMsgDto saveContent(Integer contentId,Integer userId, String content, String drive, Integer flag) {
        AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
        try {
            ajaxMsgDto.setIsSuccess(true);
            ajaxMsgDto.setData(commentService.saveContent(contentId,userId,content,drive,flag));
        } catch (Exception e) {
            e.printStackTrace();
            ajaxMsgDto.setIsSuccess(false);
        }
        return ajaxMsgDto;
    }

    @RequestMapping(value = "/saveContentKey")
    @ResponseBody
    public AjaxMsgDto saveContentKey(ContentKeyDto contentKeyDto,String drive, Integer flag) {
        AjaxMsgDto ajaxMsgDto = new AjaxMsgDto();
        try {
            ajaxMsgDto.setIsSuccess(true);
            ajaxMsgDto.setData(commentService.saveContentKey(contentKeyDto,drive,flag));
        } catch (Exception e) {
            e.printStackTrace();
            ajaxMsgDto.setIsSuccess(false);
        }
        return ajaxMsgDto;
    }
}
