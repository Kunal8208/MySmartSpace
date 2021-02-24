using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOL
{
    public class Order
    {
        public int OrderId { get; set; }
        public User CustomerId { get; set; }
        public Product ProductId { get; set; }
        public User ServiceProviderId { get; set; }
        public int Quantity { get; set; }
        public double TotalAmount { get; set; }
        public OrderStatus OrderStatus { get; set; }
        public bool PaymentStatus { get; set; }
        public string OrderDate { get; set; }
        public String Note { get; set; }
    }
}
