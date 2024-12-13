import { Component } from '@angular/core';
import { DropasigComponent } from '../../dropasig/dropasig.component';

@Component({
  selector: 'app-asignaturas',
  standalone: true,
  imports: [DropasigComponent],
  templateUrl: './asignaturas.component.html',
  styleUrl: './asignaturas.component.css'
})
export class AsignaturasComponent {

  titulo = 'Asignatura';
}
