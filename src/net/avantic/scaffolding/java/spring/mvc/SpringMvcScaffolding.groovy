package net.avantic.scaffolding.java.spring.mvc

import net.avantic.scaffolding.java.spring.mvc.builder.DAOFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.FacadeFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.ControllerFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.CommandFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.ViewFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.PropertiesFileBuilder

import net.avantic.scaffolding.java.spring.mvc.builder.usecase.UseCaseFacadeFileBuilder

def BASE_PACKAGE = "org.grecasa.great"

def projectConfigurationFactory = ProjectConfigurationFactory.newInstance();

if (this.args[0] == "usecase") {
	def useCaseName = this.args[1]
	def projectConfiguration = projectConfigurationFactory.getUseCaseBasedProjectConfiguration(BASE_PACKAGE, useCaseName)
	def builders = [
		UseCaseFacadeFileBuilder.getInstance(projectConfiguration)
	]
	builders.each{builder -> builder.build()}

	println "DONE"
} else if (this.args[0] == "model") {
	def clazz = new GroovyClassLoader().parseClass(new File(this.args[1]))
	def projectConfiguration = projectConfigurationFactory.getModelBasedProjectConfiguration(BASE_PACKAGE, clazz)

	def builders = [
		new DAOFileBuilder(clazz: clazz, config: projectConfiguration),
		new FacadeFileBuilder(clazz: clazz, config: projectConfiguration),
		new ControllerFileBuilder(clazz: clazz, config: projectConfiguration),
		new CommandFileBuilder(clazz: clazz, config: projectConfiguration),
		new ViewFileBuilder(clazz: clazz, config: projectConfiguration),
		new PropertiesFileBuilder(clazz: clazz, config: projectConfiguration)
	]
	builders.each{ builder -> builder.build() }

	println "DONE"
} else {
	println "ERROR: Unknown option"
}


