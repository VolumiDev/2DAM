import { ChangeDetectorRef, Component, Input, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-ejer19hijo',
  standalone: true,
  imports: [],
  templateUrl: './ejer19hijo.component.html',
  styleUrl: './ejer19hijo.component.css'
})
export class Ejer19hijoComponent {

<<<<<<< HEAD
  @Input() total: number = 0;
  @Input() cantidad: number = 0;

  
=======
@Input() totalCarrito: number = 0;
@Input() unidadesCarrito: number = 0;

>>>>>>> 2bd398e1d85049210e48a530021f91a4f191f262
}
