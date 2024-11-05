import { Component, ElementRef, ViewChild } from '@angular/core';
import { InternoComponent } from './interno/interno.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-externo',
  standalone: true,
  imports: [InternoComponent, CommonModule],
  templateUrl: './externo.component.html',
  styleUrl: './externo.component.css'
})
export class ExternoComponent {
  colorActual: string = 'red';
  colorInterno: string = "";
  visible: boolean = true;

  actualizarColor(c: string){
    this.colorInterno = this.colorActual;
    this.colorActual = c;
    this.visible = false;
  }

  recibirColor(color: string){
    this.colorActual = color;
    this.visible = true;
  }
}
