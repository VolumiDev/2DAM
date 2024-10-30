import { Component, Input } from '@angular/core';
import { Ejer19hijoComponent } from '../ejer19hijo/ejer19hijo.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer19padre',
  standalone: true,
  imports: [Ejer19hijoComponent, CommonModule, FormsModule],
  templateUrl: './ejer19padre.component.html',
  styleUrl: './ejer19padre.component.css'
})
export class Ejer19padreComponent {

  totalImporte: number= 0;
  totalCantidad: number = 0;
  

  imgSrc: string = 'carrito.png'
  precioPadre: number = 0;

  arrayNombre: string[] = ['Cocacola', 'Fanta', 'Patatas', 'Ganchitos', 'Agua', 'Cerveza', 'Saladitos', 'Empanada', 'Sandwhich']
  arrayStock: number[] = [20,15, 10, 5, 10, 20, 40, 3, 10];
  arrayPrecio: number[] = [1.2, 1.2, 0.6, 0.5, 0.7, 1.2, 0.4, 5, 1.5];

  comprar(index: number){
    if(this.arrayStock[index] > 0){
      this.totalImporte += this.arrayPrecio[index];
      this.totalCantidad++;
      this.arrayStock[index]--;
    }
  }
 
}
