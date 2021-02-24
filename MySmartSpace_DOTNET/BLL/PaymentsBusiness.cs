using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BOL;
using DAL;

namespace BLL
{
    public class PaymentsBusiness
    {
        public static Payment addPayment(Payment newPayment)
        {
            return PaymentsDBManager.addPayment(newPayment);
        }
    }
}
