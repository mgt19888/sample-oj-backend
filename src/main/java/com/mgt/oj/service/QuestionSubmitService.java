package com.mgt.oj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mgt.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.mgt.oj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.mgt.oj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mgt.oj.model.entity.User;
import com.mgt.oj.model.vo.QuestionSubmitVO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* @author mgt
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2023-12-27 10:45:11
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
