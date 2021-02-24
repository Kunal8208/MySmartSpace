import { Order } from "./Order.model";


export class Payment{
    constructor(
        public PaymentId:number,
        public OrderId:Order,
        public PaymentDate:Date,
        public PaymentAmount:number,
        
        
        )
{
}
}