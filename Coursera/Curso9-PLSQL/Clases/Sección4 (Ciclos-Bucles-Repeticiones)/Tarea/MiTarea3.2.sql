set serveroutput on;

DECLARE
 numero number;
 factorial number;
 
BEGIN
    numero := 2;
    factorial := numero;
    
    WHILE (numero > 1) LOOP
        numero := numero - 1;
        factorial := factorial * numero;
        
    END LOOP;

    dbms_output.put_line( factorial );

END;
/