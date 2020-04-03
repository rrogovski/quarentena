package com.rrogovski.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * AppConfiguration
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorPathExtension(false).
      favorParameter(true).
      parameterName("mediaType").
      ignoreAcceptHeader(true).
      useJaf(false).
      defaultContentType(MediaType.APPLICATION_JSON).
      mediaType("xml", MediaType.APPLICATION_XML).
      mediaType("json", MediaType.APPLICATION_JSON);
  }
}