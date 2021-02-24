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
    public class OrdersDBManager
    {
        static string conString = string.Empty;

        static OrdersDBManager()
        {
            conString = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        }


        public static Order getOrderById(int orderId)
        {
            Order order = new Order();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from orders";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["order_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(orderId);
                if (row != null)
                {
                    order.OrderId = int.Parse(row["order_id"].ToString());
                    order.Note = row["note"].ToString();
                    order.OrderDate = row["order_date"].ToString();
                    order.OrderStatus = (OrderStatus)Enum.Parse(typeof(OrderStatus), row["order_status"].ToString());
                    order.PaymentStatus = row["payment_status"].ToString()=="1";
                    order.Quantity = int.Parse(row["quantity"].ToString());
                    order.TotalAmount = double.Parse(row["total_amount"].ToString());
                    order.CustomerId = UsersDBManager.getUserById(int.Parse(row["customer_id_user_id"].ToString()));
                    order.ProductId = ProductsDBManager.findById(int.Parse(row["product_id_product_id"].ToString()));                  
                    order.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id_user_id"].ToString()));

                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return order;
        }


        public static List<Order> getOrdersByCustomerId(int customerId)
        {
            List<Order> allOrders = new List<Order>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from orders where customer_id_user_id=@custId";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("custId", customerId));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataRowCollection rows = ds.Tables[0].Rows;
                foreach (DataRow row in rows)
                {
                    Order order = new Order();

                    order.OrderId = int.Parse(row["order_id"].ToString());
                    order.Note = row["note"].ToString();
                    order.OrderDate = row["order_date"].ToString();
                    order.OrderStatus = (OrderStatus)Enum.Parse(typeof(OrderStatus), row["order_status"].ToString());
                    order.PaymentStatus = row["payment_status"].ToString() == "1";
                    order.Quantity = int.Parse(row["quantity"].ToString());
                    order.TotalAmount = double.Parse(row["total_amount"].ToString());
                    order.CustomerId = UsersDBManager.getUserById(int.Parse(row["customer_id_user_id"].ToString()));
                    order.ProductId = ProductsDBManager.findById(int.Parse(row["product_id_product_id"].ToString()));
                    order.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id_user_id"].ToString()));

                    allOrders.Add(order);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return allOrders;
        }





        public static List<Order> getOrdersByServiceProviderId(int serviceProviderId)
        {
            List<Order> allOrders = new List<Order>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from orders where service_provider_id_user_id=@servProvId";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("servProvId", serviceProviderId));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataRowCollection rows = ds.Tables[0].Rows;
                foreach (DataRow row in rows)
                {
                    Order order = new Order();

                    order.OrderId = int.Parse(row["order_id"].ToString());
                    order.Note = row["note"].ToString();
                    order.OrderDate = row["order_date"].ToString();
                    order.OrderStatus = (OrderStatus)Enum.Parse(typeof(OrderStatus), row["order_status"].ToString());
                    order.PaymentStatus = row["payment_status"].ToString() == "1";
                    order.Quantity = int.Parse(row["quantity"].ToString());
                    order.TotalAmount = double.Parse(row["total_amount"].ToString());
                    order.CustomerId = UsersDBManager.getUserById(int.Parse(row["customer_id_user_id"].ToString()));
                    order.ProductId = ProductsDBManager.findById(int.Parse(row["product_id_product_id"].ToString()));
                    order.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id_user_id"].ToString()));

                    allOrders.Add(order);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return allOrders;
        }



        public static Order addOrder(Order newOrder)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from orders";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);


                DataRow newrow = ds.Tables[0].NewRow();

                newrow["order_id"] = newOrder.OrderId;
                newrow["note"] = newOrder.Note;
                newrow["order_date"] = newOrder.OrderDate;
                newrow["order_status"] = newOrder.OrderStatus.ToString();
                newrow["payment_status"] = newOrder.PaymentStatus;
                newrow["quantity"] = newOrder.Quantity;
                newrow["total_amount"] = newOrder.TotalAmount;
                newrow["customer_id_user_id"] = newOrder.CustomerId.UserId;
                newrow["product_id_product_id"] = newOrder.ProductId.ProductId;
                newrow["service_provider_id_user_id"] = newOrder.ServiceProviderId.UserId;

                ds.Tables[0].Rows.Add(newrow);
                da.Update(ds);

                return newOrder;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }


        public static Order updateOrder(Order existingOrder)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from orders";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["order_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(existingOrder.OrderId);

                row["order_id"] = existingOrder.OrderId;
                row["note"] = existingOrder.Note;
                row["order_date"] = existingOrder.OrderDate;
                row["order_status"] = existingOrder.OrderStatus.ToString();
                row["payment_status"] = existingOrder.PaymentStatus;
                row["quantity"] = existingOrder.Quantity;
                row["total_amount"] = existingOrder.TotalAmount;
                row["customer_id_user_id"] = existingOrder.CustomerId.UserId;
                row["product_id_product_id"] = existingOrder.ProductId.ProductId;
                row["service_provider_id_user_id"] = existingOrder.ServiceProviderId.UserId;

                da.Update(ds);

                return existingOrder;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }



    }
}
