package net.avantic.scaffolding.java.spring.mvc.builder.usecase

import net.avantic.scaffolding.java.spring.mvc.builder.AbstractFileBuilder
import net.avantic.scaffolding.java.spring.mvc.template.usecase.facade.FacadeTemplate

class UseCaseFacadeFileBuilder extends AbstractFileBuilder {

	def config

	def build() {
		createFile(
			"${config.generationFolder}/${config.facadePath}/usecase", 
			"${config.useCaseName}Facade.java", 
			writeFacadeCode)
	}

	def writeFacadeCode = {file -> 
		def template = FacadeTemplate.getInstance(config)
		file.write template.build()
	}

	static def getInstance(config) {
		def builder = UseCaseFacadeFileBuilder.newInstance()
		builder.config = config

		builder
	} 

}