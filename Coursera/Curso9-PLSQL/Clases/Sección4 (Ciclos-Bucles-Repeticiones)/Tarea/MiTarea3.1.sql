set SERVEROUTPUT ON;

DECLARE
    --Declaración de variables
    type notasArray is varray(4) of number;
    notas notasArray := notasArray(95,60,75,85);
    
    suma number;
    promedio number(6,2);

BEGIN
    suma := 0;

    <<Ciclo_Operador>>
    FOR i in 1..4 LOOP        
        suma := suma + notas(i);
        
    END LOOP Ciclo_Operador;

    promedio := suma / 4;
    
    dbms_output.put_line( 'El promedio de las notas es: ' || promedio );
END;
/
