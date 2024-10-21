import { ChangeDetectorRef, Component, Input, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-ejer19hijo',
  standalone: true,
  imports: [],
  templateUrl: './ejer19hijo.component.html',
  styleUrl: './ejer19hijo.component.css'
})
export class Ejer19hijoComponent {

  private precioTemp: number = 0;
  total: number = 0;
  cantidad: number = 0;

  @Input()
  set precio(valor: number){
    console.log('entramos')
    this.precioTemp = valor;
    this.acumular(valor)
    this.precioTemp = 0;  
  }
  get precioTemporal():number{
    return this.precioTemp
  }

  acumular(valor: number){
    this.total+=valor
    this.cantidad++;
  }
  
}
