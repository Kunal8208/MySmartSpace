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
    public class NewRequestWithoutQuotationsSentController : ApiController
    {

        // GET: api/NewRequestWithoutQuotationsSent/5
        public IEnumerable<NewRequest> Get(int id)
        {
            //id=service prov id
            return NewRequestBusiness.getNewRequestsForServiceProvider(id);
        }

    }
}
