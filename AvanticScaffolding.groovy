import java.beans.Introspector;

class DAOTemplate {

	def clazz

	def projectConfiguration

	def build() {
"""
package ${projectConfiguration.basePackage}.dao;

import java.util.List;

import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public interface ${clazz.simpleName}DAO {

	public void saveOrUpdate(${clazz.simpleName} entity);

	public ${clazz.simpleName} get(Long identifier);

	public void delete(${clazz.simpleName} entity);

	public List<${clazz.simpleName}> list();

}
"""
	}

}

class DAOHibernateTemplate {

	def clazz

	def projectConfiguration

	def build() {
"""
package ${projectConfiguration.basePackage}.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import ${projectConfiguration.basePackage}.dao.${clazz.simpleName}DAO;
import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public class ${clazz.simpleName}DAOHibernate extends HibernateDaoSupport implements ${clazz.simpleName}DAO {

	@Override
	public void saveOrUpdate(${clazz.simpleName} entity) {
		Assert.notNull(entity, \"No se puede guardar una entidad nula!!!\");
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public ${clazz.simpleName} get(Long identifier) {
		Assert.notNull(identifier, \"No se puede obtener una entidad a partir de un identificador nulo!!!\");
		return (${clazz.simpleName}) getHibernateTemplate().get(${clazz.simpleName}.class, identifier);
	}

	@Override
	public void delete(${clazz.simpleName} entity) {
		Assert.notNull(entity, \"No se puede borrar una entidad nula!!!\");
		getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings(\"unchecked\")
	@Override
	public List<${clazz.simpleName}> list() {
		return getHibernateTemplate().loadAll(${clazz.simpleName}.class);
	}

}
"""
	}

}

class FacadeTemplate {

	def clazz

	def projectConfiguration

	def build() {
"""
package ${projectConfiguration.basePackage}.facade;

import java.util.List;

import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public interface ${clazz.simpleName}Facade {

	//FIXME @Secured({})
	public List<${clazz.simpleName}> list();

}
"""
	}

}

class FacadeImplementationTemplate {

	def clazz

	def projectConfiguration

	def build() {
		def daoReference = "${clazz.simpleName}DAO"
		def daoAttribute = Introspector.decapitalize("${clazz.simpleName}DAO")
		def facadeReference = "${clazz.simpleName}Facade"

"""
package ${projectConfiguration.basePackage}.facade.impl;

import java.util.List;

import ${projectConfiguration.basePackage}.dao.${daoReference};
import ${projectConfiguration.basePackage}.facade.${facadeReference};
import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

public class ${clazz.simpleName}FacadeImpl implements ${facadeReference} {

	private ${daoReference} ${daoAttribute};

	public List<${clazz.simpleName}> list() {
		return ${daoAttribute}.list();
	}

	public void set${daoReference}(${daoReference} ${daoAttribute}) {
		this.${daoAttribute} = ${daoAttribute};
	}

}
"""
	}

}

class ControllerTemplate {

	def clazz

	def projectConfiguration

	def build() {
		def beanName = Introspector.decapitalize("${clazz.simpleName}")
		def facadeReference = "${clazz.simpleName}Facade"
		def facadeAttribute = Introspector.decapitalize("${clazz.simpleName}Facade")
"""
package ${projectConfiguration.basePackage}.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ${projectConfiguration.basePackage}.facade.${facadeReference};
import ${projectConfiguration.basePackage}.model.${clazz.simpleName};

@Controller
public class ${clazz.simpleName}Controller {

	@Autowired
	private ${facadeReference} ${facadeAttribute};

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<${clazz.simpleName}> ${beanName}s = ${facadeAttribute}.list();
		model.put(\"${beanName}s\", ${beanName}s);

		return new ModelAndView(\"protected/${beanName}/list\", model);
	}	

	public void set${facadeReference}(${facadeReference} $facadeAttribute) {
		this.${facadeAttribute} = ${facadeAttribute};
	}

}
"""
	}

}

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
"""
			<td class=\"date\">
				<joda:format value=\"\${convocatoria.fechaPublicacionBOC}\" pattern=\"dd/MM/yyyy\"/>
			</td>
			<td class=\"date\">
				<joda:format value=\"\${convocatoria.fechaInicio}\" pattern=\"dd/MM/yyyy\"/>
			</td>
"""		
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
		<c:forEach items=\"\${${beanName}s}\" var=\"convocatoria\" varStatus=\"status\">
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

class ShowViewTemplate {
	
	def clazz

	def projectConfiguration

	def build() {
"""
Show view
"""
	}

}

def inputFile = new File(this.args[0])

def classLoader = new GroovyClassLoader()

def clazz = classLoader.parseClass(inputFile)

/**
 * Modificar los datos de esta clase para construir código con configuraciones
 * diferentes a la prestablecida.
 */
class ProjectConfiguration {
	def basePackage = "net.avantic.project"
}

def projectConfiguration = new ProjectConfiguration()

def rootFolder = new File("root")
rootFolder.mkdirs()

def buildFile(baseFolderName, fileName, writeCode) {
	def baseFolder = new File(baseFolderName)
	baseFolder.mkdirs()
	println "Generating ${baseFolderName}/${fileName}.java ..."
	def file = new File("${baseFolderName}/${fileName}.java")
	writeCode.call(file)
}

def buildViewFile(baseFolderName, fileName, writeCode, clazz) {
	def beanName = Introspector.decapitalize("${clazz.simpleName}")

	def baseFolder = new File("${baseFolderName}/${beanName}")
	baseFolder.mkdirs()
	println "Generating ${baseFolderName}/${beanName}/${fileName}.jsp ..."
	def file = new File("${baseFolderName}/${beanName}/${fileName}.jsp")
	writeCode.call(file)
}

def writeDaoCode = {file -> 
	def template = new DAOTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
	file.write template.build()
}

def writeDaoHibernateCode = {file -> 
	def template = new DAOHibernateTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
	file.write template.build()
}

def writeFacadeCode = {file -> 
	def template = new FacadeTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
	file.write template.build()
}

def writeFacadeImplementationCode = {file -> 
	def template = new FacadeImplementationTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
	file.write template.build()
}

def writeControllerCode = {file -> 
	def template = new ControllerTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
	file.write template.build()
}

def writeListViewCode = {file -> 
	def template = new ListViewTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
	file.write template.build()
}

def writeShowViewCode = {file -> 
	def template = new ShowViewTemplate(clazz : clazz, projectConfiguration : projectConfiguration)
	file.write template.build()
}

buildFile("root/dao", "${clazz.simpleName}DAO", writeDaoCode)
buildFile("root/dao/hibernate", "${clazz.simpleName}DAOHibernate", writeDaoHibernateCode)
buildFile("root/facade", "${clazz.simpleName}Facade", writeFacadeCode)
buildFile("root/facade/impl", "${clazz.simpleName}FacadeImpl", writeFacadeImplementationCode)
buildFile("root/controller", "${clazz.simpleName}Controller", writeControllerCode)
buildViewFile("root/view/protected", "list", writeListViewCode, clazz)
buildViewFile("root/view/protected", "show", writeShowViewCode, clazz)

println "DONE"