package cn.keking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenjh
 * @since 2020/5/18 13:41
 */
@Configuration
public class RFCConfig {

    /**
     * Author：houzheng
     * Date：11-18
     * 设置请求目标允许
     * 解决Tomcat 报The valid characters are defined in RFC 7230 and RFC 3986
     *
     */

    @Bean
    public Boolean setRequestTargetAllow() {
        // RFC 7230，RFC 3986规范不允许url相关特殊字符，手动指定Tomcat url允许特殊符号， 如{}做入参，其他符号按需添加。见tomcat的HttpParser源码。
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "|{}");
        return true;
    }
}
