import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-ejer17hijo',
  standalone: true,
  imports: [],
  templateUrl: './ejer17hijo.component.html',
  styleUrl: './ejer17hijo.component.css'
})
export class Ejer17hijoComponent {
  @Input() datoRecibido: string = "";
}
