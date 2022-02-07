package com.learnemoji.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learnemoji.demo.Base.*;
import com.learnemoji.demo.Model.Entity.Emoji;
import com.learnemoji.demo.Model.Request.SearchEmojiRequest;
import com.learnemoji.demo.Service.EmojiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@RestController
@RequestMapping("/emoji")
@Slf4j
public class EmojiController {

    @Resource
    private EmojiService emojiService;


    /**
     * 搜索表情方法
     *
     */
    @GetMapping("/search")
    public BaseResponse<IPage<Emoji>> searchEmoji(SearchEmojiRequest emojiRequest){
        if(emojiRequest==null){
            throw new BusinessException(ErrorCodeEnum.REQUEST_PARAMS_ERROR);
        }
        int pageNum = emojiRequest.getPageNum();
        int pageSize = emojiRequest.getPageSize();
        final int MAX_VIEW_NUM =400;
        if(pageNum * pageSize> MAX_VIEW_NUM){
            return ResultUtils.error(ErrorCodeEnum.REQUEST_PARAMS_ERROR.getCode(), "最多可查看 400 条数据");
        }

        QueryWrapper<Emoji> emojiQueryWrapper = new QueryWrapper<>();
        String name = emojiRequest.getName();
        if (StringUtils.isNotBlank(name)) {
            emojiQueryWrapper.like("name", name);
        }
        String tag = emojiRequest.getTag();
        if (StringUtils.isNotBlank(tag)) {
            emojiQueryWrapper.like("tags", tag);
        }
        if (emojiRequest.getReviewStatus() != null) {
            emojiQueryWrapper.eq("reviewStatus", emojiRequest.getReviewStatus());
        }
        emojiQueryWrapper.orderByDesc("createTime");
        return ResultUtils.success(emojiService.page(new Page<>(emojiRequest.getPageNum(), emojiRequest.getPageSize()),
                emojiQueryWrapper));


    }




}
