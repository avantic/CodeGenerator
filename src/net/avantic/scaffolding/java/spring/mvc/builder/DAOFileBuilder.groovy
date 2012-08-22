package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.dao.DAOTemplate
import net.avantic.scaffolding.java.spring.mvc.template.dao.DAOHibernateTemplate

class DAOFileBuilder extends AbstractFileBuilder {

	def clazz

	def config

	def build() {
		createFile(
			"${config.generationFolder}/${config.daoPath}",  
			"${clazz.simpleName}DAO.java", 
			writeDaoCode)
		createFile(
			"${config.generationFolder}/${config.daoPath}/hibernate", 
			"${clazz.simpleName}DAOHibernate.java", 
			writeDaoHibernateCode)
	}

	def writeDaoCode = {file -> 
		def template = new DAOTemplate(clazz : clazz, config : config)
		file.write template.build()
	}

	def writeDaoHibernateCode = {file -> 
		def template = new DAOHibernateTemplate(clazz : clazz, config : config)
		file.write template.build()
	}

}
