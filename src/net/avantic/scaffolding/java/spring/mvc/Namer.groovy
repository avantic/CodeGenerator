package net.avantic.scaffolding.java.spring.mvc

class Namer {

	def packageName

	def sourceFolder(componentURL) {
		def packageURL = packageName.replace(".", "/")
		"src/${packageURL}/${componentURL}"
	}

	static def getInstance(packageName) {
		def namer = Namer.newInstance()
		namer.packageName = packageName

		namer
	}

}