package com.ld.base.core.config.fegin;

import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * feign配置
 *
 * @author 王海龙
 */
@Configuration
@ConditionalOnClass({Feign.class})
public class FeignConfig {

    /**
     * 重载feign中的WebMvcRegistrations
     *
     * @return WebMvcRegistrations
     */
    @Bean
    public WebMvcRegistrations feignWebRegistrations() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new FeignRequestMappingHandlerMapping();
            }
        };
    }

    /**
     * 禁止feign中的RequestMapping注册，否则会与controller中的RequestMapping发生冲突
     *
     * @author 王海龙
     */
    private static class FeignRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) &&
                    !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
        }
    }
}

