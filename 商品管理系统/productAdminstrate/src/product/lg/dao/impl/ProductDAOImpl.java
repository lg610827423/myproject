package product.lg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import product.lg.dao.IProductDAO;
import product.lg.vo.Product;

public class ProductDAOImpl implements IProductDAO {
	private Connection conn=null;			//数据库连接对象
	private PreparedStatement pstmt=null;	//数据库操作对象
	public ProductDAOImpl(Connection conn){
		this.conn=conn;						//通过构造方法取得数据库连接
	}

	@Override
	public boolean doCreate(Product product) throws Exception {
		boolean flag=false;					//定义标志位，判断是否创建成功
		String sql="INSERT INTO product(id,name,price,count,factory)VALUES(?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);		//实例化PreparedStatement对象
		this.pstmt.setInt(1, product.getId());			//设置数据
		this.pstmt.setString(2, product.getName());
		this.pstmt.setFloat(3, product.getPrice());
		this.pstmt.setInt(4, product.getCount());
		this.pstmt.setString(5, product.getFactory());
		if(this.pstmt.executeUpdate()>0){		//更新记录行数大于0
			flag=true;							//将标志位设置为真
		}
		this.pstmt.close();						//关闭PreparedStatement操作
		return flag;
	}

	@Override
	public boolean doModify(Product product) throws Exception {
		boolean flag=false;		//定义标志位
		String sql="UPDATE product set name=?,price=?,count=?,factory=? where id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		//设置查询信息
		this.pstmt.setString(1, product.getName());
		this.pstmt.setFloat(2, product.getPrice());
		this.pstmt.setInt(3, product.getCount());
		this.pstmt.setString(4, product.getFactory());
		this.pstmt.setInt(5, product.getId());
		int i=this.pstmt.executeUpdate();
		if(i!=-1){
			flag=true;			//更新成功，则标志设为真
		}
		return flag;
		
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flag=false;
		String sql="DELETE FROM product where id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1,id);
		int i=this.pstmt.executeUpdate();
		if(i!=1){
			flag=true;		//更新成功，则标志设为真
		}
		return flag;
	}

	@Override
	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all=new ArrayList<Product>();
		String sql="SELECT id,name,price,count,factory FROM product WHERE name LIKE ? OR factory LIKE ?";
		this.pstmt=this.conn.prepareStatement(sql);		//实例化PreparedStatement对象
		this.pstmt.setString(1, "%"+keyWord+"%");		//设置查询关键字
		this.pstmt.setString(2, "%"+keyWord+"%");
		ResultSet rs=this.pstmt.executeQuery();			//执行查询
		Product product=null;							//定义Product对象
		while(rs.next()){
			product=new Product();						//实例化新的Product对象
			product.setId(rs.getInt(1));				//通过ResultSet设置内容
			product.setName(rs.getString(2));
			product.setPrice(rs.getFloat(3));
			product.setCount(rs.getInt(4));
			product.setFactory(rs.getString(5));
			all.add(product);							//向集合中增加对象
		}
		this.pstmt.close();								//关闭PreparedStatement操作
		return all;										//返回全部结果
	}

	@Override
	public Product findById(int id) throws Exception {
		Product product=null;
		String sql="SELECT id,name,price,count,factory FROM product WHERE id=?";
		this.pstmt=this.conn.prepareStatement(sql);		//实例化PreparedStatement对象
		this.pstmt.setInt(1, id);
		ResultSet rs=this.pstmt.executeQuery();			//执行查询操作
		if(rs.next()){
			product=new Product();
			product.setId(rs.getInt(1));				//设置内容
			product.setName(rs.getString(2));
			product.setPrice(rs.getFloat(3));
			product.setCount(rs.getInt(4));
			product.setFactory(rs.getString(5));
		}
		this.pstmt.close();								//关闭PreparedStatement操作
		return product;
	}

}
