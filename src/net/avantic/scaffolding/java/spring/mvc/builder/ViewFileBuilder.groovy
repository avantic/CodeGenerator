package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.view.ListViewTemplate
import net.avantic.scaffolding.java.spring.mvc.template.view.ShowViewTemplate
import net.avantic.scaffolding.java.spring.mvc.template.view.CreateViewTemplate

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
			writeShowViewCode)
	}

	def writeListViewCode = {file -> 
		def template = new ListViewTemplate(clazz : clazz, config : config)
		file.write template.build()
	}

	def writeShowViewCode = {file -> 
		def template = new ShowViewTemplate(clazz : clazz, projectConfiguration : config)
		file.write template.build()
	}
	
	def writeCreateViewCode = {file -> 
		def template = new CreateViewTemplate(clazz : clazz, projectConfiguration : config)
		file.write template.build()
	}

}