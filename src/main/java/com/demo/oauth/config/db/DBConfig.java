package com.demo.oauth.config.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: maopanpan
 * @Description: 自定义数据源
 * @Date: 2017/10/12.
 **/
@Configuration
@MapperScan(basePackages = DBConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
@ConfigurationProperties(prefix = "demo.mybatis")
@EnableTransactionManagement
public class DBConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.demo.oauth.dao.*.*";
    static final String MAPPER_LOCATION = "classpath:mappings/**/*.xml";
    static final String CONFIG_LOCATION = "classpath:mybatis/mybatis-config.xml";

    private String url;

    private String userName;

    private String password;

    private String driverClass;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setConfigLocation(applicationContext.getResource(CONFIG_LOCATION));
        sessionFactory.setMapperLocations(applicationContext.getResources(MAPPER_LOCATION));
        return sessionFactory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
