package net.avantic.scaffolding.java.spring.mvc

import java.beans.Introspector

class ProjectConfigurationFactory {

	def getUseCaseBasedProjectConfiguration(packageName, useCaseName) {
		def namer = Namer.getInstance(packageName)
		[
			"generationFolder": "generated",
			"basePackage": packageName,
			"useCaseName": useCaseName,
			"beanUseCaseName": Introspector.decapitalize(useCaseName),
			"facadePath": namer.sourceFolder("facade"),
			"controllerPath": namer.sourceFolder("web/controller"),
			"daoPath": namer.sourceFolder("dao"),
			"commandPath": namer.sourceFolder("web/model")
		]
	}

	def getModelBasedProjectConfiguration(packageName, clazz) {
		def namer = Namer.getInstance(packageName)
		[
			"generationFolder": "generated",
			"basePackage": packageName,
			"className": "${clazz.simpleName}",
			"beanName": Introspector.decapitalize("${clazz.simpleName}"),
			"facadePath": namer.sourceFolder("facade"),
			"controllerPath": namer.sourceFolder("web/controller"),
			"daoPath": namer.sourceFolder("dao"),
			"commandPath": namer.sourceFolder("web/model")
		]
	}

}