package com.service.system;

import com.model.system.Mail;
import framework.utils.pageUtil.PagedResult;

public interface MailService {
    int sendMail(Mail mail);

    PagedResult<Mail> listAllMailByFromUserId(String userId, Integer pageNumber, Integer pageSize);
}
