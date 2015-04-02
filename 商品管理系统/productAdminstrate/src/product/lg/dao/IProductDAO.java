package product.lg.dao;

import java.util.List;

import product.lg.vo.Product;

public interface IProductDAO {		//����DAO������׼
	public boolean doCreate(Product product) throws Exception;		//������ݲ���
	public boolean doModify(Product product) throws Exception;		//�޸����ݲ���
	public boolean doDelete(int id) throws Exception;				//ɾ�����ݲ���
	public List<Product> findAll(String keyWord) throws Exception;	//���ؼ��ֲ�ѯ����
	public Product findById(int id) throws Exception;				//����Ʒ�������

}
