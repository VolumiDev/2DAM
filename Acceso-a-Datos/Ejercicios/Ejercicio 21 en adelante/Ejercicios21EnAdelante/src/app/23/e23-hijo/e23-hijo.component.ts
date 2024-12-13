import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Alumno } from '../Alumno.interface';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'e23-hijo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './e23-hijo.component.html',
  styleUrl: './e23-hijo.component.css'
})
export class E23HijoComponent {

  mayorEdad: string = "";
  
  @Input()
  alumnoRecibido!: Alumno
  @Input()
  activo: boolean = false;

  @Output()
  notificacion = new EventEmitter<string>();

  tituloBoton: string = 'comprobar'

  mandarNotificacion(){
    if (this.alumnoRecibido?.edad < 18){
      this.mayorEdad = 'Es menor de edad';
    } else {
      this.mayorEdad = 'Es mayor de edad';
    }
    this.notificacion.emit(this.mayorEdad)
    console.log(this.mayorEdad)
  }

}
