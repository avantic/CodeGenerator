package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.TemplateFactory

class ControllerFileBuilder extends AbstractFileBuilder {

	def clazz

	def config

	def build() {
		createFile(
			"${config.generationFolder}/${config.controllerPath}/${config.beanName}", 
			"Create${config.className}Controller.java", 
			writeCreateControllerCode)
		createFile(
			"${config.generationFolder}/${config.controllerPath}/${config.beanName}", 
			"List${config.className}sController.java", 
			writeListControllerCode)
		createFile(
			"${config.generationFolder}/${config.controllerPath}/${config.beanName}", 
			"Show${config.className}Controller.java", 
			writeShowControllerCode)
	}

	def writeCreateControllerCode = {file -> 
		def template = TemplateFactory.getCreateControllerTemplate(clazz, config)
		file.write template.build()
	}

	def writeListControllerCode = {file -> 
		def template = TemplateFactory.getListControllerTemplate(clazz, config)
		file.write template.build()
	}

	def writeShowControllerCode = {file -> 
		def template = TemplateFactory.getShowControllerTemplate(clazz, config)
		file.write template.build()
	}

}