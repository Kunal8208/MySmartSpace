using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BOL;
using DAL;

namespace BLL
{
    public class UserBusiness
    {
        public static List<User> getAllUsers()
        {
            return UsersDBManager.getAllUsers();
        }

        public static User getUserById(int userId)
        {
            return UsersDBManager.getUserById(userId);
        }

        public static User addUser(User newUser)
        {
            return UsersDBManager.addUser(newUser);
        }

        public static User validateUser(Login credentials)
        {
            return UsersDBManager.validateUser(credentials);
        }

        public static List<User> getUsersByRole(int roleId)
        {
            return UsersDBManager.getUsersByRole(roleId);
        }

        public static int removeUser(int existingUserId)
        {
            return UsersDBManager.removeUser(existingUserId);
        }

        public static User getUserByEmailId(string emailId)
        {
            return UsersDBManager.getUserByEmailId(emailId);
        }
    }
}
