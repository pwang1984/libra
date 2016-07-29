/**
 * 
 */
package com.catsvie.libra.security;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Bean configuration for menu item related objects.
 * 
 * @author Peng Wang <br/>
 *         Feb 9, 2016
 * @version 1.0 <br/>
 */
@Configuration
@ComponentScan({ ConfigConstants.WEB_RESTFUL_API_PACKAGE, ConfigConstants.WEB_CONTROLLER_PACKAGE })
@EnableJpaRepositories(ConfigConstants.DAO_PACKAGE)
@EntityScan(ConfigConstants.ENTITIES_PACKAGE)
@EnableTransactionManagement
public class ModuleConfig {
}
