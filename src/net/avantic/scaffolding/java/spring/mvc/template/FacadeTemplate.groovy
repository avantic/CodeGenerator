package net.avantic.scaffolding.java.spring.mvc.template

import java.beans.Introspector;

class FacadeTemplate {

	def clazz

	def projectConfiguration

	def build() {
"""
package ${projectConfiguration.basePackage}.facade;

import java.util.List;

import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public interface ${clazz.simpleName}Facade {

	@Secured({${projectConfiguration.securityRoles}})
	public List<${clazz.simpleName}> list();

}
"""
	}

}