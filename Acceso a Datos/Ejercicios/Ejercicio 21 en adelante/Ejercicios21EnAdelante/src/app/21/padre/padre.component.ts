import { Component } from '@angular/core';
import { HijoComponent } from '../hijo/hijo.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-padre',
  standalone: true,
  imports: [HijoComponent, CommonModule, FormsModule],
  templateUrl: './padre.component.html',
  styleUrl: './padre.component.css'
})
export class PadreComponent {

  cadNumero: string=''; 
  numMandado: number = 0;

  numerosPadre: number[] = [];

  mandarDato(){      
    this.numMandado = parseInt(this.cadNumero)
    this.numerosPadre.push(this.numMandado);
    this.numMandado++;
    this.cadNumero = '';
  }
  recibiendoDato(n: number){
    console.log(n)
    this.numMandado=n
  }


  // ngOnChanges(){
  //   console.log(`Padre: ${this.numMandado}`)
  // }
}
