import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer7',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ejer7.component.html',
  styleUrl: './ejer7.component.css'
})

export class Ejer7Component {
  
  frutas: string[] =  ["Banana", "Naranja", "Kiwi"]
  veces: number = 0;
  repetido: Array<string[]> = [];
  
  
  mostrar(): void {
    this.repetido = [];
    for (let i = 0; i < this.veces; i++) {
      this.repetido.push(this.frutas);   
    }

    console.log(this.repetido)
  }
    
  
}
