package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.FacadeTemplate
import net.avantic.scaffolding.java.spring.mvc.template.FacadeImplementationTemplate

class FacadeFileBuilder extends AbstractFileBuilder {

	def clazz

	def projectConfiguration

	def build() {
		buildFile("${projectConfiguration.generatedRootFolder}/facade", "${clazz.simpleName}Facade", writeFacadeCode)
		buildFile("${projectConfiguration.generatedRootFolder}/facade/impl", "${clazz.simpleName}FacadeImpl", writeFacadeImplementationCode)
	}

	def writeFacadeCode = {file -> 
		def template = new FacadeTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
		file.write template.build()
	}

	def writeFacadeImplementationCode = {file -> 
		def template = new FacadeImplementationTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
		file.write template.build()
	}

}