package com.dao.system;

import com.model.system.Mail;

import java.util.List;

public interface MailMapper {
    int deleteByPrimaryKey(String mailId);

    int insert(Mail record);

    int insertSelective(Mail record);

    Mail selectByPrimaryKey(String mailId);

    int updateByPrimaryKeySelective(Mail record);

    int updateByPrimaryKeyWithBLOBs(Mail record);

    int updateByPrimaryKey(Mail record);

    List<Mail> listAllMailByFromUserId(String userId);

    List<Mail> listAllMailByToUserId(String userId);

    List<Mail> listAllMailByToUserIdDeleteBox(String userId);

    List<Mail> listAllMailByFromUserIdDraftBox(String userId);
}