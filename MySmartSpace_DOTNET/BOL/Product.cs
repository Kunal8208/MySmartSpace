using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BOL
{
    public class Product
    {
        public int ProductId { get; set; }
        public User ServiceProviderId { get; set; }
        public ProductCategory Category { get; set; }
        public String Dimension { get; set; }
        public double Weight { get; set; }
        public String Controller { get; set; }
        public String Sensor { get; set; }
        public String BluetoothEnabled { get; set; }
        public bool InternetControlled { get; set; }
        public String PhysicalRemote { get; set; }
        public String CameraEquipped { get; set; }
        public String MotorType { get; set; }
        public String PowerSupplyUnit { get; set; }
        public String WiringType { get; set; }
        public String BuildType { get; set; }
        public double Rating { get; set; }
        public String ImageUrl { get; set; }
        public double FinalPrice { get; set; }
        public String Description { get; set; }
        public int QuantitySold { get; set; }

    }
}
