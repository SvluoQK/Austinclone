package com.hao.messagesearch.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.messagesearch.demo.Base.BaseResponse;
import com.hao.messagesearch.demo.Base.BusinessException;
import com.hao.messagesearch.demo.Base.ReturnUtil;
import com.hao.messagesearch.demo.Mapper.MessageMapper;
import com.hao.messagesearch.demo.Model.Entity.message;
import com.hao.messagesearch.demo.Model.Enums.ErrorCodeEnum;
import com.hao.messagesearch.demo.Model.Requests.SearchMessageRequest;
import com.hao.messagesearch.demo.Service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */


@RestController
@RequestMapping("/message")
@Slf4j
public class MessageController {
    /**
     * 搜索方法
     *
     */
    @Resource
    MessageService messageService;


    @GetMapping("/search")
    public BaseResponse<IPage<message>> searchMessage(SearchMessageRequest messageRequest){

        if(messageRequest == null){
            throw new BusinessException(ErrorCodeEnum.REQUEST_PARAMS_ERROR);
        }
        int pageNum = messageRequest.getPageNum();
        int pageSize = messageRequest.getPageSize();
        final int MAX_VIEW_NUM = 400;
        if (pageNum * pageSize > MAX_VIEW_NUM) {
            return ReturnUtil.error(ErrorCodeEnum.REQUEST_PARAMS_ERROR.getCode(), "最多可查看 400 条数据");
        }
        QueryWrapper<message> messageQueryWrapper = new QueryWrapper<>();
        String message = messageRequest.getMessage();
        if(StringUtils.isNotBlank(message)){
            messageQueryWrapper.like("message",message);
        }

        return ReturnUtil.success(messageService.page(new Page<>(messageRequest.getPageNum(), messageRequest.getPageSize()),messageQueryWrapper));

    }

    @PostMapping("/add")
    public BaseResponse<Integer> addMessage(@RequestBody message message){

        if(message == null){
            throw new BusinessException(ErrorCodeEnum.REQUEST_PARAMS_ERROR);
        }
        messageService.save(message);
        return ReturnUtil.success(message.getID());
    }





}
