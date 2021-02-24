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
    public class NewRequestDBManager
    {
        static string conString = string.Empty;

        static NewRequestDBManager()
        {
            conString = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        }


        public static List<NewRequest> getAllRequests()
        {
            List<NewRequest> allrequests = new List<NewRequest>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from new_request_table";
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
                    NewRequest request = new NewRequest();

                    request.RequestId = int.Parse(row["request_id"].ToString());
                    request.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    request.BuildType = row["build_type"].ToString();
                    request.CameraEquipped = row["camera_equipped"].ToString();
                    request.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    request.Controller = row["controller"].ToString();
                    request.Dimension = row["dimension"].ToString();
                    request.InternetControlled = row["internet_controlled"].ToString() == "1";
                    request.IsValid = row["is_valid"].ToString() == "1";
                    request.MotorType = row["motor_type"].ToString();
                    request.PhysicalRemote = row["physical_remote"].ToString();
                    request.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    request.Sensor = row["sensor"].ToString();
                    request.Weight = double.Parse(row["weight"].ToString());
                    request.WiringType = row["wiring_type"].ToString();
                    request.UserId = UsersDBManager.getUserById(int.Parse(row["user_id"].ToString()));
                    request.Note = row["note"].ToString();
                    request.RequestDate = row["request_date"].ToString();

                    allrequests.Add(request);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return allrequests;
        }


        public static NewRequest getRequestById(int requestId)
        {
            NewRequest request = new NewRequest();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from new_request_table";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["request_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(requestId);
                if (row != null)
                {
                    request.RequestId = int.Parse(row["request_id"].ToString());
                    request.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    request.BuildType = row["build_type"].ToString();
                    request.CameraEquipped = row["camera_equipped"].ToString();
                    request.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    request.Controller = row["controller"].ToString();
                    request.Dimension = row["dimension"].ToString();
                    request.InternetControlled = row["internet_controlled"].ToString() == "1";
                    request.IsValid = row["is_valid"].ToString() == "1";
                    request.MotorType = row["motor_type"].ToString();
                    request.PhysicalRemote = row["physical_remote"].ToString();
                    request.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    request.Sensor = row["sensor"].ToString();
                    request.Weight = double.Parse(row["weight"].ToString());
                    request.WiringType = row["wiring_type"].ToString();
                    request.UserId = UsersDBManager.getUserById(int.Parse(row["user_id"].ToString()));
                    request.Note = row["note"].ToString();
                    request.RequestDate = row["request_date"].ToString();

                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return request;
        }





        public static List<NewRequest> getRequestsByUserId(int userId)
        {
            List<NewRequest> requests = new List<NewRequest>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from new_request_table where user_id=@userid";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("userid", userId));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataRowCollection rows = ds.Tables[0].Rows;
                foreach (DataRow row in rows)
                {
                    NewRequest request = new NewRequest();
                    request.RequestId = int.Parse(row["request_id"].ToString());
                    request.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    request.BuildType = row["build_type"].ToString();
                    request.CameraEquipped = row["camera_equipped"].ToString();
                    request.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    request.Controller = row["controller"].ToString();
                    request.Dimension = row["dimension"].ToString();
                    request.InternetControlled = row["internet_controlled"].ToString() == "1";
                    request.IsValid = row["is_valid"].ToString() == "1";
                    request.MotorType = row["motor_type"].ToString();
                    request.PhysicalRemote = row["physical_remote"].ToString();
                    request.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    request.Sensor = row["sensor"].ToString();
                    request.Weight = double.Parse(row["weight"].ToString());
                    request.WiringType = row["wiring_type"].ToString();
                    request.UserId = UsersDBManager.getUserById(int.Parse(row["user_id"].ToString()));
                    request.Note = row["note"].ToString();
                    request.RequestDate = row["request_date"].ToString();


                    requests.Add(request);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return requests;
        }




        public static List<NewRequest> getRequestsByIsValid(bool isValid)
        {
            List<NewRequest> requests = new List<NewRequest>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from new_request_table where is_valid=@isValid";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("isValid", 1));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataRowCollection rows = ds.Tables[0].Rows;
                foreach (DataRow row in rows)
                {
                    NewRequest request = new NewRequest();
                    request.RequestId = int.Parse(row["request_id"].ToString());
                    request.BluetoothEnabled = row["bluetooth_enabled"].ToString();
                    request.BuildType = row["build_type"].ToString();
                    request.CameraEquipped = row["camera_equipped"].ToString();
                    request.Category = (ProductCategory)Enum.Parse(typeof(ProductCategory), row["category"].ToString());
                    request.Controller = row["controller"].ToString();
                    request.Dimension = row["dimension"].ToString();
                    request.InternetControlled = row["internet_controlled"].ToString() == "1";
                    request.IsValid = row["is_valid"].ToString() == "1";
                    request.MotorType = row["motor_type"].ToString();
                    request.PhysicalRemote = row["physical_remote"].ToString();
                    request.PowerSupplyUnit = row["power_supply_unit"].ToString();
                    request.Sensor = row["sensor"].ToString();
                    request.Weight = double.Parse(row["weight"].ToString());
                    request.WiringType = row["wiring_type"].ToString();
                    request.UserId = UsersDBManager.getUserById(int.Parse(row["user_id"].ToString()));
                    request.Note = row["note"].ToString();
                    request.RequestDate = row["request_date"].ToString();


                    requests.Add(request);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return requests;
        }




        public static NewRequest addNewRequest(NewRequest newRequest)
        {

            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from new_request_table";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["request_id"];
                ds.Tables[0].PrimaryKey = col;
                if(ds.Tables[0].Rows.Find(newRequest.RequestId) != null)
                {
                    return updateRequest(newRequest);
                }

                DataRow newrow = ds.Tables[0].NewRow();

                newrow["request_id"] = newRequest.RequestId;
                newrow["bluetooth_enabled"] = newRequest.BluetoothEnabled;
                newrow["build_type"] = newRequest.BuildType;
                newrow["camera_equipped"] = newRequest.CameraEquipped;
                newrow["category"] = newRequest.Category;
                newrow["controller"] = newRequest.Controller;
                newrow["dimension"] = newRequest.Dimension;
                newrow["internet_controlled"] = newRequest.InternetControlled;
                newrow["is_valid"] = newRequest.IsValid;
                newrow["motor_type"] = newRequest.MotorType;
                newrow["physical_remote"] = newRequest.PhysicalRemote;
                newrow["power_supply_unit"] = newRequest.PowerSupplyUnit;
                newrow["sensor"] = newRequest.Sensor;
                newrow["weight"] = newRequest.Weight;
                newrow["wiring_type"] = newRequest.WiringType;
                newrow["user_id"] = newRequest.UserId.UserId;
                newrow["note"] = newRequest.Note;
                newrow["request_date"] = newRequest.RequestDate;


                ds.Tables[0].Rows.Add(newrow);
                da.Update(ds);

                return newRequest;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }





        public static List<NewRequest> getNewRequestsForServiceProvider(int serviceProviderId)
        {
            List<NewRequest> newRequestsForParticularServiceProvider = new List<NewRequest>();
            List<NewRequest> allNewRequests = getRequestsByIsValid(true);

            foreach(NewRequest newRequest in allNewRequests){
                List<Quotation> allQuotationsForNewRequest = QuotationDBManager.getQuotationsByRequestId(newRequest.RequestId);
                bool isPresent = false;
                //check if quotation for this new Request is subitted by current service provider
                foreach(Quotation quotation in allQuotationsForNewRequest)
                {
                    if(quotation.ServiceProviderId.UserId== serviceProviderId)
                    {
                        isPresent = true;
                        break;
                    }
                }
                if (!isPresent)
                {
                    newRequestsForParticularServiceProvider.Add(newRequest);
                }
            }

            return newRequestsForParticularServiceProvider;
        }


        public static NewRequest updateRequest(NewRequest existingRequest)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from new_request_table";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["request_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(existingRequest.RequestId);

                row["request_id"] = existingRequest.RequestId;
                row["bluetooth_enabled"] = existingRequest.BluetoothEnabled;
                row["build_type"] = existingRequest.BuildType;
                row["camera_equipped"] = existingRequest.CameraEquipped;
                row["category"] = existingRequest.Category;
                row["controller"] = existingRequest.Controller;
                row["dimension"] = existingRequest.Dimension;
                row["internet_controlled"] = existingRequest.InternetControlled;
                row["is_valid"] = existingRequest.IsValid;
                row["motor_type"] = existingRequest.MotorType;
                row["physical_remote"] = existingRequest.PhysicalRemote;
                row["power_supply_unit"] = existingRequest.PowerSupplyUnit;
                row["sensor"] = existingRequest.Sensor;
                row["weight"] = existingRequest.Weight;
                row["wiring_type"] = existingRequest.WiringType;
                row["user_id"] = existingRequest.UserId.UserId;
                row["note"] = existingRequest.Note;
                row["request_date"] = existingRequest.RequestDate;

                da.Update(ds);

                return existingRequest;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }

    }
}
