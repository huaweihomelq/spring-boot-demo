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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * sqlserver数据连接
 * Created by guohuawei on 2017/10/25.
 */
@Configuration
@MapperScan(basePackages = "com.yixin.mapper.sqlserver", sqlSessionTemplateRef  = "SqlServerSqlSessionTemplate")
public class SqlServerConfig {
    @Bean(name = "SqlServerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.SqlServer")
    public DataSource SqlServerDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "SqlServerSqlSessionFactory")
    public SqlSessionFactory SqlServerSqlSessionFactory(@Qualifier("SqlServerDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/sqlserver/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "SqlServerTransactionManager")
    public DataSourceTransactionManager SqlServerTransactionManager(@Qualifier("SqlServerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SqlServerSqlSessionTemplate")
    public SqlSessionTemplate SqlServerSqlSessionTemplate(@Qualifier("SqlServerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
