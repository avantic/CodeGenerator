package net.avantic.scaffolding.java.spring.mvc.template.controller

import java.beans.Introspector

class ListControllerTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.web.controller.${config.beanName};

import java.util.HashMap;
import java.util.Map;

import ${config.basePackage}.facade.base.ContextModelFacade;
import ${config.basePackage}.facade.${config.beanName}.List${config.className}sFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class List${config.className}sController {

	/*
	 * This is a generated file, please check for the next items:
	 * FIX_ID_DOMAIN
	 * FIX_MODEL_CONTENT
	 * FIX_CONTEXT_MODEL_FACADE
	 * FIX_VIEW_NAME
	 */ 

	protected static final String FIX_VIEW_NAME = \"/${config.beanName}/list${config.className}s\";

	@Autowired
	protected List${config.className}sFacade list${config.className}sFacade;

	@Autowired
	private ContextModelFacade FIX_CONTEXT_MODEL_FACADE;
	
	@RequestMapping(value = \"/list${config.className}s\", method=RequestMethod.GET)
	public ModelAndView list${config.className}s() {
		Map<String, Object> model = FIX_CONTEXT_MODEL_FACADE.getContextByIdDomain(FIX_ID_DOMAIN);
		
		model.put(\"${config.beanName}s\", list${config.className}sFacade.list());

		FIX_MODEL_CONTENT
		
		return new ModelAndView(FIX_VIEW_NAME, model);
	}

}
"""
	}

}