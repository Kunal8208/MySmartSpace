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
    public class PaymentsDBManager
    {
        static string conString = string.Empty;

        static PaymentsDBManager()
        {
            conString = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        }

        public static Payment addPayment(Payment newPayment)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from payment";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);


                DataRow newrow = ds.Tables[0].NewRow();

                newrow["payment_id"] = newPayment.PaymentId;
                newrow["payment_amount"] = newPayment.PaymentAmount;
                newrow["payment_date"] = newPayment.PaymentDate;
                newrow["order_id_order_id"] = newPayment.OrderId.OrderId;
                

                ds.Tables[0].Rows.Add(newrow);
                da.Update(ds);

                return newPayment;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }
    }
}
