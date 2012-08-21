package net.avantic.scaffolding.java.spring.mvc.template

import java.beans.Introspector

class DAOTemplate {

	def clazz

	def projectConfiguration

	def build() {
"""
package ${projectConfiguration.basePackage}.dao;

import java.util.List;

import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public interface ${clazz.simpleName}DAO {

	public void saveOrUpdate(${clazz.simpleName} entity);

	public ${clazz.simpleName} get(Long identifier);

	public void delete(${clazz.simpleName} entity);

	public List<${clazz.simpleName}> list();

}
"""
	}

}