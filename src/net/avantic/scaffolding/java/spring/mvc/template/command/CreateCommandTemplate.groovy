package net.avantic.scaffolding.java.spring.mvc.template.command

class CreateCommandTemplate {

	def clazz

	def config

	def fieldAnalyzer

	def originalClassNotSyntheticFields() {
		def output = new StringBuffer()
		clazz.declaredFields.findAll{fieldAnalyzer.isNotSynthetic(it)}.each { field ->
			output << "private ${field.type.simpleName} ${field.name};\n\n\t"
		}
		output.toString()
	}

	def build() {
"""
package ${config.basePackage}.web.model;

import java.io.Serializable;

public class Create${config.className}Request implements Serializable {

	private static final long serialVersionUID = 1L;
	
	${originalClassNotSyntheticFields()}

	// FIXME don't forget generate getters, setters and toString methods

}
"""
	}

}
