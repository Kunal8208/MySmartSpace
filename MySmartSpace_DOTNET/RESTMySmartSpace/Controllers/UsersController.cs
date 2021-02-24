using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Cors;
using BOL;
using BLL;


namespace RESTMySmartSpace.Controllers
{
    [EnableCors(origins: "http://localhost:4200", headers: "*", methods: "*")]
    public class UsersController : ApiController
    {
        // GET: api/Users
        public IEnumerable<User> Get()
        {
            return UserBusiness.getAllUsers();
        }

        // GET: api/Users/5
        public User Get(int id)
        {
            return UserBusiness.getUserById(id);
        }

        // POST: api/Users
        public User Post([FromBody]User newUser)
        {
            return UserBusiness.addUser(newUser);
        }

        // DELETE: api/Users/5
        public int Delete(int id)
        {
            return UserBusiness.removeUser(id);
        }
       
    }
}
