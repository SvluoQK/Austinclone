package com.learnemoji.demo.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learnemoji.demo.Mapper.EmojiMapper;
import com.learnemoji.demo.Model.Entity.Emoji;
import org.springframework.stereotype.Service;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Service
public class EmojiServiceImpl extends ServiceImpl<EmojiMapper, Emoji>
        implements EmojiService {


}
