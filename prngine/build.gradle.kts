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
import org.apache.tools.ant.filters.ReplaceTokens

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 1.0
 */

plugins {
	id "me.champeau.gradle.jmh" version "0.4.7"
}

description = 'PRNGine - Java PRNG Library'

apply plugin: 'java'
apply plugin: 'maven'
apply plugin: 'signing'
apply plugin: 'idea'

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	testCompile 'org.testng:testng:6.10'

	//jmh 'org.openjdk.jmh:jmh-core:1.17.5'
	//jmh 'org.openjdk.jmh:jmh-generator-annprocess:1.17.5'
	//jmh files('build/classes/main')
}

javadoc {
	project.configure(options) {
		memberLevel = 'PROTECTED'
		version = true
		author = true
		docEncoding = 'UTF-8'
		charSet = 'UTF-8'
		linkSource = true
		links = [
			'https://docs.oracle.com/javase/8/docs/api'
		]
		windowTitle = "PRNGine ${project.version}"
		docTitle = "<h1>PRNGine ${project.version}</h1>"
		bottom = "&copy; ${copyrightYear} Franz Wilhelmst&ouml;tter  &nbsp;<i>(${dateformat.format(now)})</i>"

		exclude '**/internal/**'
	}

	// Copy the doc-files.
	doLast {
		project.copy {
			from('src/main/java') {
				include 'io/**/doc-files/*.*'
			}
			includeEmptyDirs = false
			into destinationDir.path
		}
	}
}

test {
	outputs.upToDateWhen { false }
	testLogging.showStandardStreams = true

	useTestNG {
		preserveOrder true
		parallel = 'tests' // 'methods'
		threadCount = Math.max(Runtime.runtime.availableProcessors() + 1, 4)
	}
}

jar {
	manifest {
		attributes(
			'Implementation-Title': 'PRNGine - Java PRNG Library',
			'Implementation-Version': "${project.name}-${project.version}",
			'Implementation-URL': 'https://jenetics.github.io/prngine',
			'Implementation-Vendor': 'jenetics',
			'ProjectName': project.name,
			'Version': project.version,
			'Maintainer': 'Franz Wilhelmstötter',
			'Automatic-Module-Name': 'io.jenetics.prngine'
		)
	}
}

idea {
	module{
		scopes.COMPILE.plus += [configurations.jmh]
	}
}


/ ******************************************************************************
 * Artifact publishing code.
 ******************************************************************************/

afterEvaluate { project ->
	uploadArchives {
		repositories {
			mavenDeployer {
				beforeDeployment {
					MavenDeployment deployment -> signing.signPom(deployment)
				}

				pom.groupId = project.group
				pom.artifactId = project.name
				pom.version = project.version

				repository(url: 'https://oss.sonatype.org/service/local/staging/deploy/maven2/') {
					authentication(
						userName: project.hasProperty('nexus_username')
							? project.property('nexus_username')
							: 'nexus_username',
						password: project.hasProperty('nexus_password')
							? project.property('nexus_password')
							: 'nexus_password'
					)
				}
				snapshotRepository(url: 'https://oss.sonatype.org/content/repositories/snapshots/') {
					authentication(
						userName: project.hasProperty('nexus_username')
							? project.property('nexus_username')
							: 'nexus_username',
						password: project.hasProperty('nexus_password')
							? project.property('nexus_password')
							: 'nexus_password'
					)
				}

				pom.project {
					name 'PRNGine'
					packaging 'pom'
					description 'PRNGine - Java PRNG Library'
					url 'https://github.com/jenetics/prngine'
					inceptionYear '2017'

					scm {
						url 'https://github.com/jenetics/prngine'
						connection 'scm:git:https://github.com/jenetics/prngine.git'
						developerConnection 'scm:git:https://github.com/jenetics/prngine.git'
					}

					licenses {
						license {
							name 'The Apache Software License, Version 2.0'
							url 'http://www.apache.org/licenses/LICENSE-2.0.txt'
							distribution 'repo'
						}
					}

					developers {
						developer {
							id 'jenetics'
							name 'Franz Wilhelmstötter'
							email 'franz.wilhelmstoetter@gmail.com'
						}
					}
				}
			}
		}
	}

	task sourcesJar(type: Jar) {
		archiveClassifier = 'sources'
		from project.sourceSets.main.allSource
		filter(ReplaceTokens, tokens: [
			__identifier__: project.name + '-' + project.version,
			__year__: project.copyrightYear
		])
	}

	task javadocJar(type: Jar, dependsOn: javadoc) {
		archiveClassifier = 'javadoc'
		from project.javadoc
		filter(ReplaceTokens, tokens: [
			__identifier__: project.name + '-' + project.version,
			__year__: project.copyrightYear
		])
	}

	signing {
		required {
			!project.version.endsWith('SNAPSHOT') &&
			gradle.taskGraph.hasTask("uploadArchives")
		}
		sign configurations.archives
	}

	artifacts {
		archives sourcesJar
		archives javadocJar
	}

}
