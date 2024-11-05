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
  numeroEnviamosHijo: number = 0;

  enviarNumeroAHijo(num: number){
    this.listaNumerosPadre.push(num);
    this.numeroEnviamosHijo = num + 1;
    this.isVisible=false;
  }
}
