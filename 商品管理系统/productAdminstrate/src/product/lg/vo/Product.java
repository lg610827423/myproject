package product.lg.vo;

public class Product {
	private int id;				//������Ʒ��ţ���product����id��Ӧ
	private String name;		//������Ʒ���ƣ���product����name��Ӧ
	private float price;		//������Ʒ�۸���product����price��Ӧ
	private int count;			//������Ʒ��������product����count��Ӧ
	private String factory;		//������Ʒ�����̣���product����factory��Ӧ
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}

}
