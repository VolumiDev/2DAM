import { Component } from '@angular/core';
import { HijoComponent } from '../hijo/hijo.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { E21Service } from '../e21.service';

@Component({
  selector: 'app-padre',
  standalone: true,
  imports: [HijoComponent, CommonModule, FormsModule],
  templateUrl: './padre.component.html',
  styleUrl: './padre.component.css',
  providers: [E21Service]
})
export class PadreComponent {
  numeroInput: number = 0;
  numeroActual: number = 0;

  numerosPadre: number[] = [];

  mostrarBoton: boolean = true;
  mostrarInput: boolean = true;

  enviarAlHijo() {
    this.numeroActual = this.numeroInput;
    this.numerosPadre.push(this.numeroActual);
    this.mostrarBoton = false;
    this.mostrarInput = false;
  }

  recibirDelHijo(numero: number) {
    this.numeroActual = numero + 1;
    this.mostrarBoton = true;
  }
}
