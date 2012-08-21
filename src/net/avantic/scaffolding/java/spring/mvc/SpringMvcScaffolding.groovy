package net.avantic.scaffolding.java.spring.mvc

import net.avantic.scaffolding.java.spring.mvc.builder.DAOFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.FacadeFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.ControllerFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.ViewFileBuilder
import net.avantic.scaffolding.java.spring.mvc.builder.PropertiesFileBuilder

def projectConfiguration = [
	"generatedRootFolder": "generated",
	"basePackage": "net.avantic.project",
	"securityRoles": "ROLE_ADMIN"
]

def inputFile = new File(this.args[0])

def clazz = new GroovyClassLoader().parseClass(inputFile)

def builders = [
	new DAOFileBuilder(clazz: clazz, projectConfiguration: projectConfiguration),
	new FacadeFileBuilder(clazz: clazz, projectConfiguration: projectConfiguration),
	new ControllerFileBuilder(clazz: clazz, projectConfiguration: projectConfiguration),
	new ViewFileBuilder(clazz: clazz, projectConfiguration: projectConfiguration),
	new PropertiesFileBuilder(clazz: clazz, projectConfiguration: projectConfiguration)
]
builders.each{ builder -> builder.build() }

println "DONE"