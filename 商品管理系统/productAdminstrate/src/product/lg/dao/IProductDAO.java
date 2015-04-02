package product.lg.dao;

import java.util.List;

import product.lg.vo.Product;

public interface IProductDAO {		//定义DAO操作标准
	public boolean doCreate(Product product) throws Exception;		//添加数据操作
	public boolean doModify(Product product) throws Exception;		//修改数据操作
	public boolean doDelete(int id) throws Exception;				//删除数据操作
	public List<Product> findAll(String keyWord) throws Exception;	//按关键字查询操作
	public Product findById(int id) throws Exception;				//按商品编码操作

}
