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
    @Autowired
    MessageMapper massageMapper;

    public IPage<message> selectUserPage(Page<message> page, Integer ID) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return massageMapper.selectMessage(page, ID);
    }






}
