package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class DeptController {
    
	  @Autowired
	  private DeptService service ;
	  
	  @RequestMapping(value="/dept/get",method=RequestMethod.GET)
	  @HystrixCommand(fallbackMethod = "processHystrix_Get")
	  public Dept get()
	  {
		  Long i=new Long(1);
	   Dept dept =  this.service.get(i);
	   if(null == dept)
	   {
	     throw new RuntimeException("该ID："+i+"没有没有对应的信息");
	   }
	   return dept;
	  }
	  
	  public Dept processHystrix_Get()
	  {
		  Dept dept =new Dept();
		  dept.setDname("该服务以关闭");
		  dept.setDeptno(11L);
		 
		  return dept;
				  //new Dept(id,"该ID："+id+"没有没有对应的信息,null--@HystrixCommand","no this database in MySQL");
				
	  }

}
