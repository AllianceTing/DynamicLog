package com.example.dynamiclog;

import org.springframework.stereotype.Component;

/**
 * PROJECT_NAME LogFactory
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/18~16:20
 */
@Component
public class LogFactory {
/**
 * @description: logfactory to reduce Coupling
 * @author https://github.com/AllianceToBeBytedancer
 */
private static volatile LogFactory logFactory;
// constructor method private
private LogFactory() {
}

public static LogFactory  doCreateLogFactory(){

    if(logFactory==null) {
        synchronized (LogFactory.class) {
            logFactory = new LogFactory();
        }
    }
        return logFactory;
}


}
