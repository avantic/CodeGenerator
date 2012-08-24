package net.avantic.scaffolding.java.spring.mvc.template.command

class CreateCommandTemplate {

	def clazz

	def config

	def foo(field) {
		!field.synthetic && field.name != "serialVersionUID"
	}

	def buildFields() {
		def output = ""
		clazz.declaredFields.findAll{foo(it)}.each { field ->
			output += """
	private ${field.type.simpleName} ${field.name};
			"""
		}
		output
	}

	def build() {
"""
package ${config.basePackage}.web.model;

import java.io.Serializable;

public class Create${config.className}Request implements Serializable {

	private static final long serialVersionUID = 1L;
	
	${buildFields()}

	// FIXME don't forget generate getters, setters and toString methods

}
"""
	}

}