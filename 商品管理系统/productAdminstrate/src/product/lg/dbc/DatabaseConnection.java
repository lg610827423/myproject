package product.lg.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DBDRIVER="org.gjt.mm.mysql.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/mldn";
	private static final String DBUSER="root";
	private static final String DBPASSWORD="mysqladmin";
	private Connection conn=null;
	public DatabaseConnection() throws Exception{
		try{
			Class.forName(DBDRIVER);		//加载驱动
			this.conn=DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);	//连接数据库
		}catch(Exception e){
			throw e;
		}
	}
	public Connection getConnection(){			//取得数据库连接
		return this.conn;
	}
	public void close() throws Exception{		//数据库关闭
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch(Exception e){
				throw e;
			}
		}
	}

}
