package vip.xjdai.cnofig;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
// / 配置mybatis的接口类放的地方
@MapperScan(basePackages = { "vip.xjdai.mapper2" },sqlSessionFactoryRef = "twoSqlSessionFactory",sqlSessionTemplateRef = "twoSqlSessionTemplate")
public class TWOConfig {
    //    @Value("${spring.datasource.minor.driver-class-name}")
    //    private String driverClassName;
    //
    //    @Value("${spring.datasource.minor.url}")
    //    private String url;
    //
    //    @Value("${spring.datasource.minor.username}")
    //    private String username;
    //
    //    @Value("${spring.datasource.minor.password}")
    //    private String password;
    //
    //    @Bean(name = "twoDataSource")
    //    public DataSource dataSource()
    //    {
    //        DruidDataSource dataSource = new DruidDataSource();
    //        dataSource.setDriverClassName(this.driverClassName);
    //        dataSource.setUrl(this.url);
    //        dataSource.setUsername(this.username);
    //        dataSource.setPassword(this.password);
    //        return dataSource;
    //    }

    @Bean(name = "twoDataSource")
    @ConfigurationProperties("spring.datasource.druid.minor")
    public DataSource dataSource()
    {
        return DruidDataSourceBuilder.create().build();

    }

    /**
     * 生成SqlSessionFactory 需要注入 DataSource
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "twoSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("twoDataSource") DataSource dataSource) throws Exception
    {
        System.out.println("不是主配");
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // /*加载所有的mapper.xml映射文件*/
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/two/*.xml"));
        return factoryBean.getObject();

    }

    /**
     * 事物控制
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "twoTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("twoDataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * spring整合mybatis
     * 
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name = "twoSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("twoSqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }

}
