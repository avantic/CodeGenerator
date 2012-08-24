package net.avantic.scaffolding.java.spring.mvc.template.facade

class ShowFacadeTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName};

import ${config.basePackage}.model.${config.className};
import org.springframework.security.access.annotation.Secured;

public interface Show${config.className}Facade {

	/*
	 * This is a generated file, please check for the next items:
	 * FIX_ROLES
	 */
	 
	@Secured({\"FIXME\"})
	${config.className} get(Long id${config.className});

}
"""
	}
	
}