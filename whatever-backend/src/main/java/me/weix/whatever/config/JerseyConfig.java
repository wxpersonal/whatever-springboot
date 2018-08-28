package me.weix.whatever.config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
@Configuration
public class JerseyConfig extends ResourceConfig  {



  private final Logger log = LoggerFactory.getLogger(JerseyConfig.class);

  public JerseyConfig() {
    log.info("Jersey configuration");
    register(WadlResource.class);
    register(ObjectMapperProvider.class);
    register(JacksonJsonProvider.class);

//    register(FastJsonProvider.class);
    //packages("me.weix.whatever.rest","com.logic.landseaserver.ws");
    packages("me.weix.whatever.rest");
  }

  @PostConstruct
  public void init() {
    this.configureSwagger();
  }


  private void configureSwagger() {
    register(ApiListingResource.class);
    register(SwaggerSerializers.class);

    BeanConfig config = new BeanConfig();
    config.setTitle("whatever restful api");
    config.setContact("WeiXiang");
    config.setSchemes(new String[] { "http", "https" });
    config.setBasePath("/api");
    config.setResourcePackage("me.weix.whatever.rest");
    config.setPrettyPrint(true);
    config.setScan(true);
  }

}
