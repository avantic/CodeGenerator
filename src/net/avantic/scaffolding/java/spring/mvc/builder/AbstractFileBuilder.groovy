package net.avantic.scaffolding.java.spring.mvc.builder

import java.beans.Introspector

class AbstractFileBuilder {

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

	def buildPropertiesFile(baseFolderName, fileName, writeCode, clazz) {
		def beanName = Introspector.decapitalize("${clazz.simpleName}")

		def baseFolder = new File("${baseFolderName}")
		baseFolder.mkdirs()
		println "Generating ${baseFolderName}/${beanName}.properties ..."
		def file = new File("${baseFolderName}/${beanName}.properties")
		writeCode.call(file)
	}

}