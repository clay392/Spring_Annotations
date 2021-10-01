package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *  spring的配置类,相当于applicationContext.xml的作用
 */
//@Configuration
@Component
@PropertySource(value = "classpath:jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfiguration {


}
