package com.hao.messagesearch.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hao.messagesearch.demo.Model.Entity.message;
import org.apache.ibatis.annotations.Mapper;
import org.jsoup.Connection;
import org.springframework.stereotype.Repository;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Mapper
@Repository
public interface MessageMapper extends BaseMapper<message> {

    IPage<message> selectMessage(Page<?> page, Integer ID);

}
