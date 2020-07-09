set SERVEROUTPUT ON;

DECLARE
    nota number;

BEGIN
    nota := 50;
    
    IF (nota BETWEEN 67 and 69) THEN 
        nota := 70;    
    END IF;
    
    dbms_output.put_line('Nota: ' || nota);
    
    IF (nota >= 70) THEN
        dbms_output.put_line('APROBADO');
    ELSE
        dbms_output.put_line('REPROBADO');
    END IF;

END;
/
