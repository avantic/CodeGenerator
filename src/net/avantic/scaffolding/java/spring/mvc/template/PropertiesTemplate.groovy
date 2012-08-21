package net.avantic.scaffolding.java.spring.mvc.template

import java.beans.Introspector

class PropertiesTemplate {

	def clazz

	def build() {
		def output = ""

		def beanName = Introspector.decapitalize("${clazz.simpleName}")
		clazz.declaredFields.findAll{!it.synthetic}.each { field ->
			output += "${beanName}.list.${field.name}=${field.name}\n"
			output += "${beanName}.list.${field.name}.title=${field.name}\n"
		}

		output
	}
}