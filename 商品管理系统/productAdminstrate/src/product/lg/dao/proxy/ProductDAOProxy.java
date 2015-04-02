package product.lg.dao.proxy;

import java.util.List;

import product.lg.dao.IProductDAO;
import product.lg.dao.impl.ProductDAOImpl;
import product.lg.dbc.DatabaseConnection;
import product.lg.vo.Product;

public class ProductDAOProxy implements IProductDAO {
	private DatabaseConnection dbc=null;	//�������ݿ�������
	private IProductDAO dao=null;			//����DAO����
	public ProductDAOProxy() throws Exception{	//���췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc=new DatabaseConnection();
		dao=new ProductDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(Product product) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.findById(product.getId())==null){	//����������Ʒid������
				flag=this.dao.doCreate(product);			//������ʵ����
			}
		}catch(Exception e){
			throw e;				//���쳣���������ô�����
		}finally{
			this.dbc.close();		//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	public boolean doModify(Product product) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.doModify(product);		//������ʵ����
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();						//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean flag=false;
		try{
			flag=this.dao.doDelete(id);		//������ʵ������
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();						//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all=null;			//���巵�صļ���
		try{
			all=this.dao.findAll(keyWord);	//������ʵ������
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return all;
	}

	@Override
	public Product findById(int id) throws Exception {
		Product product=null;			//���巵�ص�Product����
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
