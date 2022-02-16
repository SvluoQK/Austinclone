package com.hao.messagesearch.demo.Service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hao.messagesearch.demo.Mapper.MessageMapper;
import com.hao.messagesearch.demo.Model.Entity.message;
import com.hao.messagesearch.demo.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, message>
        implements  MessageService {

    }

