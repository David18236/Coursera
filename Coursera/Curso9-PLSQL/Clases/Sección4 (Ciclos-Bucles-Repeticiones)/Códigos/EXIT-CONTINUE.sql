set SERVEROUTPUT ON;

DECLARE
    producto number;

BEGIN
    
    <<ciclo_tabla>>
    FOR i in 1..10 LOOP
        producto := i * 2;
        
        --Salirse del ciclo seg�n una condisi�n
        /*IF (i = 5) THEN
            exit;
        END IF;*/
        
        --Saltar seg�n la condici�n dada y seguir con las dem�s instrucciones
        IF (i = 5) THEN
            continue;
        END IF;
        
        IF (mod(i, 2) <> 0) THEN
            continue;
        END IF;
        
        --Forma 1 
        --dbms_output.put_line(i || '* 2 = ' || producto);
        
        --Forma 2
        dbms_output.put(i);
        dbms_output.put(' * 2 = ');        
        dbms_output.put_line(producto);        
        
    END LOOP ciclo_tabla;

END;
/
