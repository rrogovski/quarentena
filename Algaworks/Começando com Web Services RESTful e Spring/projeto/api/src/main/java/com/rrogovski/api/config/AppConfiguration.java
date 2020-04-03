package com.rrogovski.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * AppConfiguration
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorParameter(true).
      parameterName("mediaType").
      ignoreAcceptHeader(false).
      defaultContentType(MediaType.APPLICATION_JSON).
      mediaType("xml", MediaType.APPLICATION_XML).
      mediaType("json", MediaType.APPLICATION_JSON);
  }
}

// @Configuration
// public class AppConfiguration extends WebMvcConfigurerAdapter {

// @Override
// public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

//     //set path extension to true
//     configurer.favorPathExtension(false).
//     //set favor parameter to false
//     favorParameter(false).
//     //ignore the accept headers
//     ignoreAcceptHeader(false).
//     //dont use Java Activation Framework since we are manually specifying the mediatypes required below
//     useJaf(false).
//     defaultContentType(MediaType.APPLICATION_JSON).
//     mediaType("xml", MediaType.APPLICATION_XML).
//     mediaType("json", MediaType.APPLICATION_JSON);
//   }
// }