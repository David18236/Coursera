set SERVEROUTPUT ON;

DECLARE
    producto number;

BEGIN
    
    <<ciclo_tabla>>
    FOR i in 1..10 LOOP
        producto := i * 2;
        
        --Forma 1 
        --dbms_output.put_line(i || '* 2 = ' || producto);
        
        --Forma 2
        dbms_output.put(i);
        dbms_output.put(' * 2 = ');        
        dbms_output.put_line(producto);        
        
    END LOOP ciclo_tabla;

END;
/