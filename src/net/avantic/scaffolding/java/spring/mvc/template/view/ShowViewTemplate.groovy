package net.avantic.scaffolding.java.spring.mvc.template.view

import java.beans.Introspector

class ShowViewTemplate {
	
	def clazz

	def config

	def fieldAnalyzer

	def buildFields() {
		def output = ""
		clazz.declaredFields.findAll{fieldAnalyzer.isNotSynthetic(it)}.each { field ->
			output += """
					<div class=\"control-group\">
						<label><spring:message code=\"${config.beanName}.${field.name}\"/></label>
						<div class=\"controls\">
							<span class=\"input-xlarge field-output\">\${${config.beanName}.${field.name}}</span>
						</div>
					</div>
			"""
		}
		output
	}

	def build() {
"""
<%@ page contentType=\"text/html; charset=UTF-8\" %>

<%@ include file=\"/WEB-INF/views/includes/includes.jsp\" %>

<tiles:insertTemplate template=\"/WEB-INF/views/layouts/FIXME.jsp\">

	<tiles:putAttribute name=\"ficha-content\" cascade=\"true\">
		<script type=\"text/javascript\" charset=\"utf-8\">
			\$(document).ready(function() {
				deseleccionarElementosNavList();
				deseleccionarElementosMenu();
				\$(\"FIXME\").addClass(\"active\");
			});
			
		</script>
	
		<div class=\"well\">
			<fieldset>
				<legend><spring:message code=\"${config.beanName}.detalle.title\"/></legend>
				<div class=\"form-horizontal\">
					${buildFields()}
				</div> <!-- /form-vertical -->
			</fieldset>
		</div><!--/well-->
	</tiles:putAttribute>
</tiles:insertTemplate>
"""
	}

}