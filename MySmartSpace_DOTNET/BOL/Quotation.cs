using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOL
{
    public class Quotation
    {
        public int QuotationId { get; set; }
        public NewRequest RequestId { get; set; }
        public User ServiceProviderId { get; set; }
        public double FinalPrice { get; set; }
        public string Response { get; set; }
        public int AcceptanceStatus { get; set; } // 0-New, 1-Accepted, 2-Rejected
    }
}
