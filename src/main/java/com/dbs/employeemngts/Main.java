package com.dbs.employeemngts;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.dbs.employeemngts.config.Config;
import com.dbs.employeemngts.repository.EmployeeRepository;
import com.dbs.employeemngts.service.EmployeeService;


public class Main {
   public static void main(String[] args) {
         // TODO Auto-generated method stub
          ApplicationContext applicationContext=
                       new AnnotationConfigApplicationContext(Config.class);
        //above line informs that we are using java based annotation strategy
        //to create spring environment
          EmployeeService employeeservice=applicationContext.getBean(EmployeeService.class);
          EmployeeService employeeservice2=applicationContext.getBean(EmployeeService.class);
          
          System.out.println(employeeservice.hashCode());
          System.out.println(employeeservice2.hashCode());
          System.out.println(employeeservice.equals(employeeservice2));
          
          System.out.println("===========Bean");
          BasicDataSource basicDataSource=applicationContext.getBean("dataSource",BasicDataSource.class);
          BasicDataSource basicDataSource2=applicationContext.getBean("dataSource",BasicDataSource.class);
          
          System.out.println(basicDataSource.equals(basicDataSource2));
          
          
}

}