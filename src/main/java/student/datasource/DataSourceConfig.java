package student.datasource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://192.168.178.100:3306/student?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true")
                .username("student")
                .password("student")
                .build();
    }
}
