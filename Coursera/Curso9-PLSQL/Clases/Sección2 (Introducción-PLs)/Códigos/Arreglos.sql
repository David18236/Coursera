set SERVEROUTPUT ON;

DECLARE
    --Definición de los arreglos
    type alumnosArray is varray(5) of nvarchar2(100);
    type notasArray is varray(5) of number;

    --Utilización de arreglos
    alumnos alumnosArray;
    notas notasArray;
    
BEGIN
    alumnos := alumnosArray('Fernando', 'Melissa', 'Andrea', 'Antonio', 'Clarissa');
    notas := notasArray(90, 100, 95, 89, 75);
    
    dbms_output.put_line(alumnos(1));
    dbms_output.put_line(notas(1));
    
    notas(1) := 95;
    dbms_output.put_line(notas(1));
END;
/
