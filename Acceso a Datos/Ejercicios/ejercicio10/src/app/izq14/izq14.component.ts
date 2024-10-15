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

  @Output() vectorEvent = new EventEmitter<String[]>();
  item: string= "";  
  vector: string[] = [];

  insertar(){
    alert(this.item)
    this.vector.push(this.item);
  }

  enviarVector(){
    this.vectorEvent.emit(this.vector);
  }

}
