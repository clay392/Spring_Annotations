package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *  spring的配置类
 */
@Configuration
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
