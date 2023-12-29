package com.mgt.oj.judge;

import com.mgt.oj.judge.strategy.DefaultJudgeStrategy;
import com.mgt.oj.judge.strategy.JavaLanguageJudgeStrategy;
import com.mgt.oj.judge.strategy.JudgeContext;
import com.mgt.oj.judge.strategy.JudgeStrategy;
import com.mgt.oj.model.dto.questionsubmit.JudgeInfo;
import com.mgt.oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
