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
    public class NewrequestController : ApiController
    {
        

        // GET: api/Newrequest/5
        public NewRequest Get(int id)
        {
            return NewRequestBusiness.getRequestById(id);
        }

        // POST: api/Newrequest
        public NewRequest Post([FromBody]NewRequest newRequest)
        {
            return NewRequestBusiness.addNewRequest(newRequest);
        }

       
    }
}
