package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.DAOTemplate
import net.avantic.scaffolding.java.spring.mvc.template.DAOHibernateTemplate

class DAOFileBuilder extends AbstractFileBuilder {

	def clazz

	def projectConfiguration

	def build() {
		buildFile("${projectConfiguration.generatedRootFolder}/dao", "${clazz.simpleName}DAO", writeDaoCode)
		buildFile("${projectConfiguration.generatedRootFolder}/dao/hibernate", "${clazz.simpleName}DAOHibernate", writeDaoHibernateCode)
	}

	def writeDaoCode = {file -> 
		def template = new DAOTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
		file.write template.build()
	}

	def writeDaoHibernateCode = {file -> 
		def template = new DAOHibernateTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
		file.write template.build()
	}

}
