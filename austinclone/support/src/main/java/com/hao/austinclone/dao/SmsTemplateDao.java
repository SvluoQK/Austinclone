package com.hao.austinclone.dao;

import com.hao.austinclone.domain.SmsRecord;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */


public interface SmsTemplateDao extends CrudRepository<SmsRecord,Long> {

}
