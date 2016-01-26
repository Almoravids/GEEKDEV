package Dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DaoConnection {
	  private DataSource dataSource;
	  private JdbcTemplate JdbcT=new JdbcTemplate();
	  
	  public JdbcTemplate getJdbcT() {
			return JdbcT;
		}
			
		public void setJdbcT(JdbcTemplate JdbcT) {
			this.JdbcT = JdbcT;
		}

		public DataSource getDataSource() {
		   return dataSource;
		  }

		  public void setDataSource(DataSource dataSource) {
		   this.dataSource = dataSource;
		   
		  }
		public void  getConnection() throws SQLException, ClassNotFoundException{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 dataSource.getConnection();
			 JdbcT.setDataSource(getDataSource());
		}

		public static Object getcontext(){
			ApplicationContext context = new ClassPathXmlApplicationContext("springConf.xml");
			 return context.getBean("DaoConnection");	
		}
 
}
