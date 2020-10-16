package com.aboutcourse.course.presentation.Config;

import com.aboutcourse.common.config.RestConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {RestConfig.class})
public class AppConfig {
}
