import { Component } from '@angular/core';
import { HijoComponent } from '../hijo/hijo.component';

@Component({
  selector: 'app-padre',
  standalone: true,
  imports: [HijoComponent],
  templateUrl: './padre.component.html',
  styleUrl: './padre.component.css'
})
export class PadreComponent {

  listaNumerosPadre: number[] = [];
  isVisible: boolean = true;
  numeroEnviamosHijo: string = "";

  enviarNumeroAHijo(num: string){
    this.numeroEnviamosHijo = num;
    this.listaNumerosPadre.push(parseInt(num));
    this.isVisible=false;
  }
}
