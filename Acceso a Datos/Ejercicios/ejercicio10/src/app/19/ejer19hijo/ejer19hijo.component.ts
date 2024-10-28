import { ChangeDetectorRef, Component, Input, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-ejer19hijo',
  standalone: true,
  imports: [],
  templateUrl: './ejer19hijo.component.html',
  styleUrl: './ejer19hijo.component.css'
})
export class Ejer19hijoComponent {

  total: number = 0;
  cantidad: number = 0;

 

  acumular(valor: number){
    this.total+=valor
    this.cantidad++;
  }
  
}
