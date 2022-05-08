package com.hao.austinclone.pipline;

import java.util.List;

/**
 * @author Hao Luo
 * @Date 2022
 * @description 业务执行模板（把责任链的逻辑串起来）
 */


public class ProcessTemplate {
    private List<BusinessProcess> processList;

    public List<BusinessProcess> getProcessList() {
        return processList;
    }
    public void setProcessList(List<BusinessProcess> processList) {
        this.processList = processList;
    }

}
