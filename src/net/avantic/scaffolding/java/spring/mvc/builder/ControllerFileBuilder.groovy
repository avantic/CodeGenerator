package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.ControllerTemplate

class ControllerFileBuilder extends AbstractFileBuilder {

	def clazz

	def projectConfiguration

	def build() {
		buildFile("${projectConfiguration.generatedRootFolder}/controller", "${clazz.simpleName}Controller", writeControllerCode)
	}

	def writeControllerCode = {file -> 
		def template = new ControllerTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
		file.write template.build()
	}

}