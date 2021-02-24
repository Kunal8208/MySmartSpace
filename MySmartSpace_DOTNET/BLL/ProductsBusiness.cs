using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BOL;
using DAL;

namespace BLL
{
    public class ProductsBusiness
    {
        public static List<Product> GetAllProducts()
        {
            return ProductsDBManager.GetAllProducts();
        }

        public static List<Product> findByCategory(int productCategoryId)
        {
            return ProductsDBManager.findByCategory(productCategoryId);
        }

        public static List<Product> findByServiceProviderId(int serviceProviderId)
        {
            return ProductsDBManager.findByServiceProviderId(serviceProviderId);
        }

        public static Product findById(int productId)
        {
            return ProductsDBManager.findById(productId);
        }

        public static Product addProduct(Product newProduct)
        {
            return ProductsDBManager.addProduct(newProduct);
        }

        public static Product deleteProduct(Product existingProduct)
        {
            return ProductsDBManager.deleteProduct(existingProduct);
        }

        public static String[] getAllCategories()
        {
            return ProductsDBManager.getAllCategories();
        }
    }
}
