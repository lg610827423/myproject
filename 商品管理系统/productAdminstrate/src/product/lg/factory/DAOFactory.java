package product.lg.factory;

import product.lg.dao.IProductDAO;
import product.lg.dao.proxy.ProductDAOProxy;

public class DAOFactory {
	public static IProductDAO getIProductDAOInstance() throws Exception{
		return new ProductDAOProxy();
	}

}
