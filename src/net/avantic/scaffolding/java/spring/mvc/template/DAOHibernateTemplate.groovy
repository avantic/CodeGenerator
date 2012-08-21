package net.avantic.scaffolding.java.spring.mvc.template

import java.beans.Introspector

class DAOHibernateTemplate {
	
	def clazz

	def projectConfiguration

	def build() {
	"""
package ${projectConfiguration.basePackage}.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import ${projectConfiguration.basePackage}.dao.${clazz.simpleName}DAO;
import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public class ${clazz.simpleName}DAOHibernate extends HibernateDaoSupport implements ${clazz.simpleName}DAO {

	@Override
	public void saveOrUpdate(${clazz.simpleName} entity) {
		Assert.notNull(entity, \"No se puede guardar una entidad nula!!!\");
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public ${clazz.simpleName} get(Long identifier) {
		Assert.notNull(identifier, \"No se puede obtener una entidad a partir de un identificador nulo!!!\");
		return (${clazz.simpleName}) getHibernateTemplate().get(${clazz.simpleName}.class, identifier);
	}

	@Override
	public void delete(${clazz.simpleName} entity) {
		Assert.notNull(entity, \"No se puede borrar una entidad nula!!!\");
		getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings(\"unchecked\")
	@Override
	public List<${clazz.simpleName}> list() {
		return getHibernateTemplate().loadAll(${clazz.simpleName}.class);
	}

}
"""
	}

}