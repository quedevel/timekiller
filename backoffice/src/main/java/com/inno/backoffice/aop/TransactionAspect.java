package com.inno.backoffice.aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;

@Configuration
public class TransactionAspect {

    private static final String TRANSACTION_METHOD_NAME = "*";
    private static final String TRANSACTION_EXPRESSION = "execution(* com.inno.backoffice..*Service.insert*(..))"
                                                    + " || execution(* com.inno.backoffice..*Service.update*(..))"
                                                    + " || execution(* com.inno.backoffice..*Service.delete*(..))"
                                                    + " || execution(* com.inno.common..*Service.insert*(..))"
                                                    + " || execution(* com.inno.common..*Service.update*(..))"
                                                    + " || execution(* com.inno.common..*Service.delete*(..))";

    @Autowired
    private TransactionManager transactionManager;

    @Bean
    public TransactionInterceptor transactionAdvice() {
        MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
        RuleBasedTransactionAttribute attribute = new RuleBasedTransactionAttribute();
        attribute.setName(TRANSACTION_METHOD_NAME);
        attribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        source.setTransactionAttribute(attribute);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor transactionAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(TRANSACTION_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
    }

}
