package spittr.db;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="spittr.db")
@PropertySource("classpath:app.properties")
public class JpaConfig {
	
  @Autowired
  Environment env;

  @Bean
  public DataSource dataSource() {
	  BasicDataSource dataSource=new BasicDataSource();
	  /*dataSource.setDriverClassName(env.getProperty("driverClassName"));
	  dataSource.setUrl(env.getProperty("url"));
	  dataSource.setUsername(env.getProperty("username"));//返回了计算机的用户名，在使用时需要注意
	  dataSource.setPassword(env.getProperty("password"));*/
	  
	  dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
	  dataSource.setUrl(env.getProperty("db.url"));
	  dataSource.setUsername(env.getProperty("db.username"));
	  dataSource.setPassword(env.getProperty("db.password"));
	  return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource);
    emf.setPersistenceUnitName("spittr");
    emf.setJpaVendorAdapter(jpaVendorAdapter);
    emf.setPackagesToScan("spittr.domain");
    return emf;
  }
  
  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.MYSQL);
    adapter.setShowSql(true);
    adapter.setGenerateDdl(true);
    adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
    return adapter;
  }
  //嵌套定义配置类
  @Configuration
  @EnableTransactionManagement
  public static class TransactionConfig {

    @Inject
    private EntityManagerFactory emf;

    @Bean
    public PlatformTransactionManager transactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(emf);
      return transactionManager;
    }    
  }
  
}
