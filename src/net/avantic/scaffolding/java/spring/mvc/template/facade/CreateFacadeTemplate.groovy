package net.avantic.scaffolding.java.spring.mvc.template.facade

class CreateFacadeTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName};

import ${config.basePackage}.facade.FacadeException;
import ${config.basePackage}.facade.base.CommandFacade;
import ${config.basePackage}.facade.impl.SimpleFacadeResult;
import ${config.basePackage}.model.${config.className};
import ${config.basePackage}.validators.ValidatorResult;
import ${config.basePackage}.web.model.Create${config.className}Request;
import org.springframework.security.access.annotation.Secured;

public interface Create${config.className}Facade extends CommandFacade<Create${config.className}Request, SimpleFacadeResult> {

	/*
	 * This is a generated file, please check for the next items:
	 * FIX_ROLES
	 */
	
	@Secured({\"FIX_ROLES\"})
	@Override
	ValidatorResult getExecutionValidatorResult(Long id);
	
	@Secured({\"FIX_ROLES\"})
	@Override
	Create${config.className}Request newCommand(Long id);
	
	@Secured({\"FIX_ROLES\"})
	@Override
	SimpleFacadeResult txValidateAndExecute(Create${config.className}Request command) throws FacadeException;

	@Secured({\"FIX_ROLES\"})
	${config.className} get${config.className}(Long id${config.className});
	
}
"""
	}

}