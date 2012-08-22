package net.avantic.scaffolding.java.spring.mvc.template.dao

import java.beans.Introspector

class DAOHibernateTemplate {
	
	def clazz

	def config

	def build() {
	"""
package ${config.basePackage}.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import ${config.basePackage}.dao.${config.className}DAO;
import ${config.basePackage}.model.${config.className};

public class ${config.className}DAOHibernate extends HibernateDaoSupport implements ${config.className}DAO {

	@Override
	public void saveOrUpdate(${config.className} entity) {
		Assert.notNull(entity, \"No se puede guardar una entidad nula!!!\");
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public ${config.className} get(Long identifier) {
		Assert.notNull(identifier, \"No se puede obtener una entidad a partir de un identificador nulo!!!\");
		return (${config.className}) getHibernateTemplate().get(${config.className}.class, identifier);
	}

	@Override
	public void delete(${config.className} entity) {
		Assert.notNull(entity, \"No se puede borrar una entidad nula!!!\");
		getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings(\"unchecked\")
	@Override
	public List<${config.className}> list() {
		return getHibernateTemplate().loadAll(${config.className}.class);
	}

	@Override
	public void initialize(${config.className} ${config.beanName}) {
		getHibernateTemplate().initialize(${config.beanName});
	}

}
"""
	}

}