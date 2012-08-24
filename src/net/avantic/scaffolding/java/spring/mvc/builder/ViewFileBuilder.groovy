package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.TemplateFactory

class ViewFileBuilder extends AbstractFileBuilder {

	def clazz

	def config

	def build() {
		createFile(
			"${config.generationFolder}/views/${config.beanName}", 
			"list${config.className}s.jsp", 
			writeListViewCode)
		createFile(
			"${config.generationFolder}/views/${config.beanName}", 
			"show${config.className}.jsp", 
			writeShowViewCode)
		createFile(
			"${config.generationFolder}/views/${config.beanName}", 
			"create${config.className}.jsp", 
			writeCreateViewCode)
	}

	def writeListViewCode = {file -> 
		def template = TemplateFactory.getListViewTemplate(clazz, config)
		file.write template.build()
	}

	def writeShowViewCode = {file -> 
		def template = TemplateFactory.getShowViewTemplate(clazz, config)
		file.write template.build()
	}
	
	def writeCreateViewCode = {file -> 
		def template = TemplateFactory.getCreateViewTemplate(clazz, config)
		file.write template.build()
	}

}