package com.service.system.impl;

import com.dao.system.MailMapper;
import com.github.pagehelper.PageHelper;
import com.model.system.Mail;
import com.service.system.MailService;
import framework.utils.pageUtil.PageBeanUtil;
import framework.utils.pageUtil.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private MailMapper mailMapper;

    @Override
    public int sendMail(Mail mail) {
        return mailMapper.insert(mail);
    }

    @Override
    public PagedResult<Mail> listAllMailByFromUserId(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Mail> mailList = mailMapper.listAllMailByFromUserId(userId);
        return PageBeanUtil.toPagedResult(mailList);
    }

    @Override
    public PagedResult<Mail> listAllMailByToUserId(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Mail> mailList = mailMapper.listAllMailByToUserId(userId);
        return PageBeanUtil.toPagedResult(mailList);
    }

    @Override
    public int saveDraft(Mail mail) {
        return mailMapper.insertSelective(mail);
    }

    @Override
    public int deleteMail(String mailId) {
        Mail mail = mailMapper.selectByPrimaryKey(mailId);
        mail.setFlag("3");
        return mailMapper.updateByPrimaryKeySelective(mail);
    }

    @Override
    public PagedResult<Mail> listAllMailByToUserIdDeleteBox(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Mail> mailList = mailMapper.listAllMailByToUserIdDeleteBox(userId);
        return PageBeanUtil.toPagedResult(mailList);
    }

    @Override
    public PagedResult<Mail> listAllMailByFromUserIdDraftBox(String userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<Mail> mailList = mailMapper.listAllMailByFromUserIdDraftBox(userId);
        return PageBeanUtil.toPagedResult(mailList);
    }
}
