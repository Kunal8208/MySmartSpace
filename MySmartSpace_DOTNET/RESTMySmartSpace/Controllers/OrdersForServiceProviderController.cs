﻿using System;
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
    public class OrdersForServiceProviderController : ApiController
    {
        // GET: api/OrdersForServiceProvider/5
        public IEnumerable<Order> Get(int id)
        {
            return OrdersBusiness.getOrderByServiceProviderId(id);
        }

    }
}
