import { Component, NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

//PARA EL TRATAMIENTO DE FORMULARIOS
//IMPORTAMOS EL SERVICIO DE EMPLEADO
import { EmpleadosService } from '../../../services/empleados.service';
//IMPORTAMOS EL MODEL DE EMPLEADO
import { Empleado } from '../../../models/empleado';

@Component({
  selector: 'app-empleados',
  standalone: true,
  providers: [EmpleadosService],
  imports: [FormsModule],
  templateUrl: './empleados.component.html',
  styleUrl: './empleados.component.css'
})
export class EmpleadosComponent {

  constructor(public EmpleadosService:EmpleadosService){}

  addEmployee(){}
}
