package com.atguigu.murule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MyselfRule {

	@Bean
	public IRule myRule() {
		
		//return new RandomRule();//默认为轮询，我自定义为随机
		//return new RoundRobinRule();//定义为轮询
		return new RandomRule_ZY();//自定义为每个机器被访问5次
	}
}
