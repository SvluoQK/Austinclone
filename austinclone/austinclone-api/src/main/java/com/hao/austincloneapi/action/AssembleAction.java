package com.hao.austincloneapi.action;

import com.google.common.base.Throwables;
import com.hao.austinclone.austinclonecommon.constant.AustinConstant;
import com.hao.austinclone.dao.MessageTemplateDao;
import com.hao.austinclone.domain.MessageTemplate;
import com.hao.austinclone.pipline.BusinessProcess;
import com.hao.austinclone.pipline.ProcessContext;
import com.hao.austincloneapi.domain.SendTaskModel;
import com.java3y.austin.common.domain.TaskInfo;
import com.java3y.austin.common.enums.RespStatusEnum;
import com.java3y.austin.common.enums.TemplateType;
import com.java3y.austin.common.vo.BasicResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.network.Send;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author Hao Luo
 * @Date 2022
 * @description 拼装参数
 */

@Slf4j
public class AssembleAction implements BusinessProcess {
    @Autowired
    public MessageTemplateDao messageTemplateDao;

    @Override
    public void process(ProcessContext processContext) {
        SendTaskModel sendTaskModel =  (SendTaskModel) processContext.getProcessModel();
        Long messageTemplateId = sendTaskModel.getMessageTemplateId();

        try{
            Optional<MessageTemplate> messageTemplate = messageTemplateDao.findById(messageTemplateId);
            if(!messageTemplate.isPresent() || messageTemplate.get().getIsDeleted().equals(AustinConstant.TRUE)){
                processContext.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.TEMPLATE_NOT_FOUND));
                return;
            }
            List<TaskInfo> taskInfos = assembleTaskInfo(sendTaskModel, messageTemplate.get());
            sendTaskModel.setTaskInfo(taskInfos);

        }catch (Exception e){
            processContext.setNeedBreak(true).setResponse(BasicResultVO.fail(RespStatusEnum.SERVICE_ERROR));
            log.error("assemble task fail! templateId:{}, e:{}", messageTemplateId, Throwables.getStackTraceAsString(e));

        }





    }

    public List<TaskInfo> assembleTaskInfo(SendTaskModel sendTaskModel, MessageTemplate messageTemplate){

        return null;

    }
}
