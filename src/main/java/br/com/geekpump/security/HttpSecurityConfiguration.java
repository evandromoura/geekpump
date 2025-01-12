
package br.com.geekpump.security;

import javax.enterprise.event.Observes;

import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

public class HttpSecurityConfiguration {

	public void onInit(@Observes SecurityConfigurationEvent event) {
		SecurityConfigurationBuilder builder = event.getBuilder();
		builder.http().allPaths()
	    	.authenticateWith().form()
	    		.authenticationUri("/login").loginPage("/login").errorPage("/login").restoreOriginalRequest()
	    	.forPath("/javax.faces.resource/*").unprotected()
	    	.forPath("/assets/*").unprotected()
	    	.forPath("/auth/*").unprotected()
	    	.forPath("/favicon.ico").unprotected()
			.forPath("/index.html").unprotected()
		    .forPath("/logout").logout().redirectTo("/index");
	}
	

}