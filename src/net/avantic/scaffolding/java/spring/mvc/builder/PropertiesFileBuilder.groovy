package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.PropertiesTemplate

class PropertiesFileBuilder extends AbstractFileBuilder {

	def clazz

	def config

	def build() {
		createFile(
			"${config.generationFolder}",
			"${config.className}.properties",
			writeLabelsCode)
	}

	def writeLabelsCode = {file -> 
		def template = new PropertiesTemplate(clazz: clazz, config: config)
		file.write template.build()
	}

}