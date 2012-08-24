package net.avantic.scaffolding.java.spring.mvc.template.view

import java.beans.Introspector

class CreateViewTemplate {
	
	def clazz

	def config

	def fieldAnalyzer

	def buildFields() {
		def output = "";
		clazz.declaredFields.findAll{fieldAnalyzer.isNotSynthetic(it)}.each { field ->
			if (field.type.name == "org.joda.time.DateTime") {
				output += """
					<div class=\"control-group\">
						<label><spring:message code=\"${config.beanName}.${field.name}\"/></label>
						<div class=\"controls\">
							<form:input id=\"${field.name}\" path=\"${field.name}\" maxlength=\"10\" cssClass=\"input-medium\" placeholder=\"dd/mm/aaaa\"/>
							<span class=\"help-inline\"><spring:message code=\"formato.fecha\"/></span>
							<form:errors htmlEscape=\"false\" path=\"${field.name}\" cssClass=\"error\" />
						</div>
					</div>
				"""
			} else if (field.type.name == "java.lang.String") {
				output += """
					<div class=\"control-group\">
						<label><spring:message code=\"${config.beanName}.${field.name}\"/></label>
						<div class=\"controls\">
							<form:input id=\"${field.name}\" path=\"${field.name}\" maxlength="100" cssClass=\"input-xxlarge\"/>
							<form:errors htmlEscape=\"false\" path=\"${field.name}\" cssClass=\"error\" />
						</div>
					</div>
				"""
			} else if (field.type.name == "java.math.BigDecimal") {
				output += """
					<div class=\"control-group\">
						<label><spring:message code=\"${config.beanName}.${field.name}\"/></label>
						<div class=\"controls\">
							<div class=\"input-append\">
								<form:input id=\"${field.name}\" path=\"${field.name}\" maxlength=\"20\" cssClass=\"input-medium\"/>
								<span class=\"add-on\">&euro;</span>
								<form:errors htmlEscape=\"false\" path=\"${field.name}\" cssClass=\"error\" />
							</div>
						</div>
					</div>
				"""
			} else {
				output += """
					<div class=\"control-group\">
						<label><spring:message code=\"${config.beanName}.${field.name}\"/></label>
						<div class=\"controls\">
							<!-- FIXME
							<form:select id=\"${field.name}\" cssClass=\"input-xxlarge\" path=\"FIXME\">
								<form:option value=\"\" label=\"Seleccione...\"/>
		            			<form:options items=\"\${listConceptos}\" itemValue=\"id\"  itemLabel=\"FIXME\"/>
							</form:select>
							<form:errors htmlEscape=\"false\" path=\"FIXME\" cssClass=\"error\" />
							-->
						</div>
					</div>
				"""
			}
		}
		output
	}

	def build() {
"""
<%@ page contentType=\"text/html; charset=UTF-8\" %>

<%@ include file=\"/WEB-INF/views/includes/includes.jsp\" %>

<tiles:insertTemplate template=\"/WEB-INF/views/layouts/FIXME.jsp\">

	<tiles:putAttribute name=\"FIXME\" cascade=\"true\">
	
		<div class=\"well\">
			<script type=\"text/javascript\" charset=\"utf-8\">
				\$(document).ready(function() {
					deseleccionarElementosMenu();
					deseleccionarElementosNavList();
					/* FIXME
					\$(\"#create${config.className}Link\").addClass(\"active\");
					
					\$('#cancelarButton').click(function(event) {
						event.preventDefault();
						window.location.href= \"\${pageContext.request.contextPath}/FIXME\";
					});
					*/
				});
				
			</script>
		
			<fieldset>
				<legend><spring:message code=\"create${config.className}.title\"/></legend>
				<form:form cssClass=\"form-horizontal\" commandName=\"create${config.className}Request\">
					<form:errors htmlEscape=\"false\" path=\"*\" cssClass=\"alert alert-error\" element=\"div\"/>
					
					<!-- FIXME hidden fields
					<form:hidden path=\"FIXME\"/>
					-->

					${buildFields()}
					
					
					<div class=\"form-actions\">
							<ava:commandButton 	name=\"crear\" 
												value=\"create${config.className}.button.crear\"
												transition=\"true\"
												cssClass=\"btn btn-primary\"
												transitionImage=\"\${pageContext.request.contextPath}/resources/images/loading.gif\"/>
							<ava:commandButton 	id=\"cancelarButton\"
												name=\"cancelar\"
												value=\"button.cancelar\"
												title=\"button.cancelar.title\"
												transition=\"true\"
												transitionImage=\"\${pageContext.request.contextPath}/resources/images/loading.gif\"
												cssClass=\"btn\"/>
					</div>					
				</form:form> <!-- /form-vertical -->
			</fieldset>
		</div><!--/well-->
	</tiles:putAttribute>
</tiles:insertTemplate>
"""
	}

}