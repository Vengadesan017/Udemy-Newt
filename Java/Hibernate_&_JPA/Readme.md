# Hibernate and JPA with Spring
- Before the jpa the application are devloped in jdbc but it create the complexity
- so JPA solve this proble
# Spring boot
- in spring is not easy..
  - config pom.xml  - dependency managemanet
  - web.xml  - Define web app config 
  - context.xml  - Manage spring bean
- so use spring Boot
  - create project with start spring io with Spring web dependency
- Goals
  - Quickly
    - Starter
      - in pom.xml chech the needed starter to build the application
    - auto config
      - use annotation ....
      - in spring boot starter web
        - dispatcher servlet auto configed
        - embedded servlet container tomcat
        - default error pages
        - bean - JSON
    - devtools
      - add dependency like spring-boot-devtools in org.springframework.boot  - to auto restart the server for every changes
    - starter project
  - Production-Ready
    - logging
    - diff conf for diff env
      - levels of logging
        - Trace
        - degub
        - info
        - warning
        - error
        - off
      - Config diff evnironment for developement and production
        - in application.properties
          - logging.level.org.springframework=debug
          - spring.profiles.active=prod  it will active the production config
        - in application-dev.properties
          - logging.level.org.springframework=trace
        - in application-prod.properties
          - logging.level.org.springframework=info
        ```
          advance configuration
         - create the ServiceConfiguration class bas configuration proerty with prefix and as companent
         - set valuve from the properties file
        ```
    - monitoring
      - beans list
      - application health
      - application metrics
      - request mapping
      - Implement using actuator
        1. add dependency spring-boot-starter-actuator
        2. add `management.endpoints.web.exposure.include=health,metrics` in properties
        3. go localhost:8080/actuator
## Spting boot vs Spting MVC vs Spring
1. Spring - Dependency Injection
   - @COmponenet, @Autowire, @ComponentScan
2. Sprin MVC - Web app , REST api  
   - @COmponenet, @RestController, @ResquestMapping("")
3. Spring Boot  - Production ready , qQuickly
   - Starter , Auto config , enable non function requ..(Actuator , embedded server, logging , profiles)
