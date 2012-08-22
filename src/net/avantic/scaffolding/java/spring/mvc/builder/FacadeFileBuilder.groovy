package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.facade.ListFacadeTemplate
import net.avantic.scaffolding.java.spring.mvc.template.facade.CreateFacadeTemplate
import net.avantic.scaffolding.java.spring.mvc.template.facade.ListFacadeImplementationTemplate
import net.avantic.scaffolding.java.spring.mvc.template.facade.CreateFacadeImplementationTemplate

class FacadeFileBuilder extends AbstractFileBuilder {

	def clazz

	def config

	def build() {
		createFile(
			"${config.generationFolder}/${config.facadePath}/${config.beanName}", 
			"List${config.className}sFacade.java", 
			writeListFacadeCode)
		createFile(
			"${config.generationFolder}/${config.facadePath}/${config.beanName}", 
			"Create${config.className}Facade.java", 
			writeCreateFacadeCode)
		createFile(
			"${config.generationFolder}/${config.facadePath}/${config.beanName}/impl", 
			"List${config.className}sFacadeImpl.java", 
			writeListFacadeImplementationCode)
		createFile(
			"${config.generationFolder}/${config.facadePath}/${config.beanName}/impl", 
			"Create${config.className}FacadeImpl.java", 
			writeCreateFacadeImplementationCode)
	}

	def writeListFacadeCode = {file -> 
		def template = new ListFacadeTemplate(clazz: clazz, config: config)
		file.write template.build()
	}

	def writeCreateFacadeCode = {file ->
		def template = new CreateFacadeTemplate(clazz: clazz, config: config)
		file.write template.build()
	}

	def writeListFacadeImplementationCode = {file -> 
		def template = new ListFacadeImplementationTemplate(clazz: clazz, config: config)
		file.write template.build()
	}

	def writeCreateFacadeImplementationCode = {file ->
		def template = new CreateFacadeImplementationTemplate(clazz: clazz, config: config)
		file.write template.build()
	}

}