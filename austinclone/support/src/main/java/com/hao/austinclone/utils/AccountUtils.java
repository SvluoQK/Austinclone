package com.hao.austinclone.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.hao.austinclone.austinclonecommon.constant.AustinConstant;
import org.springframework.stereotype.Component;

/**
 * @author Hao Luo
 * @Date 2022
 * @description 获取账号信息的工具类
 */

@Component
public class AccountUtils {

    @ApolloConfig("boss.austin")
    private Config config;

    /**
     * (key:smsAccount)短信参数示例：[{"sms_10":{"url":"sms.tencentcloudapi.com","region":"ap-guangzhou","secretId":"AKIDhDUUDfffffMEqBF1WljQq","secretKey":"B4h39yWnfffff7D2btue7JErDJ8gxyi","smsSdkAppId":"140025","templateId":"11897","signName":"Java3y公众号","supplierId":10,"supplierName":"腾讯云"}}]
     * (key:emailAccount)邮件参数示例：[{"email_10":{"host":"smtp.qq.com","port":465,"user":"403686131@qq.com","pass":"","from":"403686131@qq.com"}}]
     */
    public <T> T getAccount(Integer sendAccount, String apolloKey, String prefix, T t ){

        String ApolloConfig  = config.getProperty(apolloKey, AustinConstant.APOLLO_DEFAULT_VALUE_JSON_ARRAY);
        JSONArray jsonArray = JSON.parseArray(ApolloConfig);
        for(int i=0; i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Object obj = jsonObject.getObject(prefix + sendAccount, t.getClass());
            if(obj != null){
                return (T) obj;
            }
        }
        return null;

    }
}
