package product.lg.vo;

public class Product {
	private int id;				//定义商品编号，与product表中id对应
	private String name;		//定义商品名称，与product表中name对应
	private float price;		//定义商品价格，与product表中price对应
	private int count;			//定义商品数量，与product表中count对应
	private String factory;		//定义商品生产商，与product表中factory对应
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
