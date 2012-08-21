package net.avantic.scaffolding.java.spring.mvc.template

import java.beans.Introspector;

class ControllerTemplate {

	def clazz

	def projectConfiguration

	def build() {
		def beanName = Introspector.decapitalize("${clazz.simpleName}")
		def facadeReference = "${clazz.simpleName}Facade"
		def facadeAttribute = Introspector.decapitalize("${clazz.simpleName}Facade")
"""
package ${projectConfiguration.basePackage}.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ${projectConfiguration.basePackage}.facade.${facadeReference};
import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

@Controller
public class ${clazz.simpleName}Controller {

	@Autowired
	private ${facadeReference} ${facadeAttribute};

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<${clazz.simpleName}> ${beanName}s = ${facadeAttribute}.list();
		model.put(\"${beanName}s\", ${beanName}s);

		// FIXME añadir al modelo los posibles datos que pueda requerir el layout

		return new ModelAndView(\"protected/${beanName}/list\", model);
	}	

	public void set${facadeReference}(${facadeReference} $facadeAttribute) {
		this.${facadeAttribute} = ${facadeAttribute};
	}

}
"""
	}

}