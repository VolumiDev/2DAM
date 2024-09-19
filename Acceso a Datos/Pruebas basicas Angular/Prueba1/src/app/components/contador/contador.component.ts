import { Component, Input } from '@angular/core';
import { IncrementoComponent } from '../botones/incremento/incremento.component';
import { DecrementoComponent } from '../botones/decremento/decremento.component';

@Component({
  selector: 'app-contador',
  standalone: true,
  imports: [IncrementoComponent, DecrementoComponent],
  templateUrl: './contador.component.html',
  styleUrl: './contador.component.css'
})
export class ContadorComponent {
  cont = 0

  actualizarCont(valor: number){
    this.cont += valor;
  }
}
