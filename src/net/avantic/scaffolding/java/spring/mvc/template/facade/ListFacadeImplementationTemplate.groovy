package net.avantic.scaffolding.java.spring.mvc.template.facade

class ListFacadeImplementationTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName}.impl;

import java.util.List;

import ${config.basePackage}.dao.${config.className}DAO;
import ${config.basePackage}.facade.${config.beanName}.List${config.className}sFacade;
import ${config.basePackage}.model.${config.className};

public class List${config.className}sFacadeImpl implements List${config.className}sFacade {
	
	private ${config.className}DAO ${config.beanName}DAO;

	@Override
	public List<${config.className}> list() {
		return ${config.beanName}DAO.list();
	}

	public void set${config.className}DAO(${config.className}DAO ${config.beanName}DAO) {
		this.${config.beanName}DAO = ${config.beanName}DAO;
	}

}
"""
	}

}