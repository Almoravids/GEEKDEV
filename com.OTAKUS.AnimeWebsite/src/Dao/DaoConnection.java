package Dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DaoConnection {
	  private static  DataSource dataSource;
	  private static JdbcTemplate jdbcT;


		public static DataSource getDataSource() {
		   return dataSource;
		  }

		  public   void setDataSource(DataSource dataSource) {
		   this.dataSource = dataSource;
		   
		  }
		public static JdbcTemplate  getConnection() throws SQLException, ClassNotFoundException{
			if (jdbcT==null)
			jdbcT=new JdbcTemplate();
			ApplicationContext context = new ClassPathXmlApplicationContext("springConf.xml");
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 if (dataSource==null)
			 dataSource.getConnection();
			 jdbcT.setDataSource(dataSource);
			 return jdbcT;
		}

//		public static Object getcontext(){
//			ApplicationContext context = new ClassPathXmlApplicationContext("springConf.xml");
//			 return context.getBean("DaoConnection");	
//		}
	
}
