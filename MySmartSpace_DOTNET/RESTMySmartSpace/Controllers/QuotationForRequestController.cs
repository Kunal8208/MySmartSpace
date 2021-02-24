using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using BOL;
using System.Web.Http.Cors;
using BLL;

namespace RESTMySmartSpace.Controllers
{
    [EnableCors(origins: "http://localhost:4200", headers: "*", methods: "*")]
    public class QuotationForRequestController : ApiController
    {
        

        // GET: api/QuotationForRequest/5
        public IEnumerable<Quotation> Get(int id)
        {
            //id = Request ID
            return QuotationBusiness.getQuotationsByRequestId(id);
        }

    }
}
