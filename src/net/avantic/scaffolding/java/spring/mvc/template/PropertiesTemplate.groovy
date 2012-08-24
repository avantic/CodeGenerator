package net.avantic.scaffolding.java.spring.mvc.template

class PropertiesTemplate {

	def clazz

	def config

	def build() {
		def output = """
${config.beanName}.list.title=${config.beanName}
${config.beanName}.detalle.title=${config.beanName}
create${config.className}.title=Crear ${config.beanName}
create${config.className}.button.crear=Crear
create${config.className}.success.message=El ${config.beanName} [{0}] se ha creado correctamente
acciones.create${config.className}=Crear ${config.beanName}		
"""
		clazz.declaredFields.findAll{!it.synthetic}.each { field ->
			output += "${config.beanName}.${field.name}=${field.name}\n"
			output += "${config.beanName}.list.${field.name}=${field.name}\n"
			output += "${config.beanName}.list.${field.name}.title=${field.name}\n"
		}
		
		output
	}
	
}