package net.avantic.scaffolding.java.spring.mvc

import java.beans.Introspector

import net.avantic.scaffolding.java.spring.mvc.builder.DAOFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.FacadeFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.ControllerFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.CommandFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.ViewFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.PropertiesFileBuilder

class Namer {

	def packageName

	def sourceFolder(componentURL) {
		def packageURL = packageName.replace(".", "/")
		"src/${packageURL}/${componentURL}"
	}

}

def inputFile = new File(this.args[0])

def clazz = new GroovyClassLoader().parseClass(inputFile)

def PACKAGE = "org.grecasa.great"

def namer = new Namer(packageName: PACKAGE)

def projectConfiguration = [
	"generationFolder": "generated",
	"basePackage": PACKAGE,
	"securityRoles": "ROLE_ADMIN",
	"className": "${clazz.simpleName}",
	"beanName": Introspector.decapitalize("${clazz.simpleName}"),
	"facadePath": namer.sourceFolder("facade"),
	"controllerPath": namer.sourceFolder("web/controller"),
	"daoPath": namer.sourceFolder("dao"),
	"commandPath": namer.sourceFolder("web/model")
]

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

