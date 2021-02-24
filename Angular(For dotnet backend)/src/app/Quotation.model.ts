import { NewRequest } from "./newRequest.model";
import { User } from "./User.model";

export class Quotation{
    constructor(
        public QuotationId:number,
        public RequestId:NewRequest,
        public ServiceProviderId:User,
        public FinalPrice:number,
        public Response:String,
        public AcceptanceStatus:number
    ){}
}