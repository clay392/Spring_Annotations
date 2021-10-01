package config;

import importselectort.CustomeImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *  spring的配置类
 */
@Configuration
@Import(CustomeImportSelector.class)
public class SpringConfiguration {
}
