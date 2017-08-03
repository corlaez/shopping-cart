package com.cesarmando.website.config;

import com.cesarmando.website.util.AndProfileCondition;
import com.cesarmando.website.util.TomcatProfileCondition;
//import io.undertow.UndertowOptions;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http2.Http2Protocol;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.eclipse.jetty.servlets.PushCacheFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jarma on 8/1/2017.
 */
@Configuration
public class ServerConfig {

    @Value("${server.http.port}")
    private int httpPort;

    @Value("${server.port}")
    private int port;

    @Value("${custom.httpToHttps}")
    private Boolean httpToHttps;

    private String defaultProtocol = TomcatEmbeddedServletContainerFactory.DEFAULT_PROTOCOL;

    @Bean//COULD NOT HTTP2
    @Conditional(TomcatProfileCondition.class)
    //https://github.com/otrosien/demo-http2
    // The upgrade handler [org.apache.coyote.http2.Http2Protocol] for [h2]
    // only supports upgrade via ALPN but has been configured for the ["https-jsse-nio-8443"]
    // connector that does not support ALPN.
    public EmbeddedServletContainerFactory tomcat() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                if(httpToHttps) {
                    SecurityConstraint securityConstraint = new SecurityConstraint();
                    securityConstraint.setUserConstraint("CONFIDENTIAL");
                    SecurityCollection collection = new SecurityCollection();
                    collection.addPattern("/*");
                    securityConstraint.addCollection(collection);
                    context.addConstraint(securityConstraint);
                }
                else {
                    super.postProcessContext(context);
                }
            }
        };
        Connector connector = new Connector(defaultProtocol);
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        if(httpToHttps)
            connector.setRedirectPort(port);
        tomcat.addAdditionalTomcatConnectors(connector);
        tomcat.addConnectorCustomizers((c) ->
                c.addUpgradeProtocol(new Http2Protocol()));
        return tomcat;
    }

    @Bean
    @Profile({"jetty"})
    @Conditional(AndProfileCondition.class)
    public EmbeddedServletContainerCustomizer jettyHttp2Customizer(ServerProperties serverProperties) {
        //https://github.com/bclozel/http2-experiments
        return new JettyHttp2Customizer(serverProperties);
    }

    @Bean
    @Profile("jetty")
    public FilterRegistrationBean pushCacheFilterRegistration() {
        //https://github.com/making/demo-http2
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new PushCacheFilter());
        return registration;
    }

//    @Bean
//    @Profile("undertow")//HTTP2
//    UndertowEmbeddedServletContainerFactory undertow() {
//        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
//        factory.addBuilderCustomizers(//needs dependency
//                builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
//        return factory;
//    }
}