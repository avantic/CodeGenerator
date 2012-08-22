package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.controller.CreateControllerTemplate
import net.avantic.scaffolding.java.spring.mvc.template.controller.ListControllerTemplate
import net.avantic.scaffolding.java.spring.mvc.template.controller.ShowControllerTemplate

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
		def template = new CreateControllerTemplate(clazz : clazz, config : config)
		file.write template.build()
	}

	def writeListControllerCode = {file -> 
		def template = new ListControllerTemplate(clazz : clazz, config : config)
		file.write template.build()
	}

	def writeShowControllerCode = {file -> 
		def template = new ShowControllerTemplate(clazz : clazz, config : config)
		file.write template.build()
	}

}