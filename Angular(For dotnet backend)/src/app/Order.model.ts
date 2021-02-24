import { Product } from "./product.model";
import { User } from "./User.model";

export class Order{
    constructor(
        public OrderId:number,
        public CustomerId:User,
        public ProductId:Product,
        public ServiceProviderId:User,
        public Quantity:number,
        public TotalAmount:number,
        public OrderStatus:number,
        public PaymentStatus:boolean,
        public OrderDate:Date,
        public Note:string,
        
        )
{
}
}