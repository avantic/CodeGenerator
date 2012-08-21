package net.avantic.scaffolding.java.spring.mvc.template

import java.beans.Introspector

class ListViewTemplate {

	def clazz

	def projectConfiguration

	def buildTableHeaders() {
		def output = ""

		def beanName = Introspector.decapitalize("${clazz.simpleName}")
		clazz.declaredFields.findAll{!it.synthetic}.each { field ->
			output += """
				<th title=\"<spring:message code=\"${beanName}.list.${field.name}.title\"/>\">
					<a href=\"#\"><spring:message code=\"${beanName}.list.${field.name}\"/></a>
				</th>
			"""
		}

		output
	}

	def buildData() {
		def output = ""

		def beanName = Introspector.decapitalize("${clazz.simpleName}")
		clazz.declaredFields.findAll{!it.synthetic}.each { field ->
			if (field.type.name == "org.joda.time.DateTime") {
				output += """
					<td class=\"date\">
						<joda:format value=\"\${${beanName}.${field.name}}\" pattern=\"dd/MM/yyyy\"/>
					</td>
				"""	
			} else {
				output += """
					<td>
						\${${beanName}.${field.name}}
					</td>
				"""			
			}
		}

		output
	}

	def build() {
		def beanName = Introspector.decapitalize("${clazz.simpleName}")

"""
<div class=\"tabla\">
<table id=\"${beanName}-list\">
	<thead>
		<tr>
			${buildTableHeaders()}			
		</tr>
	</thead>							
	<tbody>
		<c:forEach items=\"\${${beanName}s}\" var=\"${beanName}\" varStatus=\"status\">
		<tr class=\"\${(i % 2) == 0 ? 'odd' : 'even'}\">
			${buildData()}
		</tr>
		</c:forEach>	
	</tbody>
</table>
</div>
"""
	}

}