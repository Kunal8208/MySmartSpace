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
    public class ProductscategoryController : ApiController
    {
        // GET: api/Productscategory/
        public IEnumerable<string> Get()
        {
            return ProductsBusiness.getAllCategories();
        }


        // GET: api/Productscategory/5
        public IEnumerable<Product> Get(int id)
        {
            return ProductsBusiness.findByCategory(id);
        }

    }
}
