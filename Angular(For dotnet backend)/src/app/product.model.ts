import { User } from "./User.model";

export class Product{
    constructor(
        public ProductId:number,
        public ServiceProviderId:User,
        public Category:string,
        public Dimension:string,
        public Weight:number,
        public Controller:string,
        public Sensor:string,
        public BluetoothEnabled:string,
        public InternetControlled:boolean,
        public PhysicalRemote:string,
        public CameraEquipped:string,
        public MotorType:string,
        public PowerSupplyUnit:string,
        public WiringType:string,
        public BuildType:string,
        public Rating:number,
        public ImageUrl:string,
        public FinalPrice:number,
        public Description:string,
        public QuantitySold:number
        )
{
}
}