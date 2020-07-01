using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args) 
        {
            ConsoleColor colorDeLaConsola = ConsoleColor.Red;

            colorDeLaConsola = ConsoleColor.DarkMagenta;

            String textoBienvenida = "Hola Mundo";
            String otroString = " David";

            Console.BackgroundColor = colorDeLaConsola;
            Console.WriteLine(textoBienvenida + otroString);
            Console.ReadLine();
        }
    }
}