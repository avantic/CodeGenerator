package net.avantic.scaffolding.java.spring.mvc.template.dao

import java.beans.Introspector

class DAOTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.dao;

import java.util.List;

import ${config.basePackage}.model.${config.className};

public interface ${config.className}DAO {

	public void saveOrUpdate(${config.className} entity);

	public ${config.className} get(Long identifier);

	public void delete(${config.className} entity);

	public List<${config.className}> list();

	public void initialize(${config.className} ${config.beanName});

}
"""
	}

}