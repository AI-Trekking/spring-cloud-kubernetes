/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.kubernetes.client.profile;

import io.kubernetes.client.openapi.apis.CoreV1Api;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.cloud.kubernetes.commons.profile.AbstractKubernetesProfileEnvironmentPostProcessor.KUBERNETES_PROFILE;

/**
 * @author Ryan Baxter
 */
@SpringBootTest(classes = { KubernetesClientProfileEnvironmentPostProcessorNoProfileTests.App.class })
class KubernetesClientProfileEnvironmentPostProcessorNoProfileTests {

	@Autowired
	Environment environment;

	@MockBean
	CoreV1Api coreV1Api;

	@Test
	void whenNoKubernetesEnvironmentAndNoApiAccessThenNoProfileEnabled() {

		assertThat(environment.getActiveProfiles()).doesNotContain(KUBERNETES_PROFILE);
	}

	@SpringBootApplication
	static class App {

	}

}
