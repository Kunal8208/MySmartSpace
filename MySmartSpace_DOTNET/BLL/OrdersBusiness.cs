using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BOL;
using DAL;


namespace BLL
{
    public class OrdersBusiness
    {
        public static Order getOrderById(int orderId)
        {
            return OrdersDBManager.getOrderById(orderId);
        }

        public static List<Order> getOrderByCustomerId(int customerId)
        {
            return OrdersDBManager.getOrdersByCustomerId(customerId);
        }


        public static Order addOrder(Order newOrder)
        {
            return OrdersDBManager.addOrder(newOrder);
        }

        public static List<Order> getOrderByServiceProviderId(int serviceProviderId)
        {
            return OrdersDBManager.getOrdersByServiceProviderId(serviceProviderId);
        }

        public static Order updatePaymentStatus(int orderId)
        {
            Order order = OrdersDBManager.getOrderById(orderId);
            order.PaymentStatus = true;
            Order savedOrder = OrdersDBManager.updateOrder(order);
            return savedOrder;
        }
    }
}
