package com.hao.austinclone.austinclonecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@Getter
@ToString
@AllArgsConstructor
public enum DeduplicationType {

    CONTENT(10, "N分钟相同内容去重"),
    FREQUENCY(20, "一天内N次相同渠道去重"),
    ;

    private Integer code;
    private String description;

    /**
     * 获取去重后的列表
     */
    public static List<Integer> getDeduplicationList(){

        ArrayList<Integer> result = new ArrayList<>();
        for(DeduplicationType value : DeduplicationType.values()){
            result.add(value.getCode());
        }
        return result;

    }
}
