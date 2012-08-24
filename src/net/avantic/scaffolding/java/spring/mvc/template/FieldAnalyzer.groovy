package net.avantic.scaffolding.java.spring.mvc.template

class FieldAnalyzer {

	def isNotSynthetic(field) {
		!field.synthetic && field.name != "serialVersionUID"
	}

}
