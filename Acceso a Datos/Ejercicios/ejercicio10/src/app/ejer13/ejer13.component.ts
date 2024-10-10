import { CommonModule } from '@angular/common';
import { Component, ElementRef, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-ejer13',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './ejer13.component.html',
  styleUrl: './ejer13.component.css'
})
export class Ejer13Component {

  @ViewChild('cuadrado') cuadrado!: ElementRef;

  color: string = "lime"
  mensaje: string = "";

cambiaColor(): void{
  console.log(this.cuadrado)
  console.log(this.color)
  if(this.color != this.cuadrado.nativeElement.style.backgroundColor){
    this.mensaje = "";
    this.cuadrado.nativeElement.style.backgroundColor = this.color;
    
  }else{
    this.mensaje = "IGUALES"
  }
}

}
