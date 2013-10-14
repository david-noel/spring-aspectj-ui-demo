package ui;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@EnableSpringConfigured
@ComponentScan
@EnableAutoConfiguration
public class Application implements ApplicationContextAware {

    private static AutowireCapableBeanFactory factory;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static <T> T wire(T o) {
        factory.autowireBean(o);
        return (T)factory.initializeBean(o, "manualWire");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        factory = applicationContext.getAutowireCapableBeanFactory();
    }

    @Bean
    public Message message() {
        return new Message();
    }

}

