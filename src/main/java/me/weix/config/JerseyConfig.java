package me.weix.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
@Configuration
public class JerseyConfig extends ResourceConfig implements EnvironmentAware {

  @Autowired
  ServletContext servletContext;

  private static final String ENV_SWAGGER = "logic.swagger.";


  private final Logger log = LoggerFactory.getLogger(JerseyConfig.class);

  private static RelaxedPropertyResolver relaxedPropertyResolver;

  public JerseyConfig() {
    log.info("Jersey configuration");

    register(RequestContextFilter.class);
    register(WadlResource.class);

    //配置restful package.
    //packages("me.weix.whatever.rest","com.logic.landseaserver.ws");
    packages("me.weix.whatever.rest");
  }
  @Override
  public void setEnvironment(Environment environment) {
    relaxedPropertyResolver = new RelaxedPropertyResolver(environment, ENV_SWAGGER);
  }
}
