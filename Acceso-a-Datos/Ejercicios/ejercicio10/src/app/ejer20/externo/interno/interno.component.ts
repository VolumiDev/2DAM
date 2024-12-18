import { CommonModule } from '@angular/common';
import { Component, ElementRef, EventEmitter, Input, Output, ViewChild } from '@angular/core';

@Component({
  selector: 'app-interno',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './interno.component.html',
  styleUrl: './interno.component.css'
})
export class InternoComponent {
  @Input() color: string ="";
  @Input() visible?: boolean = false
  @Output() colorCambiado=new EventEmitter<string>();

  actualizarColor(nuevoColor: string){
    this.colorCambiado.emit(this.color);
    this.color=nuevoColor;
    this.visible=false;
  }


}
