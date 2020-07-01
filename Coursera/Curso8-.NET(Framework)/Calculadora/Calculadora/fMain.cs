using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculadora
{
    public partial class fMain : Form
    {
        private decimal _Operand;
        private string _OperandTxt;

        public fMain()
        {
            InitializeComponent();
        }

        private void setOperandTxt (string value)
        {
            _OperandTxt = _OperandTxt + value;
            txtResult.Text = _OperandTxt;
        }

        private void btnNumber0_Click(object sender, EventArgs e)
        {
            setOperandTxt("0");
        }

        private void btnNumber1_Click(object sender, EventArgs e)
        {
            setOperandTxt("1");
        }

        private void btnNumber2_Click(object sender, EventArgs e)
        {
            setOperandTxt("2");
        }

        private void btnNumber3_Click(object sender, EventArgs e)
        {
            setOperandTxt("3");
        }

        private void btnNumber4_Click(object sender, EventArgs e)
        {
            setOperandTxt("4");
        }

        private void btnNumber5_Click(object sender, EventArgs e)
        {
            setOperandTxt("5");
        }

        private void btnNumber6_Click(object sender, EventArgs e)
        {
            setOperandTxt("6");
        }

        private void btnNumber7_Click(object sender, EventArgs e)
        {
            setOperandTxt("7");
        }

        private void btnNumber8_Click(object sender, EventArgs e)
        {
            setOperandTxt("8");
        }

        private void btnNumber9_Click(object sender, EventArgs e)
        {
            setOperandTxt("9");
        }

        private void buttonEquals_Click(object sender, EventArgs e)
        {
            
        }

        private void fMain_Load(object sender, EventArgs e)
        {

        }

        private void txtResult_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnPlus_Click(object sender, EventArgs e)
        {

        }

        private void btnMinus_Click(object sender, EventArgs e)
        {

        }

        private void fMain_KeyPress(object sender, KeyPressEventArgs e)
        {
            char keyPressed = e.KeyChar;
            setOperandTxt(keyPressed.ToString());
        }
    }
}
