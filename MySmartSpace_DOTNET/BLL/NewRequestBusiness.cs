using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BOL;
using DAL;

namespace BLL
{
    public class NewRequestBusiness
    {
        public static NewRequest addNewRequest(NewRequest newRequest)
        {
            return NewRequestDBManager.addNewRequest(newRequest);
        }

        public static List<NewRequest> getAllRequests()
        {
            return NewRequestDBManager.getAllRequests();
        }

        public static List<NewRequest> getRequestsByUserId(int userId)
        {
            return NewRequestDBManager.getRequestsByUserId(userId);
        }

        public static NewRequest getRequestById(int requestId)
        {
            return NewRequestDBManager.getRequestById(requestId);
        }

        public static List<NewRequest> getNewRequestsForServiceProvider(int serviceProviderId)
        {
            return NewRequestDBManager.getNewRequestsForServiceProvider(serviceProviderId);
        }
    }
}
