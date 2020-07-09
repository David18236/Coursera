set SERVEROUTPUT ON;

DECLARE
    --Declaración de constantes
    nroCamisetas number;
    monto number;
    
    --Declaración de variables iniciales
    subTotal number;
    impuesto number;
    valorTotal number;

BEGIN   
    --Inicializar variables
    nroCamisetas := 5;
    monto := 19.99;
    
    --Calcular subtotal a pagar
    subTotal :=  nroCamisetas * monto;
    
    --Calcular el impuesto sobre las ventas
    impuesto := subTotal * 0.15;
    
    --Clacular el valor total a pagar
    valorTotal := subTotal + impuesto;
    
    --Mostrar resultados
    dbms_output.put_line('Número de camisetas: ' || nroCamisetas);
    dbms_output.put_line('Valor unidad: $' || monto);
    dbms_output.put_line('');
    dbms_output.put_line('Subtotal: $' || subTotal);
    dbms_output.put_line('impuesto: $' || impuesto);
    dbms_output.put_line('Valor total: $' || valorTotal);
END;
/