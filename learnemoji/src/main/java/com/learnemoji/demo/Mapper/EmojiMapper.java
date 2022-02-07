package com.learnemoji.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learnemoji.demo.Model.Entity.Emoji;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Mapper
public interface EmojiMapper extends BaseMapper<Emoji> {
}
