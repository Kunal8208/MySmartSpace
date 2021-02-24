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
    public class OrdersController : ApiController
    {

        // GET: api/Orders/5
        public Order Get(int id)
        {
            return OrdersBusiness.getOrderById(id);
        }

        // POST: api/Orders
        public Order Post([FromBody]Order newOrder)
        {
            return OrdersBusiness.addOrder(newOrder);
        }

    }
}
