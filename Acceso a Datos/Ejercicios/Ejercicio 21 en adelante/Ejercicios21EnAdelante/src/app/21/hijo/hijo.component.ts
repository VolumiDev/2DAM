import { Component, EventEmitter, Input, Output, SimpleChange } from '@angular/core';

@Component({
  selector: 'app-hijo',
  standalone: true,
  imports: [],
  templateUrl: './hijo.component.html',
  styleUrl: './hijo.component.css'
})
export class HijoComponent {

  //clase : ChangeDetertorRef

  @Input() numRecibido: number = 0;
  @Output() eventEmitter = new EventEmitter<number>();

  //numero: number = parseInt(this.numRecibido);
  numeroHijo: number = 0;
  isVisibleHijo: boolean = false;
  ListaNumeroHijo: number[] = [];
  
  enviarDatoAPadre(num: number){
    this.eventEmitter.emit(this.numeroHijo);
    this.isVisibleHijo=true;
    this.ListaNumeroHijo.push(this.numeroHijo + 1);
  }



  ngOnChanges(changes: SimpleChange){
    this. numeroHijo = parseInt(this.numRecibido);
    if(this.numeroHijo == 0){
      this.isVisibleHijo = false;
    }else{
      this.isVisibleHijo = true;
    }
  }


}
