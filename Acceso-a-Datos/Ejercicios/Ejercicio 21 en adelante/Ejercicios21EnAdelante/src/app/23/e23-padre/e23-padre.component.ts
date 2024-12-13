import { Component } from '@angular/core';
import { Alumno } from '../Alumno.interface';
import { E23HijoComponent } from "../e23-hijo/e23-hijo.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'e23-padre',
  standalone: true,
  imports: [E23HijoComponent, CommonModule],
  templateUrl: './e23-padre.component.html',
  styleUrl: './e23-padre.component.css'
})
export class E23PadreComponent {
  alumno!: Alumno 
  activo: boolean = false;
  mensaje: string ="";

  recibeNotificacion(mensaje: string){
    this.mensaje = mensaje;
  }

  iniciaAlumno(){
    this.alumno = {
      nombre: 'Diego',
      edad: 35
    }
    this.activo = true
  }
}
