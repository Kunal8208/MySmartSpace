using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http.Cors;
using System.Web.Http;
using BOL;
using BLL;

namespace RESTMySmartSpace.Controllers
{
    [EnableCors(origins: "http://localhost:4200", headers: "*", methods: "*")]
    public class ProductsForServiceProviderController : ApiController
    {

        // GET: api/ProductsForServiceProvider/5
        public IEnumerable<Product> Get(int id)
        {
            return ProductsBusiness.findByServiceProviderId(id);
        }

    }
}
