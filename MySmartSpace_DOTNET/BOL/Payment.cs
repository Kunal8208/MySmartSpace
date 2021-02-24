using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOL
{
    public class Payment
    {
        public string PaymentId { get; set; }
        public Order OrderId { get; set; }
        public string PaymentDate { get; set; }
        public double PaymentAmount { get; set; }

    }
}
