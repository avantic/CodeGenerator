package net.avantic.scaffolding.java.spring.mvc.template.controller

import java.beans.Introspector

class ShowControllerTemplate {

	def clazz

	def config

	def build() {
		def beanName = Introspector.decapitalize("${clazz.simpleName}")
		def facadeReference = "${clazz.simpleName}Facade"
		def facadeAttribute = Introspector.decapitalize("${clazz.simpleName}Facade")
"""
ShowControllerTemplate
"""
	}

}