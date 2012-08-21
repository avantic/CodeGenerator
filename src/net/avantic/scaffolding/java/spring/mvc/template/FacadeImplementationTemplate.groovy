package net.avantic.scaffolding.java.spring.mvc.template

import java.beans.Introspector;

class FacadeImplementationTemplate {

	def clazz

	def projectConfiguration

	def build() {
		def daoReference = "${clazz.simpleName}DAO"
		def daoAttribute = Introspector.decapitalize("${clazz.simpleName}DAO")
		def facadeReference = "${clazz.simpleName}Facade"

"""
package ${projectConfiguration.basePackage}.facade.impl;

import java.util.List;

import ${projectConfiguration.basePackage}.dao.${daoReference};
import ${projectConfiguration.basePackage}.facade.${facadeReference};
import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public class ${clazz.simpleName}FacadeImpl implements ${facadeReference} {

	private ${daoReference} ${daoAttribute};

	public List<${clazz.simpleName}> list() {
		return ${daoAttribute}.list();
	}

	public void set${daoReference}(${daoReference} ${daoAttribute}) {
		this.${daoAttribute} = ${daoAttribute};
	}

}
"""
	}

}