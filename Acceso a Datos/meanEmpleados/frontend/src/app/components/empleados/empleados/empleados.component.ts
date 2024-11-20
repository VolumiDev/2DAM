import { Component, NgModule } from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms';

//PARA EL TRATAMIENTO DE FORMULARIOS
//IMPORTAMOS EL SERVICIO DE EMPLEADO
import { EmpleadosService } from '../../../services/empleados.service';
//IMPORTAMOS EL MODEL DE EMPLEADO
import { Empleado } from '../../../models/empleado';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-empleados',
  standalone: true,
  providers: [EmpleadosService],
  imports: [FormsModule,
    CommonModule
  ],
  templateUrl: './empleados.component.html',
  styleUrl: './empleados.component.css'
})
export class EmpleadosComponent {

  constructor(public EmpleadosService: EmpleadosService){}

  addEmpleado(form: NgForm):void{
    //vamos a enviar desde el formulario todo el objeto con id inicluido y tendremos que comporbar en add empleado si reciibe un id estariamos actualizando
    //y si no contiene id llamariamos a add empleado, pero ese nuevo empleado que creamos, tenemos que enviarlo al sesrvicio crear empleado sin el ID
    if(form.value._id){
      this.EmpleadosService.actualizarEmpleado(form.value)
        .subscribe(resp => [
          console.log(resp)
        ])
        this.obtenerEmpleados();
    }else{
      const empleadoSinId = {... form.value};
      delete empleadoSinId._id;

      this.EmpleadosService.crearEmpleado(empleadoSinId)
      .subscribe(res => {
        console.log(res)
      });
      console.log(form.value);
      this.obtenerEmpleados();
    }
    this.obtenerEmpleados();
    this.resetForm(form);
  }

  resetForm(form: NgForm):void{
    form.reset()
  }

  obtenerEmpleados(){
    this.EmpleadosService.mostrarEmpleados().subscribe(res => {
      this.EmpleadosService.empleados = res as Empleado[];
      console.log(res)
    })
  }


  editarEmpleado(empleado: Empleado):void{
    this.EmpleadosService.empleadoSeleccionado = empleado
  }


  borrarEmpleado(empleado: Empleado): void{
    if(confirm("Esta seguro que deseas eliminar el empleado?")){
      this.EmpleadosService.eliminarEmpleado(empleado._id)
    }
  }

  ngOnInit():void{
    this.obtenerEmpleados();
  }

}
