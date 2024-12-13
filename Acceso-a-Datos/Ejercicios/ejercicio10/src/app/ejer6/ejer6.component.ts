import { Component } from '@angular/core';
import { Coche } from '../models/coche';
import { Moto } from '../models/moto';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-ejer6',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ejer6.component.html',
  styleUrl: './ejer6.component.css'
})
export class Ejer6Component {

  coche: Coche;
  moto: Moto;
  mensaje: String = "";

  constructor(){
    this.coche = new Coche("Audi", "S6", 260);
    this.moto = new Moto("Yamaha", "R1", 310);
  }

  // comparar(){
  //   if(this.moto.velMax > this.coche.velMax){
  //     this.mensaje = "La velocidad de la moto es mayor";
  //   }else if (this.moto.velMax > this.coche.velMax){
  //     this.mensaje = "La velocidad de la moto es mayor";
  //   }else{
  //     this.mensaje = "Las velocidades del coche y de la moto son iguales";
  //   }
  // }
}
