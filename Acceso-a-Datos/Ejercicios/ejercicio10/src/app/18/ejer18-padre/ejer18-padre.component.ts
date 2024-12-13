import { Component } from '@angular/core';
import { Ejer18HijoComponent } from '../ejer18-hijo/ejer18-hijo.component';

@Component({
  selector: 'app-ejer18-padre',
  standalone: true,
  imports: [Ejer18HijoComponent],
  templateUrl: './ejer18-padre.component.html',
  styleUrl: './ejer18-padre.component.css'
})
export class Ejer18PadreComponent {
  datoComunicarPadre: string = "";
  realizaComunicacionHijo(mensaje:string){
    this.datoComunicarPadre = mensaje;
  }

}
