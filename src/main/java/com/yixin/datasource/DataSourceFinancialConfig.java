package com.yixin.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by guohuawei on 2017/10/19.
 */
@Configuration
@MapperScan(basePackages = "com.yixin.mapper.financial", sqlSessionTemplateRef  = "FinancialSqlSessionTemplate")
public class DataSourceFinancialConfig {
    @Bean(name = "FinancialDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.financial")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "FinancialSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("FinancialDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/financial/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "FinancialTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("FinancialDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "FinancialSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("FinancialSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
