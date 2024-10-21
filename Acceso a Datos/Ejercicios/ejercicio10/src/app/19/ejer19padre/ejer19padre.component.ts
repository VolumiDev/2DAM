import { Component } from '@angular/core';
import { Ejer19hijoComponent } from '../ejer19hijo/ejer19hijo.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ejer19padre',
  standalone: true,
  imports: [Ejer19hijoComponent, CommonModule],
  templateUrl: './ejer19padre.component.html',
  styleUrl: './ejer19padre.component.css'
})
export class Ejer19padreComponent {

  imgSrc: string = 'carrito.png'

  arrayNombre: string[] = ['Cocacola', 'Fanta', 'Patatas', 'Ganchitos', 'Agua', 'Cerveza', 'Saladitos', 'Empanada', 'Sandwhich']
  arrayStock: string[] = ['20', '15', '10', '5', '10', '20', '40', '3', '10'];
  arrayPrecio: string[] = ['1.2', '1.2', '0.6', '0.5', '0.7', '1.2', '0.4', '5', '1.5'];

}
