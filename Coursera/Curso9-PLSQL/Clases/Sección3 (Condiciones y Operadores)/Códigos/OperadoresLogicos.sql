set SERVEROUTPUT ON;

DECLARE
    A number;
    B number;
    
    nombre1 nvarchar2(100);
    nombre2 nvarchar2(100);

BEGIN
    A := 5;
    B := 10;
    nombre1 := 'David';
    
    /*
    IF(A <> B) THEN
        dbms_output.put_line('Adiferente de B');
    END IF;
    */
    
    /*
    IF(nombre1 like 'F%') THEN
        dbms_output.put_line('El nombre contiene F');
    ELSIF(nombre1 like '%avi%') THEN
        dbms_output.put_line('El nombre contiene avi');
    END IF;
    */
    
    /*
    IF(A BETWEEN 5 and 10) THEN
        dbms_output.put_line('A entre 6 y 10');
    END IF;
    */
    
    /*
    IF(B in (5,10,6,8,15)) THEN
        dbms_output.put_line('B en grupo de elementos');
    END IF;
    */
    
    IF(nombre2 is null) THEN
        dbms_output.put_line('El nombre2 es nulo');
    END IF;
END;
/