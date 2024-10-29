import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
//PARA EL TRATAMIENTO DE FORMULARIOS
import { NgForm } from '@angular/forms';  
//IMPORTAMOS EL SERVICIO DE EMPLEADO
import { EmpleadosService } from '../../../services/empleados.service';
//IMPORTAMOS EL MODEL DE EMPLEADO
import { Empleado } from '../../../models/empleado';

@Component({
  selector: 'app-empleados',
  standalone: true,
  imports: [ FormsModule],
  templateUrl: './empleados.component.html',
  styleUrl: './empleados.component.css'
})
export class EmpleadosComponent {

  addEmployee(){}
}
