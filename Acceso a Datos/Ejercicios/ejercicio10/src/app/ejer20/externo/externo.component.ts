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
  @ViewChild('containerExterno') containerExterno!: ElementRef;
  colorActual: string = 'red';
  nuevoColor: string = "";
  visible: boolean = true;
  
  envioPadreHijo(c: string){
    this.colorActual = this.nuevoColor;
    this.visible = false;
  }


}
