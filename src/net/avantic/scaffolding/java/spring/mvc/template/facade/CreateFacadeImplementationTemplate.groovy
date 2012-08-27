package net.avantic.scaffolding.java.spring.mvc.template.facade

class CreateFacadeImplementationTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ${config.basePackage}.commandCopier.CommandCopier;
import ${config.basePackage}.dao.${config.className}DAO;
import ${config.basePackage}.facade.FacadeException;
import ${config.basePackage}.facade.base.impl.CommandFacadeWithSyntacticValidation;
import ${config.basePackage}.facade.impl.SimpleFacadeResult;
import ${config.basePackage}.facade.${config.beanName}.Create${config.className}Facade;
import ${config.basePackage}.model.${config.className};
import ${config.basePackage}.model.enums.EntityName;
import ${config.basePackage}.validators.AlwaysTrueDomainValidator;
import ${config.basePackage}.validators.DomainValidator;
import ${config.basePackage}.validators.ValidatorResult;
import ${config.basePackage}.web.model.Create${config.className}Request;
import org.springframework.stereotype.Component;

@Component(\"create${config.className}Facade\")
public class Create${config.className}FacadeImpl extends CommandFacadeWithSyntacticValidation<Create${config.className}Request, SimpleFacadeResult> 
		implements Create${config.className}Facade {
	
	@Autowired protected ${config.className}DAO ${config.beanName}DAO;
	
	@Autowired protected DomainValidator<${config.className}, Object> create${config.className}SemanticValidator;

	@Autowired protected CommandCopier<Create${config.className}Request, Object, ${config.className}> create${config.className}CommandCopier;

	@Autowired protected DomainValidator<Object, Object> create${config.className}ExecutionValidator;

	@Override
	public SimpleFacadeResult txValidateAndExecute(Create${config.className}Request command) throws FacadeException {
		return super.txValidateAndExecute(command);
	}
	
	@Override
	public ${config.className} get${config.className}(Long id${config.className}) {
		return ${config.beanName}DAO.get(id${config.className});
	}

	@Override
	public ValidatorResult getExecutionValidatorResult(Long id) {
		return create${config.className}ExecutionValidator.getValidatorResult(target, context);
	}

	@Override
	public Create${config.className}Request newCommand(Long id) {
		return create${config.className}CommandCopier.getCommandFromObject(FIXME);
	}

	@Override
	protected ValidatorResult internalExecutionValidation(Create${config.className}Request command) {
		return getExecutionValidatorResult(FIXME);
	}

	@Override
	protected ValidatorResult internalSemanticValidation(Create${config.className}Request command) {
		${config.className} ${config.beanName} = new ${config.className}();
		create${config.className}CommandCopier.copyCommandToObject(command, ${config.beanName});
		return create${config.className}SemanticValidator.getValidatorResult(${config.beanName}, null);
	}

	@Override
	protected SimpleFacadeResult internalExecute(Create${config.className}Request command) throws FacadeException {
		// FIX_VALIDATIONS

		/*
		${config.className} ${config.beanName} = new ${config.className}();
		create${config.className}CommandCopier.copyCommandToObject(command, ${config.beanName});
		
		${config.beanName}DAO.saveOrUpdate(${config.beanName});
		*/
		
		// FIX_RETURN return SimpleFacadeResult.instanceSuccessResult(${config.beanName}.getId(), EntityName.FIX_ENTITY.getName());

		throw new RuntimeException(\"This method is not yet implemented\");
	}
	
}
"""
	}

}