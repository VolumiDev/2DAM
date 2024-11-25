import { Component } from '@angular/core';
import { E24C2Component } from "../e24-c2/e24-c2.component";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'e24-c1',
  standalone: true,
  imports: [E24C2Component, FormsModule, CommonModule],
  templateUrl: './e24-c1.component.html',
  styleUrl: './e24-c1.component.css'
})
export class E24C1Component {
  color: string = "";
  colorCompara: string = '';
  mensaje: string = '';

  

  mandamosColor(c: string){
    this.color = c;
    this.colorCompara = c;
    this.color = '';
    this.mensaje = '';
  }

  recibeMensaje(cad: string){
    this.mensaje = cad;
  }
}
