using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data;
using MySql.Data;
using MySql.Data.MySqlClient;
using BOL;

namespace DAL
{
    public class ProductsDBManager
    {
        static string conString = string.Empty;

        static ProductsDBManager()
        {
            conString = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        }

        public static List<Product> GetAllProducts()
        {
            List<Product> allProducts = new List<Product>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from products";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataRowCollection rows = ds.Tables[0].Rows;
                foreach (DataRow row in rows)
                {
                    Product theProduct = new Product();
                    theProduct.ProductId = int.Parse(row["product_id"].ToString());
                    theProduct.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    theProduct.BuildType = row["build_type"].ToString();
                    theProduct.CameraEquipped = row["camera_equipped"].ToString();
                    theProduct.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    theProduct.Controller = row["controller"].ToString();
                    theProduct.Description = row["description"].ToString();
                    theProduct.Dimension = row["dimension"].ToString();
                    theProduct.FinalPrice = double.Parse(row["final_price"].ToString());
                    theProduct.ImageUrl = row["image_url"].ToString();
                    theProduct.InternetControlled = row["internet_controlled"].ToString() == "1";
                    theProduct.MotorType = row["motor_type"].ToString();
                    theProduct.PhysicalRemote = row["physical_remote"].ToString();
                    theProduct.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    theProduct.QuantitySold = int.Parse(row["quantity_sold"].ToString());
                    theProduct.Rating = double.Parse(row["rating"].ToString());
                    theProduct.Sensor = row["sensor"].ToString();
                    theProduct.Weight = double.Parse(row["weight"].ToString());
                    theProduct.WiringType = row["wiring_type"].ToString();
                    theProduct.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id"].ToString()));

                    allProducts.Add(theProduct);
                }

            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }

            return allProducts;
        }



