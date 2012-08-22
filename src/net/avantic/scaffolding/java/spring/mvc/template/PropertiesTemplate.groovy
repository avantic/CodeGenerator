package net.avantic.scaffolding.java.spring.mvc.template

class PropertiesTemplate {

	def clazz

	def config

	def build() {
		def output = ""

		output += "${config.beanName}.list.title=${config.beanName}\n"
		clazz.declaredFields.findAll{!it.synthetic}.each { field ->
			output += "${config.beanName}.list.${field.name}=${field.name}\n"
			output += "${config.beanName}.list.${field.name}.title=${field.name}\n"
		}
		output += "create${config.className}.success.message=FIX_SUCCESS_MESSAGE\n"

		output
	}
	
}