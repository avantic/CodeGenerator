package net.avantic.scaffolding.java.spring.mvc.template.controller

class CreateControllerTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.web.controller.${config.beanName};

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ${config.basePackage}.facade.base.CommandFacade;
import ${config.basePackage}.facade.base.ContextModelFacade;
import ${config.basePackage}.facade.impl.SimpleFacadeResult;
import ${config.basePackage}.facade.${config.beanName}.Create${config.className}Facade;
import ${config.basePackage}.web.controller.base.impl.AbstractCommandController;
import ${config.basePackage}.web.model.Create${config.className}Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class Create${config.className}Controller extends AbstractCommandController<Create${config.className}Request, SimpleFacadeResult> {
	
	/*
	 * This is a generated file, please check for the next items:
	 * FIX_VIEW_NAME
	 * FIX_ID_TARGET
	 * FIX_PARAMS
	 * FIX_SUCCESS_VIEW
	 * FIX_MODEL_OBJECT
	 * FIX_MODEL_CONTENT
	 * FIX_CONTEXT_MODEL_FACADE
	 */

	protected static final String FIX_VIEW_NAME = \"/${config.beanName}/create${config.className}\";
	
	@Autowired
	private Create${config.className}Facade create${config.className}Facade;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ContextModelFacade FIX_CONTEXT_MODEL_FACADE;
	
	@RequestMapping(value = \"/create${config.className}\", method = RequestMethod.GET)
	public ModelAndView setupForm(@RequestParam Long FIX_ID_TARGET, HttpServletRequest request) {
		return internalSetupForm(FIX_ID_TARGET, request);
	}

	@RequestMapping(value = \"/create${config.className}\", method = RequestMethod.POST)
	public ModelAndView processSubmit(@Valid @ModelAttribute Create${config.className}Request command,	BindingResult bindingResult, HttpServletRequest request) {
		return internalProcessSubmit(command, bindingResult, request);
	}

	@Override
	protected String getSuccessMessage(SimpleFacadeResult result, HttpServletRequest request) {
		Object[] param = FIX_PARAMS;
		return messageSource.getMessage(\"create${config.className}.success.message\", param, RequestContextUtils.getLocale(request));
	}

	@Override
	protected ContextModelFacade getContextModelFacade() {
		return FIX_CONTEXT_MODEL_FACADE;
	}

	@Override
	protected CommandFacade<Create${config.className}Request, SimpleFacadeResult> getCommandFacade() {
		return create${config.className}Facade;
	}

	@Override
	protected String getFormViewName() {
		return FIX_VIEW_NAME;
	}

	@Override
	protected String getSuccessViewName(Create${config.className}Request command, SimpleFacadeResult facadeResult) {
		return FIX_SUCCESS_VIEW;
	}

	@Override
	protected String getCommandName() {
		return \"create${config.className}Request\";
	}

	@Override
	protected Map<String, Object> getReferenceData(Long id, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put(\"${config.beanName}\", FIX_MODEL_OBJECT);
		FIX_MODEL_CONTENT
		
		return model;
	}

	@Override
	protected Long getIdDelTarget(Create${config.className}Request command) {
		return FIX_ID_TARGET;
	}

}
"""
	}

}