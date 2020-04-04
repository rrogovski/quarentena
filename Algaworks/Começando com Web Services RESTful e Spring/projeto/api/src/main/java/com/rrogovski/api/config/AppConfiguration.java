package com.rrogovski.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * AppConfiguration
 */
@Configuration
@EnableWebMvc
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