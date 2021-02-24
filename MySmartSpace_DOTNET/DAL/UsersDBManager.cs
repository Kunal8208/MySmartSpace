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
    public class UsersDBManager
    {
        static string conString = string.Empty;

        static UsersDBManager()
        {
            conString = ConfigurationManager.ConnectionStrings["DBConnection"].ConnectionString;
        }


        public static List<User> getAllUsers()
        {
            List<User> allUsers = new List<User>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from users";
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
                    User user = new User();

                    user.UserId = int.Parse(row["user_id"].ToString());
                    user.Address = row["address"].ToString();
                    user.CompanyName = row["company_name"].ToString();
                    user.ContactNumber = row["contact_number"].ToString();
                    user.Email = row["email"].ToString();
                    user.FirstName = row["first_name"].ToString();
                    user.LastName = row["last_name"].ToString();
                    user.Password = row["password"].ToString();
                    user.Role = (UserRole)Enum.Parse(typeof(UserRole), row["role"].ToString());

                    allUsers.Add(user);
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return allUsers;
        }



        public static User validateUser(Login credentials)
        {
            User user = new User();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from users where email=@emailid and password=@pass";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("emailid", credentials.Email));
            cmd.Parameters.Add(new MySqlParameter("pass", credentials.Password));
            cmd.Connection = con;
            DataSet ds = new DataSet();

            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                if(ds.Tables[0].Rows.Count > 0)
                {
                    DataRow row = ds.Tables[0].Rows[0];
                    user.UserId = int.Parse(row["user_id"].ToString());
                    user.Address = row["address"].ToString();
                    user.CompanyName = row["company_name"].ToString();
                    user.ContactNumber = row["contact_number"].ToString();
                    user.Email = row["email"].ToString();
                    user.FirstName = row["first_name"].ToString();
                    user.LastName = row["last_name"].ToString();
                    user.Password = row["password"].ToString();
                    user.Role = (UserRole) Enum.Parse(typeof(UserRole), row["role"].ToString());

                    return user;
                }
                
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }


        public static User getUserById(int userId)
        {
            User user = new User();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from users";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["user_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(userId);
                if (row != null)
                {
                    user.UserId = int.Parse(row["user_id"].ToString());
                    user.Address = row["address"].ToString();
                    user.CompanyName = row["company_name"].ToString();
                    user.ContactNumber = row["contact_number"].ToString();
                    user.Email = row["email"].ToString();
                    user.FirstName = row["first_name"].ToString();
                    user.LastName = row["last_name"].ToString();
                    user.Password = row["password"].ToString();
                    user.Role = (UserRole)Enum.Parse(typeof(UserRole), row["role"].ToString());

                    return user;
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }




        public static User getUserByEmailId(string emailId)
        {
            User user = new User();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from users";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["email"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(emailId);
                if (row != null)
                {
                    user.UserId = int.Parse(row["user_id"].ToString());
                    user.Address = row["address"].ToString();
                    user.CompanyName = row["company_name"].ToString();
                    user.ContactNumber = row["contact_number"].ToString();
                    user.Email = row["email"].ToString();
                    user.FirstName = row["first_name"].ToString();
                    user.LastName = row["last_name"].ToString();
                    user.Password = row["password"].ToString();
                    user.Role = (UserRole)Enum.Parse(typeof(UserRole), row["role"].ToString());
                }
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return user;
        }

        public static List<User> getUsersByRole(int roleId)
        {
            List<User> allUsersByRole = new List<User>();
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from users where role=@role";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Parameters.Add(new MySqlParameter("role", Enum.GetName(typeof(UserRole), roleId)));
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                da.Fill(ds);

                DataRowCollection rows = ds.Tables[0].Rows;
                foreach(DataRow row in rows)
                {
                    User user = new User();

                    user.UserId = int.Parse(row["user_id"].ToString());
                    user.Address = row["address"].ToString();
                    user.CompanyName = row["company_name"].ToString();
                    user.ContactNumber = row["contact_number"].ToString();
                    user.Email = row["email"].ToString();
                    user.FirstName = row["first_name"].ToString();
                    user.LastName = row["last_name"].ToString();
                    user.Password = row["password"].ToString();
                    user.Role = (UserRole)Enum.Parse(typeof(UserRole), row["role"].ToString());

                    allUsersByRole.Add(user);
                }

                return allUsersByRole;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }


        public static User addUser(User newUser)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from users";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataRow newrow = ds.Tables[0].NewRow();

                newrow["user_id"] = newUser.UserId;
                newrow["address"] = newUser.Address;
                newrow["company_name"] = newUser.CompanyName;
                newrow["contact_number"] = newUser.ContactNumber;
                newrow["email"] = newUser.Email;
                newrow["first_name"] = newUser.FirstName;
                newrow["last_name"] = newUser.LastName;
                newrow["password"] = newUser.Password;
                newrow["role"] = newUser.Role;
                

                ds.Tables[0].Rows.Add(newrow);
                da.Update(ds);

                return newUser;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return null;
        }


        public static int removeUser(int existingUserId)
        {
            MySqlConnection con = new MySqlConnection(conString);
            string query = "Select * from users";
            MySqlCommand cmd = new MySqlCommand(query);
            cmd.Connection = con;
            DataSet ds = new DataSet();
            try
            {
                MySqlDataAdapter da = new MySqlDataAdapter(cmd as MySqlCommand);
                MySqlCommandBuilder bldr = new MySqlCommandBuilder(da);
                da.Fill(ds);

                DataColumn[] col = new DataColumn[1];
                col[0] = ds.Tables[0].Columns["user_id"];
                ds.Tables[0].PrimaryKey = col;

                DataRow row = ds.Tables[0].Rows.Find(existingUserId);

                row.Delete();

                da.Update(ds);

                return existingUserId;
            }
            catch (MySqlException e)
            {
                Console.WriteLine(e.Message);
            }
            return 0;
        }
    }
}
