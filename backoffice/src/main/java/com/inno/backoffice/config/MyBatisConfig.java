package com.inno.backoffice.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(value={"com.inno.**.**.repository"})
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        // mapper locations
        Resource[] arrResource = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*Mapper.xml");
        sqlSessionFactory.setMapperLocations(arrResource);
        sqlSessionFactory.setTypeAliasesPackage("com.inno.**.**.vo");

        // camel case
        sqlSessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
