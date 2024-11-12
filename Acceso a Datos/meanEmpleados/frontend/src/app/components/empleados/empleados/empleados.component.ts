import { Component, NgModule } from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms';

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

  constructor(public EmpleadosService: EmpleadosService){}

  addEmpleado(form: NgForm):void{
    this.EmpleadosService.crearEmpleado(form.value)
      .subscribe(res => {
        console.log(res)
      });
      console.log(form.value);
    
  }

  resetForm(form: NgForm):void{
    form.reset()
  }


}
