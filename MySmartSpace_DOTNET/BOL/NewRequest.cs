using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOL
{
    public class NewRequest
    {
        public int RequestId { get; set; }
        public User UserId { get; set; }
        public string RequestDate { get; set; }
        public ProductCategory Category { get; set; }
        public string Dimension { get; set; }
        public double Weight { get; set; }
        public string Controller { get; set; }
        public string Sensor { get; set; }
        public string BuildType { get; set; }
        public string MotorType { get; set; }
        public string WiringType { get; set; }
        public string PowerSupplyUnit { get; set; }
        public string BluetoothEnabled { get; set; }
        public bool InternetControlled { get; set; }
        public string CameraEquipped { get; set; }
        public string PhysicalRemote { get; set; }
        public string Note { get; set; }
        public bool IsValid { get; set; }
    }
}
