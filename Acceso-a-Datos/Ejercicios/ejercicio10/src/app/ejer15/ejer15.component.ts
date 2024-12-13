import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DerComponent } from './der/der.component';
import { IzqComponent } from './izq/izq.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-ejer15',
  standalone: true,
  imports: [FormsModule, DerComponent, IzqComponent, CommonModule],
  templateUrl: './ejer15.component.html',
  styleUrl: './ejer15.component.css'
})
export class Ejer15Component {

  dato: string = "";
  cadenaDelPadre: string[] = [];
  numerosDelPadre: number[] = [];
  numero: number = 0;
  enviar(){
    this.numero = Number(this.dato);
    if(isNaN(this.numero)){
      this.cadenaDelPadre.push(this.dato);
    }else{
      this.numerosDelPadre.push(this.numero)
    }
  }

}
