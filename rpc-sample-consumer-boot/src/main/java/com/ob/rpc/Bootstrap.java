/*
 * Copyright 2012-2016 the original author or authors.
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
 */

package com.ob.rpc;

import com.ob.rpc.client.RpcProxy;
import com.ob.rpc.common.exception.ErrorEnum;
import com.ob.rpc.common.exception.SystemException;
import com.ob.service.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Bootstrap implements CommandLineRunner {

	// Simple example shows how a command line spring application can execute an
	// injected bean service. Also demonstrates how you can use @Value to inject
	// command line args ('--name=whatever') or application properties

	@Autowired
	private RpcProxy rpcProxy;

	@Override
	public void run(String... args) {

		if (args.length > 0 && args[0].equals("exitcode")) {
			throw new SystemException(ErrorEnum.SERVICE_INVOKE.toString(),"this service");
		}

		HelloService helloService = rpcProxy.create(HelloService.class);
		String result = helloService.hello("World");
		System.out.println(result);

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Bootstrap.class, args);
	}

}
