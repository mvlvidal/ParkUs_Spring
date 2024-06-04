package br.parkus.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactoryParkUs",
		transactionManagerRef = "transactionManagerParkUs",
		basePackages = { "br.parkus.repository"}
)
public class ParkUsConfig {
	
	@Bean(name="dataSourceParkUs")
	@ConfigurationProperties(prefix = "parkus.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
		
	@Bean(name = "entityManagerFactoryParkUs")
	public LocalContainerEntityManagerFactoryBean 
		entityManagerFactory(
		EntityManagerFactoryBuilder builder,
		@Qualifier("dataSourceParkUs") DataSource dataSource
	  ) {
	return builder
	      .dataSource(dataSource)
	      .packages("br.parkus.model")
	      .persistenceUnit("parkus")
	      .build();
	}
	    
	@Bean(name = "transactionManagerParkUs")
	public PlatformTransactionManager transactionManager(
	  @Qualifier("entityManagerFactoryParkUs") EntityManagerFactory 
	  entityManagerFactory
	) {
	  return new JpaTransactionManager(entityManagerFactory);
	}
}
