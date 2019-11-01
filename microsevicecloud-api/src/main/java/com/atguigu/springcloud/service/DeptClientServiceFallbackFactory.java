package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{
	 @Override
	  public DeptClientService create(Throwable throwable)
	  {
		 return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get() {
				Dept dept=new Dept();
				dept.setDname("没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
				dept.setDeptno(1L);
				dept.setDb_source("no this database in MySQL");
				return dept;
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	  
	}
	 
}
	 
