import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-ejer18-hijo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ejer18-hijo.component.html',
  styleUrl: './ejer18-hijo.component.css'
})
export class Ejer18HijoComponent {

  @Output() eventoComunicar = new EventEmitter<string>();

  realizarComunicacion(cadena: string){
    this.eventoComunicar.emit(cadena)
  }
}
