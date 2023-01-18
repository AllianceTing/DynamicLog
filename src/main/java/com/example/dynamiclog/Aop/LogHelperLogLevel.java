package com.example.dynamiclog.Aop;

import org.springframework.stereotype.Component;

/**
 * PROJECT_NAME LogHelperLogLevel
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/17~20:43
 */
@Component
public class LogHelperLogLevel {
/**
 * @author https://github.com/AllianceTing
 * @Desc 日志追踪级别
 */

static final Integer NONE = -1;

static final Integer ALL =0;

static final Integer Trace = 1;

static final Integer Debug = 2;

static final Integer Info = 3;

static final Integer Warn = 4;

static final Integer Fatal = 5;
}
