package com.mgt.oj.judge;

import com.mgt.oj.judge.strategy.*;
import com.mgt.oj.judge.codesandbox.model.JudgeInfo;
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
        } else if ("python".equals(language)) {
            judgeStrategy = new PythonLanguageJudgeStrategy();
        } else if ("cpp".equals(language)) {
            judgeStrategy = new CppLanguageJudgeStrategy();
        } else if ("c".equals(language)) {
            judgeStrategy = new CLanguageJudgeStrategy();
        }

        return judgeStrategy.doJudge(judgeContext);
    }

}
