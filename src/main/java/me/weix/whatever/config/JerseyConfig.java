package me.weix.whatever.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
@Configuration
public class JerseyConfig extends ResourceConfig implements EnvironmentAware {


  private static final String ENV_SWAGGER = "logic.swagger.";


  private final Logger log = LoggerFactory.getLogger(JerseyConfig.class);

  private static RelaxedPropertyResolver relaxedPropertyResolver;

  public JerseyConfig() {
    log.info("Jersey configuration");
    register(WadlResource.class);
    //packages("me.weix.whatever.rest","com.logic.landseaserver.ws");
    packages("me.weix.whatever.rest");
  }

  @PostConstruct
  public void init() {
    this.configureSwagger();
  }


  private void configureSwagger() {
    this.register(ApiListingResource.class);
    this.register(SwaggerSerializers.class);

    BeanConfig config = new BeanConfig();
    config.setTitle("POC - Restful API by Spring Boot, Jersey, Swagger");
    config.setVersion("v1");
    config.setContact("Bright Zheng");
    config.setSchemes(new String[] { "http", "https" });
    config.setBasePath("/api");
    config.setResourcePackage("me.weix.whatever.rest");
    config.setPrettyPrint(true);
    config.setScan(true);
  }
  @Override
  public void setEnvironment(Environment environment) {
    relaxedPropertyResolver = new RelaxedPropertyResolver(environment, ENV_SWAGGER);
  }
}