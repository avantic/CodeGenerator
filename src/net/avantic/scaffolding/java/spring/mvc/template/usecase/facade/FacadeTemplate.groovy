package net.avantic.scaffolding.java.spring.mvc.template.usecase.facade

class FacadeTemplate {

	def config

	def build() {
"""
package ${config.basePackage}.facade.usecase;

public interface ${config.useCaseName}Facade extends CommandFacade<${config.useCaseName}Request, SimpleFacadeResult> {

	/*
	 * This is a generated file, please check for the next items:
	 * FIX_ROLES
	 */
	
	@Secured({\"FIX_ROLES\"})
	@Override
	ValidatorResult getExecutionValidatorResult(Long id);
	
	@Secured({\"FIX_ROLES\"})
	@Override
	${config.useCaseName}Request newCommand(Long id);
	
	@Secured({\"FIX_ROLES\"})
	@Override
	SimpleFacadeResult txValidateAndExecute(${config.useCaseName}Request command) throws FacadeException;

	@Secured({\"FIX_ROLES\"})
	${config.useCaseName} get${config.useCaseName}(Long id${config.useCaseName});
	
}
"""
	}

	static def getInstance(config) {
		def template = FacadeTemplate.newInstance()
		template.config = config

		template
	}

}