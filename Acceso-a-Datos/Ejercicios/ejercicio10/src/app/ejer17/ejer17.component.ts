import { Component } from '@angular/core';
import { Ejer17hijoComponent } from '../ejer17hijo/ejer17hijo.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer17',
  standalone: true,
  imports: [Ejer17hijoComponent, CommonModule, FormsModule],
  templateUrl: './ejer17.component.html',
  styleUrl: './ejer17.component.css'
})
export class Ejer17Component {

  datoComunicar: string = "";

  realizarComunicacion(cadena: string){
    this.datoComunicar = cadena;
  }
}
