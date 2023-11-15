use empleados;
select e.*, d.nombre_departamento from empleados e inner join departamentos d on e.id_departamento = d.id_departamento where exists (select d2.id_departamento from departamentos d2 where d2.nombre_departamento = 'Ventas' and d2.id_departamento = d.id_departamento);

select e.*, d.nombre_departamento, dir.* from empleados e inner join departamentos d on e.id_departamento = d.id_departamento inner join empleados dir on e.id_director = dir.id_empleado where d.nombre_departamento = 'Ventas';
describe empleados;
select * from empleados;
