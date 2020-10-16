package com.aboutcourse.common.config;

import com.aboutcourse.common.error.GlobalExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {GlobalExceptionTranslator.class})
public class RestConfig {
}
