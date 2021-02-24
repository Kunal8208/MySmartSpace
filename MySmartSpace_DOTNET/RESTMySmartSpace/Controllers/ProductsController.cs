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
    public class ProductsController : ApiController
    {
        // GET: api/Products
        public IEnumerable<Product> Get()
        {
            return ProductsBusiness.GetAllProducts();
        }

        // GET: api/Products/5
        public Product Get(int id)
        {
            return ProductsBusiness.findById(id);
        }

    

        // POST: api/Products
        public Product Post([FromBody]Product newProduct)
        {
            return ProductsBusiness.addProduct(newProduct);
        }

        // PUT: api/Products/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Products/5
        public void Delete(int id)
        {
        }
    }
}
