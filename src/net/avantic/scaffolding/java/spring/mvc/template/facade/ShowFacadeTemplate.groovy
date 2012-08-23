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

	@Secured({\"FIXME\"})
	${config.className} get(Long id${config.className});

}
"""
	}
	
}