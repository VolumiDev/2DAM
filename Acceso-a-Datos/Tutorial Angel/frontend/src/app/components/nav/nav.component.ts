import { Component } from '@angular/core';
import { AsignaturasComponent } from '../botones/asignaturas/asignaturas.component';
import { ProfesoresComponent } from '../botones/profesores/profesores.component';
import { ColegiosComponent } from '../botones/colegios/colegios.component';

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [AsignaturasComponent, ProfesoresComponent, ColegiosComponent],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {

}
