import { Component, EventEmitter, Output } from '@angular/core';
import { ContadorComponent } from '../../contador/contador.component';

@Component({
  selector: 'app-incremento',
  standalone: true,
  imports: [],
  templateUrl: './incremento.component.html',
  styleUrl: './incremento.component.css'
})
export class IncrementoComponent {
  @Output() eventoIncrementar: EventEmitter<number> = new EventEmitter<number>();

  incrementar(){
    this.eventoIncrementar.emit(1);
  }
}
