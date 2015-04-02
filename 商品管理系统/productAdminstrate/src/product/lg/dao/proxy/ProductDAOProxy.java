package product.lg.dao.proxy;

import java.util.List;

import product.lg.dao.IProductDAO;
import product.lg.dao.impl.ProductDAOImpl;
import product.lg.dbc.DatabaseConnection;
import product.lg.vo.Product;

public class ProductDAOProxy implements IProductDAO {
	private DatabaseConnection dbc=null;	//定义数据库连接类
	private IProductDAO dao=null;			//声明DAO对象
	public ProductDAOProxy() throws Exception{	//构造方法中实例化连接，同时实例化dao对象
		this.dbc=new DatabaseConnection();
		dao=new ProductDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Product product) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(product.getId())==null){	//如果插入的商品id不存在
				flag=this.dao.doCreate(product);			//调用真实主题
			}
		}catch(Exception e){
			throw e;				//有异常交给被调用处处理
		}finally{
			this.dbc.close();		//关闭数据库连接
		}
		return flag;
	}

	@Override
	public boolean doModify(Product product) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.doModify(product);		//调用真实主题
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();						//关闭数据库连接
		}
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.doDelete(id);		//调用真实主题类
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();						//关闭数据库连接
		}
		return flag;
	}

	@Override
	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all=null;			//定义返回的集合
		try{
			all=this.dao.findAll(keyWord);	//调用真实主题类
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public Product findById(int id) throws Exception {
		Product product=null;			//定义返回的Product对象
		try{
			product=this.dao.findById(id);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return product;
	}

}
