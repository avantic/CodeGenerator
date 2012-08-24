package net.avantic.scaffolding.java.spring.mvc.template

import net.avantic.scaffolding.java.spring.mvc.template.FieldAnalyzer
import net.avantic.scaffolding.java.spring.mvc.template.command.CreateCommandTemplate
import net.avantic.scaffolding.java.spring.mvc.template.controller.CreateControllerTemplate
import net.avantic.scaffolding.java.spring.mvc.template.controller.ListControllerTemplate
import net.avantic.scaffolding.java.spring.mvc.template.controller.ShowControllerTemplate
import net.avantic.scaffolding.java.spring.mvc.template.view.CreateViewTemplate
import net.avantic.scaffolding.java.spring.mvc.template.view.ListViewTemplate
import net.avantic.scaffolding.java.spring.mvc.template.view.ShowViewTemplate

class TemplateFactory {

	static def fieldAnalyzer = new FieldAnalyzer();

	static def getCreateCommandTemplate(clazz, config) {
		new CreateCommandTemplate(clazz: clazz, config: config, fieldAnalyzer: fieldAnalyzer)
	}

	static def getCreateControllerTemplate(clazz, config) {
		new CreateControllerTemplate(clazz: clazz, config: config)
	}

	static def getListControllerTemplate(clazz, config) {
		new CreateControllerTemplate(clazz: clazz, config: config)
	}

	static def getShowControllerTemplate(clazz, config) {
		new CreateControllerTemplate(clazz: clazz, config: config)
	}

	static def getCreateViewTemplate(clazz, config) {
		new CreateViewTemplate(clazz: clazz, config: config, fieldAnalyzer: fieldAnalyzer)
	}

	static def getListViewTemplate(clazz, config) {
		new ListViewTemplate(clazz: clazz, config: config, fieldAnalyzer: fieldAnalyzer)
	}

	static def getShowViewTemplate(clazz, config) {
		new ShowViewTemplate(clazz: clazz, config: config, fieldAnalyzer: fieldAnalyzer)
	}

}