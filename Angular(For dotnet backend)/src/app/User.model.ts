export class User{
    constructor(
        public UserId:number,
        public FirstName:String,
        public LastName:String,
        public Email:String,
        public Password:String,
        public Role:number,
        public CompanyName:String,
        public ContactNumber:String,
        public Address:String
    ){}
}