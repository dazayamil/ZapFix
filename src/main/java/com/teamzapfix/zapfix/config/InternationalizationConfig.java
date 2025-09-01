package com.teamzapfix.zapfix.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {
    List<Locale> languages = Arrays.asList(new Locale("ES"), new Locale("EN"));
    
    /**
     * Bean
     * public MessageSource messageSource() {
     * ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
     * messageSource.setBasename("messages");
     * messageSource.setDefaultEncoding("UTF-8");
     * messageSource.setFallbackToSystemLocale(false);
     * messageSource.setUseCodeAsDefaultMessage(true);
     * return messageSource;
     * }
     */
    
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(languages.get(0));
        localeResolver.setSupportedLocales(languages);
        
        return localeResolver;
    }
    
    /**
     * Bean
     * private LocaleResolver localeResolver() {
     * SessionLocaleResolver sessionLocaleR = new SessionLocaleResolver();
     * sessionLocaleR.setDefaultLocale(languages.get(0));
     * return sessionLocaleR;
     * }
     */
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        
        return localeChangeInterceptor;
    }
    
    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}