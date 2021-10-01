package config;

import com.itheima.typefilter.DistrictTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 *  Spring的配置类
 */
@Configuration
@ComponentScan(value = "com.itheima",
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM,classes = DistrictTypeFilter.class))
public class SpringConfiguration {
}
