import { User } from "./User.model";

export class NewRequest{
    constructor(
        public RequestId:number,
        public UserId:User,
        public RequestDate:Date,
        public Category:string,
        public Dimension:string,
        public Weight:number,
        public Controller:string,
        public Sensor:string,
        public BuildType:string,
        public MotorType:string,
        public WiringType:string,
        public PowerSupplyUnit:string,
        public BluetoothEnabled:string,
        public InternetControlled:boolean,
        public CameraEquipped:string,
        public PhysicalRemote:string,
        public Note:string,
        public IsValid:boolean,
    ){}
}