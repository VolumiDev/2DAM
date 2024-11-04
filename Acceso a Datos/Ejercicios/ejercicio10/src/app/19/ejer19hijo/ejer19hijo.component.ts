import { ChangeDetectorRef, Component, Input, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-ejer19hijo',
  standalone: true,
  imports: [],
  templateUrl: './ejer19hijo.component.html',
  styleUrl: './ejer19hijo.component.css'
})
export class Ejer19hijoComponent {

  @Input() total: number = 0;
  @Input() cantidad: number = 0;

  
}
