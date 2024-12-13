import { Component } from '@angular/core';

@Component({
  selector: 'app-dropasig',
  standalone: true,
  imports: [],
  templateUrl: './dropasig.component.html',
  styleUrl: './dropasig.component.css'
})
export class DropasigComponent {
  asignaturas = ['Acceso a datos', 'Gestion empresarial', 'Desarrollo de interfaces'];
}
