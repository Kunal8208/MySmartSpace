using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BOL;
using DAL;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            
            Console.WriteLine("Start");
            Console.WriteLine(ProductsDBManager.GetAllProducts());
            Console.ReadLine();
        }
    }
}
