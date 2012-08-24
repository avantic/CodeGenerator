package net.avantic.scaffolding.java.spring.mvc.template.facade

class CreateFacadeImplementationTemplate {

	def clazz

	def config

	def build() {
"""
package ${config.basePackage}.facade.${config.beanName}.impl;

import java.util.List;

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

public class Create${config.className}FacadeImpl extends CommandFacadeWithSyntacticValidation<Create${config.className}Request, SimpleFacadeResult> 
		implements Create${config.className}Facade {
	
	protected ${config.className}DAO ${config.beanName}DAO;
	
	protected DomainValidator<${config.className}, Object> semanticValidator;

	protected CommandCopier<Create${config.className}Request, Object, ${config.className}> commandCopier;

	protected DomainValidator<Object, Object> executionValidator;

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
		return executionValidator.getValidatorResult(target, context);
	}

	@Override
	public Create${config.className}Request newCommand(Long id) {
		return commandCopier.getCommandFromObject(FIXME);
	}

	@Override
	protected ValidatorResult internalExecutionValidation(Create${config.className}Request command) {
		return getExecutionValidatorResult(FIXME);
	}

	@Override
	protected ValidatorResult internalSemanticValidation(Create${config.className}Request command) {
		${config.className} ${config.beanName} = new ${config.className}();
		commandCopier.copyCommandToObject(command, ${config.beanName});
		return semanticValidator.getValidatorResult(${config.beanName}, null);
	}

	@Override
	protected SimpleFacadeResult internalExecute(Create${config.className}Request command) throws FacadeException {
		// FIX_VALIDATIONS

		/*
		${config.className} ${config.beanName} = new ${config.className}();
		commandCopier.copyCommandToObject(command, ${config.beanName});
		
		${config.beanName}DAO.saveOrUpdate(${config.beanName});
		*/
		
		// FIX_RETURN return SimpleFacadeResult.instanceSuccessResult(${config.beanName}.getId(), EntityName.FIX_ENTITY.getName());

		throw new RuntimeException(\"This method is not yet implemented\");
	}
	
	public void set${config.className}DAO(${config.className}DAO ${config.beanName}DAO) {
		this.${config.beanName}DAO = ${config.beanName}DAO;
	}

	public void setSemanticValidator(DomainValidator<${config.className}, Object> semanticValidator) {
		this.semanticValidator = semanticValidator;
	}

	public void setCommandCopier(CommandCopier<Create${config.className}Request, Object, ${config.className}> commandCopier) {
		this.commandCopier = commandCopier;
	}

	public void setExecutionValidator(DomainValidator<Object, Object> executionValidator) {
		this.executionValidator = executionValidator;
	}

}
"""
	}

}