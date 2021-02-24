using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BOL;
using DAL;

namespace BLL
{
    public class QuotationBusiness
    {

        public static Quotation getQuotationById(int quotationId)
        {
            return QuotationDBManager.getQuotationById(quotationId);
        }

        public static List<Quotation> getQuotationsByRequestId(int newRequestId)
        {
            return QuotationDBManager.getQuotationsByRequestId(newRequestId);
        }

        public static Quotation addQuotation(Quotation newQuotation)
        {
            return QuotationDBManager.addQuotation(newQuotation);
        }


        public static Quotation rejectQuotation(int quotationId)
        {
            Quotation quotation = QuotationDBManager.getQuotationById(quotationId);
            quotation.AcceptanceStatus = 2;
            updateQuotation(quotation);

            NewRequest request = quotation.RequestId;
            List<Quotation> list = getQuotationsByRequestId(request.RequestId);

            foreach(Quotation quot in list)
            {
                //if any of the quotations is still new, then dont update the request status
                if (quot.AcceptanceStatus != 2)
                    return quotation;
            }

            //all quotations are rejected. So, set request as invalid
            request.IsValid = false;
            NewRequestDBManager.updateRequest(request);
            return null;
        }



        public static Quotation acceptQuotation(int quotationId)
        {
            Quotation quotation = getQuotationById(quotationId);
            quotation.AcceptanceStatus = 1;
            updateQuotation(quotation);

            NewRequest request = quotation.RequestId;
            request.IsValid = false;
            NewRequestDBManager.updateRequest(request);

            List<Quotation> list = getQuotationsByRequestId(request.RequestId);
            foreach(Quotation quot in list)
            {
                if(quot.QuotationId != quotationId)
                {
                    quot.AcceptanceStatus = 2;
                    updateQuotation(quot);
                }
            }
            return quotation;
        }


        public static Quotation updateQuotation(Quotation existingQuotation)
        {
            return QuotationDBManager.updateQuotation(existingQuotation);
        }

        public static List<Quotation> getQuotationsByServiceProviderId(int serviceProviderId)
        {
            return QuotationDBManager.getQuotationsByServiceProviderId(serviceProviderId);
        }
    }
}
