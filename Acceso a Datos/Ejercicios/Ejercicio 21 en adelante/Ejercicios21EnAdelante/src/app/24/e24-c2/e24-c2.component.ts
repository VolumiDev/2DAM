import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'e24-c2',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './e24-c2.component.html',
  styleUrl: './e24-c2.component.css'
})
export class E24C2Component {

  @Input()
  colorFondo: string = '';

  colorHijo: string = '';

  @Output()
  mandarColorPadre = new EventEmitter<string>()


  validaColor(c: string){
    if (this.colorFondo === c){
      this.mandarColorPadre.emit('Ese color ya ha salido, elije otro...');
    }else{
      this.colorFondo = c
      this.mandarColorPadre.emit('');
    }
  }
}
