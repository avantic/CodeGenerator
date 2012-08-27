package net.avantic.scaffolding.java.spring.mvc.template.facade

class ShowFacadeImplementationTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName}.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ${config.basePackage}.dao.${config.className}DAO;
import ${config.basePackage}.facade.${config.beanName}.Show${config.className}Facade;
import ${config.basePackage}.model.${config.className};
import org.springframework.stereotype.Component;

@Component(\"show${config.className}Facade\")
public class Show${config.className}FacadeImpl implements Show${config.className}Facade {

	@Autowired protected ${config.className}DAO ${config.beanName}DAO;
	
	@Override
	public ${config.className} get(Long id${config.className}) {
		${config.className} ${config.beanName} = ${config.beanName}DAO.get(id${config.className});

		return ${config.beanName};
	}

}

"""
	}
	
}