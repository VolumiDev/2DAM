import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-izq14',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './izq14.component.html',
  styleUrl: './izq14.component.css'
})
export class Izq14Component {
  
  @Output() vectorEvent: EventEmitter<string[]> = new EventEmitter<string[]>();
  item: string= "";  
  vector: string[] = [];
  
  insertar(){
  }
  
  enviarVector(){
    this.vector.push(this.item);
    this.vectorEvent.emit(this.vector);
  }

}
