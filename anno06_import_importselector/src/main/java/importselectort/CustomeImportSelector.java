package importselectort;

import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *  自定义导入期
 */
public class CustomeImportSelector implements ImportSelector {

    //表达式(ASPECTJ表达式)
    private String expression;

    /**
     *  默认构造函数
     *  用于读取配置文件,给表达式赋值
     */
    public CustomeImportSelector(){
        try {
            //1、获取properties对象
            Properties properties = PropertiesLoaderUtils.loadAllProperties("customerimport.properties");
            //2、给expression赋值
            expression = properties.getProperty("custom.importselector.expression");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 实现获取要导入类的字节码
     * 需求:
     *      导入的过滤规则TypeFilter采用aspectj表达式的方式
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //1、定义扫描宝的名称
        String[] basePackages = null;
        //2、判断有@Import注解的类上有没有@ComponentScan注解
        if (importingClassMetadata.hasAnnotation(ComponentScan.class.getName())){
            //3、取出@ComponentScan注解的属性(basePackages/value)
            Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName());
            //4、取出basePackages属性的值
            basePackages = (String[])attributes.get("basePackages");
        }
        //5、判断是否有此注解,是否指定了包扫描的信息
        if (basePackages == null || basePackages.length == 0){
            String basePackage = null;
            try {
                //6、取出@Import注释的类所在包的名称
                basePackage = Class.forName(importingClassMetadata.getClassName()).getPackage().getName();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //7、把这个报名填充到basePackages中
            basePackages = new String[]{basePackage};
        }
        //8、创建类路径扫描器 参数的含义,表示不使用默认过滤规则
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        //9、创建类型过滤器(此处使用的是AspectJ)表达式类型的过滤器
        TypeFilter typeFilter = new AspectJTypeFilter(expression,CustomeImportSelector.class.getClassLoader());
        //10、把类型过滤器添加到扫描器中
        //11、定义要扫描类的全限定类名集合
        final Set<String> classes = new HashSet<String>();
        //12、填充集合的内容
        for (String basePackage : basePackages) {
            scanner.findCandidateComponents(basePackage).forEach(beanDefinition -> classes.add(beanDefinition.getBeanClassName()));
        }
        //13、按照方法的返回值要求,返回全限定类名的数组
        return classes.toArray(new String[classes.size()]);
    }
}
