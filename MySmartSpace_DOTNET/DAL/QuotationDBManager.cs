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
    public class QuotationDBManager
    {
        static string conString = string.Empty;

        static QuotationDBManager()
        {
            conString = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        }






        public static Quotation getQuotationById(int quotationId)
        {
            Quotation quotation = new Quotation();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from quotations";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["quotation_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(quotationId);
                if (row != null)
                {
                    quotation.QuotationId = int.Parse(row["quotation_id"].ToString());
                    quotation.AcceptanceStatus = int.Parse(row["acceptance_status"].ToString());
                    quotation.FinalPrice = double.Parse(row["final_price"].ToString());
                    quotation.Response = row["response"].ToString();
                    quotation.RequestId = NewRequestDBManager.getRequestById(int.Parse(row["request_id"].ToString()));
                    quotation.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id"].ToString()));
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return quotation;
        }



        public static Quotation updateQuotation(Quotation existingQuotation)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from quotations";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["quotation_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(existingQuotation.QuotationId);

                row["quotation_id"] = existingQuotation.QuotationId;
                row["acceptance_status"] = existingQuotation.AcceptanceStatus;
                row["final_price"] = existingQuotation.FinalPrice;
                row["response"] = existingQuotation.Response;
                row["request_id"] = existingQuotation.RequestId.RequestId;
                row["service_provider_id"] = existingQuotation.ServiceProviderId.UserId;

                da.Update(ds);

                return existingQuotation;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }



        public static List<Quotation> getQuotationsByRequestId(int newRequestId)
        {
            List<Quotation> allQuotations = new List<Quotation>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from quotations where request_id=@requestid";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("requestid", newRequestId));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataRowCollection rows = ds.Tables[0].Rows;
                foreach (DataRow row in rows)
                {
                    Quotation quotation = new Quotation();

                    quotation.QuotationId = int.Parse(row["quotation_id"].ToString());
                    quotation.AcceptanceStatus = int.Parse(row["acceptance_status"].ToString());
                    quotation.FinalPrice = double.Parse(row["final_price"].ToString());
                    quotation.Response = row["response"].ToString();
                    quotation.RequestId = NewRequestDBManager.getRequestById(int.Parse(row["request_id"].ToString()));
                    quotation.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id"].ToString()));

                    allQuotations.Add(quotation);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return allQuotations;
        }




        public static List<Quotation> getQuotationsByServiceProviderId(int serviceProviderId)
        {
            List<Quotation> allQuotations = new List<Quotation>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from quotations where service_provider_id=@id";
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
                    Quotation quotation = new Quotation();

                    quotation.QuotationId = int.Parse(row["quotation_id"].ToString());
                    quotation.AcceptanceStatus = int.Parse(row["acceptance_status"].ToString());
                    quotation.FinalPrice = double.Parse(row["final_price"].ToString());
                    quotation.Response = row["response"].ToString();
                    quotation.RequestId = NewRequestDBManager.getRequestById(int.Parse(row["request_id"].ToString()));
                    quotation.ServiceProviderId = UsersDBManager.getUserById(int.Parse(row["service_provider_id"].ToString()));

                    allQuotations.Add(quotation);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return allQuotations;
        }



        public static Quotation addQuotation(Quotation newQuotation)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from quotations";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                //check if quotation already exists
                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["quotation_id"];
                ds.Tables[0].PrimaryKey = col;
                if (ds.Tables[0].Rows.Find(newQuotation.QuotationId) != null)
                {
                    return updateQuotation(newQuotation);
                }



                DataRow newrow = ds.Tables[0].NewRow();

                newrow["quotation_id"] = newQuotation.QuotationId;
                newrow["acceptance_status"] = newQuotation.AcceptanceStatus;
                newrow["final_price"] = newQuotation.FinalPrice;
                newrow["response"] = newQuotation.RequestId;
                newrow["request_id"] = newQuotation.RequestId.RequestId;
                newrow["service_provider_id"] = newQuotation.ServiceProviderId.UserId;

                ds.Tables[0].Rows.Add(newrow);
                da.Update(ds);

                return newQuotation;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }


    }
}
