package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration//配置类
public class ConfigBean {

	@Bean
	@LoadBalanced//负载均衡工具
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
	
	/*@Bean
	public IRule iRule() {
		return new RetryRule();//用随机算法代替轮询
		
	}*/
}
