package product.lg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import product.lg.dao.IProductDAO;
import product.lg.vo.Product;

public class ProductDAOImpl implements IProductDAO {
	private Connection conn=null;			//���ݿ����Ӷ���
	private PreparedStatement pstmt=null;	//���ݿ��������
	public ProductDAOImpl(Connection conn){
		this.conn=conn;						//ͨ�����췽��ȡ�����ݿ�����
	}

	@Override
	public boolean doCreate(Product product) throws Exception {
		boolean flag=false;					//�����־λ���ж��Ƿ񴴽��ɹ�
		String sql="INSERT INTO product(id,name,price,count,factory)VALUES(?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);		//ʵ����PreparedStatement����
		this.pstmt.setInt(1, product.getId());			//��������
		this.pstmt.setString(2, product.getName());
		this.pstmt.setFloat(3, product.getPrice());
		this.pstmt.setInt(4, product.getCount());
		this.pstmt.setString(5, product.getFactory());
		if(this.pstmt.executeUpdate()>0){		//���¼�¼��������0
			flag=true;							//����־λ����Ϊ��
		}
		this.pstmt.close();						//�ر�PreparedStatement����
		return flag;
	}

	@Override
	public boolean doModify(Product product) throws Exception {
		boolean flag=false;		//�����־λ
		String sql="UPDATE product set name=?,price=?,count=?,factory=? where id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		//���ò�ѯ��Ϣ
		this.pstmt.setString(1, product.getName());
		this.pstmt.setFloat(2, product.getPrice());
		this.pstmt.setInt(3, product.getCount());
		this.pstmt.setString(4, product.getFactory());
		this.pstmt.setInt(5, product.getId());
		int i=this.pstmt.executeUpdate();
		if(i!=-1){
			flag=true;			//���³ɹ������־��Ϊ��
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
			flag=true;		//���³ɹ������־��Ϊ��
		}
		return flag;
	}

	@Override
	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all=new ArrayList<Product>();
		String sql="SELECT id,name,price,count,factory FROM product WHERE name LIKE ? OR factory LIKE ?";
		this.pstmt=this.conn.prepareStatement(sql);		//ʵ����PreparedStatement����
		this.pstmt.setString(1, "%"+keyWord+"%");		//���ò�ѯ�ؼ���
		this.pstmt.setString(2, "%"+keyWord+"%");
		ResultSet rs=this.pstmt.executeQuery();			//ִ�в�ѯ
		Product product=null;							//����Product����
		while(rs.next()){
			product=new Product();						//ʵ�����µ�Product����
			product.setId(rs.getInt(1));				//ͨ��ResultSet��������
			product.setName(rs.getString(2));
			product.setPrice(rs.getFloat(3));
			product.setCount(rs.getInt(4));
			product.setFactory(rs.getString(5));
			all.add(product);							//�򼯺������Ӷ���
		}
		this.pstmt.close();								//�ر�PreparedStatement����
		return all;										//����ȫ�����
	}

	@Override
	public Product findById(int id) throws Exception {
		Product product=null;
		String sql="SELECT id,name,price,count,factory FROM product WHERE id=?";
		this.pstmt=this.conn.prepareStatement(sql);		//ʵ����PreparedStatement����
		this.pstmt.setInt(1, id);
		ResultSet rs=this.pstmt.executeQuery();			//ִ�в�ѯ����
		if(rs.next()){
			product=new Product();
			product.setId(rs.getInt(1));				//��������
			product.setName(rs.getString(2));
			product.setPrice(rs.getFloat(3));
			product.setCount(rs.getInt(4));
			product.setFactory(rs.getString(5));
		}
		this.pstmt.close();								//�ر�PreparedStatement����
		return product;
	}

}
