/*
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
 * Defining the used external libraries.
 */
object Libs {
	const val ApacheCommonsMath = "org.apache.commons:commons-math3:3.6.1"
	const val EqualsVerifier = "nl.jqno.equalsverifier:equalsverifier:3.5"
	const val TestNG = "org.testng:testng:7.3.0"

	val All = arrayOf(
		ApacheCommonsMath,
		EqualsVerifier,
		TestNG
	)
}
