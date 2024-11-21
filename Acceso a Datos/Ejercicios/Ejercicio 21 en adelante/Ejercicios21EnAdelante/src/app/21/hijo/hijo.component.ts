import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output, SimpleChange } from '@angular/core';
import { E21Service } from '../e21.service';

@Component({
  selector: 'app-hijo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './hijo.component.html',
  styleUrl: './hijo.component.css',
  providers: [E21Service]
})
export class HijoComponent {
  @Input() numeroDelPadre: number = 0;
  @Input() mostrarBoton: boolean = false;
  
  @Output() numeroAlPadre = new EventEmitter<number>();
  numeroActual: number = 0;
  numerosHijo: number[] = [];
  mostrarBotonHijo: boolean = true;
  
  // ngOnChanges(change: SimpleChange) {
  //   console.log("On init del hijo")
  //   if(changes(this.numeroDelPadre)){

  //   }
  //   this.numeroActual = this.numeroDelPadre + 1;
  // }

  enviarAlPadre() {
    this.numeroActual = this.numeroDelPadre +1 ;
    this.numerosHijo.push(this.numeroActual);
    this.numeroAlPadre.emit(this.numeroActual);
    this.mostrarBotonHijo = false;
  }

}
