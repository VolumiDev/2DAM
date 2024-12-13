import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-decremento',
  standalone: true,
  imports: [],
  templateUrl: './decremento.component.html',
  styleUrl: './decremento.component.css'
})
export class DecrementoComponent {
  @Input() cont!: number;
  @Output() eventoDecrementar: EventEmitter<number> = new EventEmitter<number>();

  decrementar(){
    console.log("clicando:",this.cont)
    this.eventoDecrementar.emit(-1);
  }
}
