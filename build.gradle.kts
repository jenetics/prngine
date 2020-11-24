/*
 * PRNGine - Java PRNG Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */


/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version !__version__!
 */
plugins {
	base
	id("me.champeau.gradle.jmh") version "0.5.0" apply false
}

rootProject.version = JPX.VERSION

tasks.named<Wrapper>("wrapper") {
	version = "6.7.1"
	distributionType = Wrapper.DistributionType.ALL
}

/**
 * Project configuration *before* the projects has been evaluated.
 */
allprojects {
	group =  JPX.GROUP
	version = JPX.VERSION

	repositories {
		flatDir {
			dirs("${rootDir}/buildSrc/lib")
		}
		mavenLocal()
		mavenCentral()
		jcenter()
	}

	configurations.all {
		resolutionStrategy.failOnVersionConflict()
		resolutionStrategy.force(*Libs.All)
	}
}

/**
 * Project configuration *after* the projects has been evaluated.
 */
gradle.projectsEvaluated {
	subprojects {
		val project = this

		tasks.withType<JavaCompile> {
			options.compilerArgs.add("-Xlint:" + xlint())
		}

		plugins.withType<JavaPlugin> {
			configure<JavaPluginConvention> {
				sourceCompatibility = JavaVersion.VERSION_8
				targetCompatibility = JavaVersion.VERSION_8
			}

			configure<JavaPluginExtension> {
				modularity.inferModulePath.set(true)
			}

			setupJava(project)
			setupTestReporting(project)
			setupJavadoc(project)
		}

		if (plugins.hasPlugin("maven-publish")) {
			setupPublishing(project)
		}
	}

}

/**
 * Some common Java setup.
 */
fun setupJava(project: Project) {
	val attr = mutableMapOf(
			"Implementation-Title" to project.name,
			"Implementation-Version" to JPX.VERSION,
			"Implementation-URL" to JPX.URL,
			"Implementation-Vendor" to JPX.NAME,
			"ProjectName" to JPX.NAME,
			"Version" to JPX.VERSION,
			"Maintainer" to JPX.AUTHOR,
			"Project" to project.name,
			"Project-Version" to project.version,

			"Created-With" to "Gradle ${gradle.gradleVersion}",
			"Built-By" to Env.BUILD_BY,
			"Build-Date" to Env.BUILD_DATE,
			"Build-JDK" to Env.BUILD_JDK,
			"Build-OS-Name" to Env.BUILD_OS_NAME,
			"Build-OS-Arch" to Env.BUILD_OS_ARCH,
			"Build-OS-Version" to Env.BUILD_OS_VERSION
	)
	if (project.extra.has("moduleName")) {
		attr["Automatic-Module-Name"] = project.extra["moduleName"].toString()
	}

	project.tasks.withType<Jar> {
		manifest {
			attributes(attr)
		}
	}
}

/**
 * Setup of the Java test-environment and reporting.
 */
fun setupTestReporting(project: Project) {
	project.apply(plugin = "jacoco")

	project.configure<JacocoPluginExtension> {
		toolVersion = "0.8.6"
	}

	project.tasks {
		named<JacocoReport>("jacocoTestReport") {
			dependsOn("test")

			reports {
				html.isEnabled = true
				xml.isEnabled = true
				csv.isEnabled = true
			}
		}

		named<Test>("test") {
			useTestNG()
			finalizedBy("jacocoTestReport")
		}
	}
}

/**
 * Setup of the projects Javadoc.
 */
fun setupJavadoc(project: Project) {
	project.tasks.withType<Javadoc> {
		val doclet = options as StandardJavadocDocletOptions

		exclude("**/internal/**")

		doclet.memberLevel = JavadocMemberLevel.PROTECTED
		doclet.version(true)
		doclet.docEncoding = "UTF-8"
		doclet.charSet = "UTF-8"
		doclet.linkSource(true)
		doclet.linksOffline(
				"https://docs.oracle.com/en/java/javase/11/docs/api",
				"${project.rootDir}/buildSrc/resources/javadoc/java.se"
		)
		doclet.windowTitle = "JPX ${project.version}"
		doclet.docTitle = "<h1>JPX ${project.version}</h1>"
		doclet.bottom = "&copy; ${Env.COPYRIGHT_YEAR} Franz Wilhelmst&ouml;tter  &nbsp;<i>(${Env.BUILD_DATE})</i>"
		doclet.stylesheetFile = project.file("${project.rootDir}/buildSrc/resources/javadoc/stylesheet.css")

		doclet.tags = listOf(
				"apiNote:a:API Note:",
				"implSpec:a:Implementation Requirements:",
				"implNote:a:Implementation Note:"
		)

		doLast {
			project.copy {
				from("src/main/java") {
					include("io/**/doc-files/*.*")
				}
				includeEmptyDirs = false
				into(destinationDir!!)
			}
		}
	}

	val javadoc = project.tasks.findByName("javadoc") as Javadoc?
	if (javadoc != null) {
		project.tasks.register<io.jenetics.gradle.ColorizerTask>("colorizer") {
			directory = javadoc.destinationDir!!
		}

		project.tasks.register("java2html") {
			doLast {
				project.javaexec {
					main = "de.java2html.Java2Html"
					args = listOf(
							"-srcdir", "src/main/java",
							"-targetdir", "${javadoc.destinationDir}/src-html/${project.extra["moduleName"]}"
					)
					classpath = files("${project.rootDir}/buildSrc/lib/java2html.jar")
				}
			}
		}

		javadoc.doLast {
			val colorizer = project.tasks.findByName("colorizer")
			colorizer?.actions?.forEach {
				it.execute(colorizer)
			}

			val java2html = project.tasks.findByName("java2html")
			java2html?.actions?.forEach {
				it.execute(java2html)
			}
		}
	}
}

