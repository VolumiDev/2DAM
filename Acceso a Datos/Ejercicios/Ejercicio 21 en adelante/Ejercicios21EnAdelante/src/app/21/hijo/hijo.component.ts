import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-hijo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './hijo.component.html',
  styleUrl: './hijo.component.css'
})
export class HijoComponent {

  //clase : ChangeDetertorRef
  @Input()
  numRecibido: number = 0
  numMostrado: number = 0;
  numerosHijo: number[] = [];
  @Output() 
  public mandarPadre: EventEmitter<number> = new EventEmitter();

  enviamosAlPadre(){
    this.numerosHijo.push(this.numRecibido);
    this.numRecibido++;
    this.mandarPadre.emit(this.numRecibido);
  }

  ngOnChanges(){
    console.log(`Hijo: ${this.numRecibido}`)
  }

}
