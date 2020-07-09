set SERVEROUTPUT ON;

DECLARE
    --Declaración de variables
    salarioBase number;
    aumento number;
    salarioNeto number;

BEGIN
    --Inicialización de variables
    salarioBase := 100;
    
    --Condiciones
    CASE
        WHEN(salarioBase <= 600) THEN
            aumento := salarioBase * 0.15;
        WHEN(salarioBase BETWEEN 601 AND 950) THEN
            aumento := salarioBase * 0.135;
        WHEN(salarioBase BETWEEN 951 AND 1400) THEN
            aumento := salarioBase * 0.1;
        ELSE
            aumento := salarioBase * 0.05;
    END CASE;
    
    --Cálculo del nuevo salario neto
    salarioNeto := salarioBase + aumento;
    
    dbms_output.put_line( 'Salario base:  $' || salarioBase );
    dbms_output.put_line( 'Aumento:       $' || aumento );
    dbms_output.put_line( 'Nuevo Salario: $' || salarioNeto );
END;
/