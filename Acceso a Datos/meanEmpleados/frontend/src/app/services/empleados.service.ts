import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Empleado } from '../models/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  empleadoSeleccionado: Empleado;

  readonly URL = 'http://localhost:3000/api/empleados/';
  constructor(private http: HttpClient) {
    this.empleadoSeleccionado = new Empleado();
   }

   mostrarEmpleados(){
    return this.http.get(this.URL) //hace la peticion get y retorna el array de empleados
   }

   mostrarEmpleado(id: string){
    return this.http.get(this.URL + id);
   }
   crearEmpleado(empleado: Empleado){
    return this.http.post(this.URL, empleado); //hace una peticion post con el empleado que le pasamos para hacer la insercion
   }

   actualizarEmpleado(empleado: Empleado){
    return this.http.put(this.URL+ empleado._id, empleado);//relaiza una peticion put para actualizar datos
   }

   eliminarEmpleado(id: string){
    return this.http.delete(this.URL+id);
   }
}
