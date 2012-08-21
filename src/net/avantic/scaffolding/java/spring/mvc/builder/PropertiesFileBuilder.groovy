package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.PropertiesTemplate

class PropertiesFileBuilder extends AbstractFileBuilder {

	def clazz

	def projectConfiguration

	def build() {
		buildPropertiesFile("${projectConfiguration.generatedRootFolder}", "${clazz.simpleName}", writeLabelsCode, clazz)
	}

	def writeLabelsCode = {file -> 
		def template = new PropertiesTemplate(clazz : clazz)
		file.write template.build()
	}

}