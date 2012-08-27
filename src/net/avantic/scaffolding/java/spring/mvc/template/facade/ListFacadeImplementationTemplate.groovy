package net.avantic.scaffolding.java.spring.mvc.template.facade

class ListFacadeImplementationTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ${config.basePackage}.dao.${config.className}DAO;
import ${config.basePackage}.facade.${config.beanName}.List${config.className}sFacade;
import ${config.basePackage}.model.${config.className};
import org.springframework.stereotype.Component;

@Component(\"list${config.className}sFacade\")
public class List${config.className}sFacadeImpl implements List${config.className}sFacade {
	
	@Autowired private ${config.className}DAO ${config.beanName}DAO;

	@Override
	public List<${config.className}> list() {
		return ${config.beanName}DAO.list();
	}

}
"""
	}

}