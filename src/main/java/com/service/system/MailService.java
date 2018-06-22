package com.service.system;

import com.model.system.Mail;
import framework.utils.pageUtil.PagedResult;

public interface MailService {
    int sendMail(Mail mail);

    PagedResult<Mail> listAllMailByFromUserId(String userId, Integer pageNumber, Integer pageSize);

    PagedResult<Mail> listAllMailByToUserId(String userId, Integer pageNumber, Integer pageSize);

    int saveDraft(Mail mail);

    int deleteMail(String mailId);

    PagedResult<Mail> listAllMailByToUserIdDeleteBox(String userId, Integer pageNumber, Integer pageSize);

    PagedResult<Mail> listAllMailByFromUserIdDraftBox(String userId, Integer pageNumber, Integer pageSize);
}
