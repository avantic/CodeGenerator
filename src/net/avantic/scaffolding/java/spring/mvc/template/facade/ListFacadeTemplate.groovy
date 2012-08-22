package net.avantic.scaffolding.java.spring.mvc.template.facade

class ListFacadeTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName};

import java.util.List;

import ${config.basePackage}.model.${config.className};
import org.springframework.security.access.annotation.Secured;

public interface List${config.className}sFacade {

	@Secured({\"FIX_ROLES\"})
	List<${config.className}> list();

}
"""
	}

}