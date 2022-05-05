package com.hao.austinclone.austinclonecommon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author Hao Luo
 * @Date 2022
 * @description 官方帐号发送的消息 用map来装数据 然后用String来展示url
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfficialAccountsContentModel extends ContentModel{
    /**
     *  发送的内容
     */
    private Map<String, String> map;

    /**
     * 发送的url
     */
    private String url;

}