        public static List<Product> findByCategory(int productCategoryId)
        {
            List<Product> categorizedProducts = new List<Product>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from products where category=@category";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("category", Enum.GetName(typeof(ProductCategory), productCategoryId)));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);
                DataRowCollection rows = ds.Tables[0].Rows;
                foreach(DataRow row in rows)
                {
                    Product theProduct = new Product();
                    theProduct.ProductId = int.Parse(row["product_id"].ToString());
                    theProduct.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    theProduct.BuildType = row["build_type"].ToString();
                    theProduct.CameraEquipped = row["camera_equipped"].ToString();
                    theProduct.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    theProduct.Controller = row["controller"].ToString();
                    theProduct.Description = row["description"].ToString();
                    theProduct.Dimension = row["dimension"].ToString();
                    theProduct.FinalPrice = double.Parse(row["final_price"].ToString());
                    theProduct.ImageUrl = row["image_url"].ToString();
                    theProduct.InternetControlled = row["internet_controlled"].ToString() == "1";
                    theProduct.MotorType = row["motor_type"].ToString();
                    theProduct.PhysicalRemote = row["physical_remote"].ToString();
                    theProduct.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    theProduct.QuantitySold = int.Parse(row["quantity_sold"].ToString());
                    theProduct.Rating = double.Parse(row["rating"].ToString());
                    theProduct.Sensor = row["sensor"].ToString();
                    theProduct.Weight = double.Parse(row["weight"].ToString());
                    theProduct.WiringType = row["wiring_type"].ToString();
                    theProduct.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id"].ToString()));

                    categorizedProducts.Add(theProduct);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return categorizedProducts;
        }



        public static List<Product> findByServiceProviderId(int serviceProviderId)
        {
            List<Product> products = new List<Product>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from products where service_provider_id=@id";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("id", serviceProviderId));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);
                DataRowCollection rows = ds.Tables[0].Rows;
                foreach (DataRow row in rows)
                {
                    Product theProduct = new Product();
                    theProduct.ProductId = int.Parse(row["product_id"].ToString());
                    theProduct.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    theProduct.BuildType = row["build_type"].ToString();
                    theProduct.CameraEquipped = row["camera_equipped"].ToString();
                    theProduct.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    theProduct.Controller = row["controller"].ToString();
                    theProduct.Description = row["description"].ToString();
                    theProduct.Dimension = row["dimension"].ToString();
                    theProduct.FinalPrice = double.Parse(row["final_price"].ToString());
                    theProduct.ImageUrl = row["image_url"].ToString();
                    theProduct.InternetControlled = row["internet_controlled"].ToString() == "1";
                    theProduct.MotorType = row["motor_type"].ToString();
                    theProduct.PhysicalRemote = row["physical_remote"].ToString();
                    theProduct.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    theProduct.QuantitySold = int.Parse(row["quantity_sold"].ToString());
                    theProduct.Rating = double.Parse(row["rating"].ToString());
                    theProduct.Sensor = row["sensor"].ToString();
                    theProduct.Weight = double.Parse(row["weight"].ToString());
                    theProduct.WiringType = row["wiring_type"].ToString();
                    theProduct.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id"].ToString()));

                    products.Add(theProduct);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return products;
        }



        public static Product findById(int productId)
        {
            Product theProduct = new Product();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from products";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["product_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(productId);

                if (row != null)
                {
                    theProduct.ProductId = int.Parse(row["product_id"].ToString());
                    theProduct.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    theProduct.BuildType = row["build_type"].ToString();
                    theProduct.CameraEquipped = row["camera_equipped"].ToString();
                    theProduct.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    theProduct.Controller = row["controller"].ToString();
                    theProduct.Description = row["description"].ToString();
                    theProduct.Dimension = row["dimension"].ToString();
                    theProduct.FinalPrice = double.Parse(row["final_price"].ToString());
                    theProduct.ImageUrl = row["image_url"].ToString();
                    theProduct.InternetControlled = row["internet_controlled"].ToString() == "1";
                    theProduct.MotorType = row["motor_type"].ToString();
                    theProduct.PhysicalRemote = row["physical_remote"].ToString();
                    theProduct.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    theProduct.QuantitySold = int.Parse(row["quantity_sold"].ToString());
                    theProduct.Rating = double.Parse(row["rating"].ToString());
                    theProduct.Sensor = row["sensor"].ToString();
                    theProduct.Weight = double.Parse(row["weight"].ToString());
                    theProduct.WiringType = row["wiring_type"].ToString();
                    theProduct.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id"].ToString()));
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return theProduct;
        }


        public static Product addProduct(Product newProduct)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from products";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataRow newrow = ds.Tables[0].NewRow();

                newrow["productId"] = newProduct.ProductId;
                newrow["bluetooth_enabled"] = newProduct.BluetoothEnabled;
                newrow["build_type"] = newProduct.BuildType;
                newrow["camera_equipped"] = newProduct.CameraEquipped;
                newrow["category"] = newProduct.Category.ToString();
                newrow["controller"] = newProduct.Controller;
                newrow["description"] = newProduct.Description;
                newrow["dimension"] = newProduct.Dimension;
                newrow["final_price"] = newProduct.FinalPrice;
                newrow["image_url"] = newProduct.ImageUrl;
                newrow["internet_controlled"] = newProduct.InternetControlled;
                newrow["motor_type"] = newProduct.MotorType;
                newrow["physical_remote"] = newProduct.PhysicalRemote;
                newrow["power_supply_unit"] = newProduct.PowerSupplyUnit;
                newrow["quantity_sold"] = newProduct.QuantitySold;
                newrow["rating"] = newProduct.Rating;
                newrow["sensor"] = newProduct.Sensor;
                newrow["weight"] = newProduct.Weight;
                newrow["wiring_type"] = newProduct.WiringType;
                newrow["service_provider_id"] = newProduct.ServiceProviderId.UserId;

                ds.Tables[0].Rows.Add(newrow);
                da.Update(ds);

                return newProduct;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }


        public static Product deleteProduct(Product existingProduct)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from products";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["product_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(existingProduct.ProductId);

                row.Delete();

                da.Update(ds);

                return existingProduct;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }


        public static String[] getAllCategories()
        {
            List<String> list = new List<String>();
            String[] arr = Enum.GetNames(typeof(ProductCategory));
            return arr;
        }
    }
}
