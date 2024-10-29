import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Empleado } from '../models/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  empleadoSeleccionado: Empleado;

  constructor(private http: HttpClient) {
    this.empleadoSeleccionado = new Empleado();
   }
}
