package net.avantic.scaffolding.java.spring.mvc.builder

import java.beans.Introspector

class AbstractFileBuilder {

	def createFile(baseFolderName, fileName, writeCode) {
		def baseFolder = new File(baseFolderName)
		baseFolder.mkdirs()
		println "Generating ${baseFolderName}/${fileName} ..."
		def file = new File("${baseFolderName}/${fileName}")
		writeCode.call(file)
	}

}