package net.avantic.scaffolding.java.spring.mvc.template.controller

import java.beans.Introspector

class ShowControllerTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.web.controller.${config.beanName};

import java.util.Map;

import ${config.basePackage}.facade.base.ContextModelFacade;
import ${config.basePackage}.facade.${config.beanName}.Show${config.className}Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Show${config.className}Controller {

	protected static final String VIEW_NAME = \"/${config.beanName}/show${config.className}\";

	@Autowired
	protected ContextModelFacade ${config.beanName}ContextModelFacade;
	
	@Autowired
	protected Show${config.className}Facade show${config.className}Facade;
	
	@RequestMapping(method = RequestMethod.GET, value = \"/show${config.className}\")
	public ModelAndView show(@RequestParam Long id${config.className}) {
		
		Map<String, Object> model = ${config.beanName}ContextModelFacade.getContextByIdDomain(id${config.className});
		model.put(\"${config.beanName}\", show${config.className}Facade.get(id${config.className}));
		
		return new ModelAndView(VIEW_NAME, model);
	}

}
"""
	}

}