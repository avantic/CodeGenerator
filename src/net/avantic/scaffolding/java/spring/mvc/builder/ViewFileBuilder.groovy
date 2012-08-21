package net.avantic.scaffolding.java.spring.mvc.builder

import net.avantic.scaffolding.java.spring.mvc.template.ListViewTemplate
import net.avantic.scaffolding.java.spring.mvc.template.ShowViewTemplate

class ViewFileBuilder extends AbstractFileBuilder {

	def clazz

	def projectConfiguration

	def build() {
		buildViewFile("${projectConfiguration.generatedRootFolder}/view/protected", "list", writeListViewCode, clazz)
		buildViewFile("${projectConfiguration.generatedRootFolder}/view/protected", "show", writeShowViewCode, clazz)
	}

	def writeListViewCode = {file -> 
		def template = new ListViewTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
		file.write template.build()
	}

	def writeShowViewCode = {file -> 
		def template = new ShowViewTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
		file.write template.build()
	}

}